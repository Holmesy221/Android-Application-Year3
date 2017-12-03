package covuni.a300cemcovunistudenthelper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

    View mView;
    EditText mEditText;
    Button mPost;
    DatabaseReference mDatabaseReference;
    ListView mListView;
    List<Post> posts;
    ListViewAdapter mListViewAdapter;




private static final String REQUIRED = "Required";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_posts, container, false);
        mEditText = (EditText) mView.findViewById(R.id.edit_post);
        mPost = (Button) mView.findViewById(R.id.button_post);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mListView = (ListView) mView.findViewById(R.id.postListview);
        posts = new ArrayList<>();



        // inserting into the DB.
        mPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posts = mEditText.getText().toString().trim();
                if (!TextUtils.isEmpty(posts)) {
                    String id = mDatabaseReference.push().getKey();
                    Post post = new Post(id, posts);
                    mDatabaseReference.child(id).setValue(post);
                    Toast.makeText(getActivity(), " Post added", Toast.LENGTH_LONG).show();
                } else {
                    mEditText.setError(REQUIRED);


                }
            }
        });
        return mView;
    }


        @Override
        public  void onStart(){
            super.onStart();

            mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                posts.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Post post = postSnapshot.getValue(Post.class);
                    posts.add(post);

                }

               ListViewAdapter adapter = new ListViewAdapter(getActivity(), posts);
                mListView.setAdapter(adapter);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }


}
