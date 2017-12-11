package covuni.a300cemcovunistudenthelper;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_main);
        // add toolbar as we removed the action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        // here we add the drawer icon
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //add to drawer layout
        drawer.addDrawerListener(toggle);

        // syncronise the icon in toolbar with state of drawer, becuase icon changes upon tapping
        toggle.syncState();
        //here we rgstr activity as a listener on nav view
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // here we usea FT to display the home fragment (the picture)
        Fragment fragment = new homeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_container, fragment);
        fragmentTransaction.commit();

    }

// stops app crashing on rotation
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        //4 fragments / 3 activities
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.nav_revision_notes) {
            fragment = new fragment_posts();

        } else if (id == R.id.nav_uni_buidlings_locations) {
            fragment = new UniBuildingsFragment();


        } else if (id == R.id.nav_pubs_clubs) {
            fragment = new PubsClubsFragment();

        } else if (id == R.id.nav_uni_twitter) {
            fragment = new TimeLineFragment();

        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(MainActivity.this, AboutSections.class);
            startActivity(intent);

        } else if (id == R.id.nav_locateme) {
            Intent intent = new Intent(MainActivity.this, LocateMeActivity.class);
            startActivity(intent);

        }else if (id == R.id.offlineNotes) {
            Intent intent = new Intent(MainActivity.this, OfflineNotesList.class);
            startActivity(intent);

        }
        //displays fragment replacing current one
        if (fragment !=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_container,fragment);
            fragmentTransaction.commit();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
