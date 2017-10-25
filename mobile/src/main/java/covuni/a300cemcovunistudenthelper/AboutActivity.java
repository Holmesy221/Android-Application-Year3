package covuni.a300cemcovunistudenthelper;

import android.support.v4.app.Fragment;

/**
 * Created by Holmesy on 21/10/2017.
 */

public class AboutActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new AboutFragment();
    }
}