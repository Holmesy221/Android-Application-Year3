package covuni.a300cemcovunistudenthelper;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Holmesy on 03/12/2017.
 */


/** To help me build the Firebase database I used these following resources:
 * https://www.youtube.com/watch?v=jEmq1B1gveM&index=2&list=PLk7v1Z2rk4hj6SDHf_YybDeVhUT9MXaj1
 * https://firebase.google.com/docs/database/android/read-and-write#listen_for_value_events -> https://github.com/firebase/quickstart-android
 */


public class fragment_posts extends Fragment {

    public fragment_posts(){}

    View view;
    EditText editText;
    Button button;
    DatabaseReference databaseReference;
    ListView listView;
    List<Post> posts;
    ListViewAdapter mListViewAdapter;




private static final String REQUIRED = "Required";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_posts, container, false);
        editText = (EditText) view.findViewById(R.id.edit_post);
        button = (Button) view.findViewById(R.id.button_post);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        listView = (ListView) view.findViewById(R.id.postListview);
        posts = new ArrayList<>();



        // inserting into the DB.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posts = editText.getText().toString().trim();
                if (!TextUtils.isEmpty(posts)) {
                    String id = databaseReference.push().getKey();
                    Post post = new Post(id, posts);
                    databaseReference.child(id).setValue(post);
                    Snackbar.make(v, "Post added!", Snackbar.LENGTH_LONG).show();
                } else {
                    editText.setError(REQUIRED);


                }
            }
        });
        return view;
    }


        @Override
        public  void onStart(){
            super.onStart();

            databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                posts.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Post post = postSnapshot.getValue(Post.class);
                    posts.add(post);

                }

               ListViewAdapter adapter = new ListViewAdapter(getActivity(), posts);
                listView.setAdapter(adapter);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }


}
