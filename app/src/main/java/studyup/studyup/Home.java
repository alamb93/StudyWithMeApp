package studyup.studyup;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView nameField = (TextView) findViewById(R.id.textView4);
        nameField.setText("Nardos");

        TextView classField = (TextView) findViewById(R.id.textView5);
        classField.setText("Class 5");

        TextView commField = (TextView) findViewById(R.id.textView6);
        commField.setText("I need help wit my homework");
    }

}
