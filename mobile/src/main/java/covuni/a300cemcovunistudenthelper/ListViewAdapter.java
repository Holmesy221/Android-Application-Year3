package covuni.a300cemcovunistudenthelper;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Holmesy on 03/12/2017.
 */

public class ListViewAdapter extends ArrayAdapter<Post> {
    private Activity context;
    List<Post> posts;
    TextView textView;
    View view;


    public ListViewAdapter(Activity context, List<Post> posts) {
        super(context, R.layout.listview_posts, posts);
        this.context = context;
        this.posts = posts;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        view = inflater.inflate(R.layout.listview_posts, null, true);

        textView = (TextView) view.findViewById(R.id.listview_textview);


        Post post = posts.get(position);
        textView.setText(post.getPost());

        return view;
    }
}

