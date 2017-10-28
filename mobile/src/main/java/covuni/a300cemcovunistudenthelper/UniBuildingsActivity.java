package covuni.a300cemcovunistudenthelper;

import android.support.v4.app.Fragment;

/**
 * Created by Holmesy on 28/10/2017.
 */

public class UniBuildingsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new UniBuildingsFragment();

        }
    }
