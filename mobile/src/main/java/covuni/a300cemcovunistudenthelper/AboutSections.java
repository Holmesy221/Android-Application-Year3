package covuni.a300cemcovunistudenthelper;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by Holmesy on 07/12/2017.
 */

public class AboutSections extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_sections);


        // ViewPager layout
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // specify adapter for correct fragment on swipes
        PageAdapter adapter = new PageAdapter(this, getSupportFragmentManager());

        //set adapter
        viewPager.setAdapter(adapter);

        //tab layout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //set tabLayout
        tabLayout.setupWithViewPager(viewPager);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
