package covuni.a300cemcovunistudenthelper;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Holmesy on 21/10/2017.
 */

public class AboutFragment extends Fragment {
    public AboutFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
final MediaPlayer messageDev = MediaPlayer.create(getActivity(), R.raw.message);
        Button button = (Button) view.findViewById(R.id.audioButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageDev.start();
                Snackbar.make(v, "Message playing", Snackbar.LENGTH_LONG).show();
            }
        });




        return view;
    }
}