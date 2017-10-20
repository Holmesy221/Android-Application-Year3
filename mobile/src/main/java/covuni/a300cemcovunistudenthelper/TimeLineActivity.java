package covuni.a300cemcovunistudenthelper;

import android.support.v4.app.Fragment;

/**
 * Created by Holmesy on 20/10/2017.
 */

public class TimeLineActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new TimeLineFragment();
    }
}