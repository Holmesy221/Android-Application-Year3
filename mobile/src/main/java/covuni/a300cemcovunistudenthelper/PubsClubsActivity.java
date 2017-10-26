package covuni.a300cemcovunistudenthelper;

import android.support.v4.app.Fragment;

/**
 * Created by Holmesy on 26/10/2017.
 */

public class PubsClubsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new PubsClubsFragment();
    }
}

