package covuni.a300cemcovunistudenthelper;

import android.support.v4.app.Fragment;

/**
 * Created by Holmesy on 29/10/2017.
 */

public class UniBuildingsListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new UniBuildingsListFragment();

        }
    }