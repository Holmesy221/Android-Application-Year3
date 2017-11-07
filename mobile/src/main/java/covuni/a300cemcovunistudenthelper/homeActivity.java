package covuni.a300cemcovunistudenthelper;

import android.support.v4.app.Fragment;

/**
 * Created by Holmesy on 07/11/2017.
 */

public class homeActivity extends SingleFragmentActivity {
@Override
protected Fragment createFragment() {
        return new homeFragment();
        }
}
