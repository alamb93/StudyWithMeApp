package studyup.studyup;

import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static studyup.studyup.R.id.activity_request;
import static studyup.studyup.R.id.editText;
import static studyup.studyup.R.id.editText10;

public class request extends FragmentActivity
        implements OnMapReadyCallback {


    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.class_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(35.904613, -79.0193))
                .title("Marker"));
    }

    public void onRequestClick(View view) {
        EditText commentEdit   = (EditText)findViewById(R.id.editText10);
        String comm = commentEdit.getText().toString();
        Spinner classSelect = (Spinner)findViewById(R.id.spinner);
        String clas = classSelect.getSelectedItem().toString();
        swipe req1 = new swipe(35.904613, -79.0193, clas, comm, "Maggie");

        mDatabase.child(req1.user).setValue(req1);
    }
}