package covuni.a300cemcovunistudenthelper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Holmesy on 07/12/2017.
 */

public class ResourcesFragment extends Fragment {
    public ResourcesFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.resources_fragment, container, false);


    }

}
