package studyup.studyup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("swipes");
    swipe post = new swipe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                post = snapshot.getValue(swipe.class);
                Query query = ref.orderByChild("user").limitToLast(10);
                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Data is ordered by increasing height, so we want the first entry
                        DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                        post = firstChild.getValue(swipe.class);
                        System.out.println(firstChild.getKey());
                        //post = firstChild.getValue(swipe.class);
                        TextView nameField = (TextView) findViewById(R.id.textView4);
                        nameField.setText(post.user);

                        TextView classField = (TextView) findViewById(R.id.textView5);
                        classField.setText(post.classid);

                        TextView commField = (TextView) findViewById(R.id.textView6);
                        commField.setText(post.comment);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // ...
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // ...
            }
        });
    }
}
