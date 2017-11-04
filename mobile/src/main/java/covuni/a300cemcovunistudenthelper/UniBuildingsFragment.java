package covuni.a300cemcovunistudenthelper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Holmesy on 28/10/2017.
 */

public class UniBuildingsFragment extends Fragment implements OnMapReadyCallback {


    // Followed TUT from https://www.youtube.com/watch?v=0dToEEuPL9Y for a part of it.

    private GoogleMap mMap;
    MapView mMapView;
    View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_pubs_clubs, container, false);
        return mView;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView = (MapView) mView.findViewById(R.id.map);
        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.uni_info:
            Fragment newFragment = new UniBuildingsListFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, newFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                default:
                    return super.onOptionsItemSelected(item);



        }


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng theHub = new LatLng(52.407525, -1.504663);
        LatLng ecBuilding = new LatLng(52.405305, -1.500118);
        LatLng library = new LatLng(52.405937, -1500712);
        LatLng studentCenter = new LatLng(52.405021, -1500780);
        LatLng allenBerry = new LatLng(52.407983, -1.505718);
        LatLng Alma = new LatLng(52.409911, -1.500390);
        LatLng ArmstrongSiddely = new LatLng(52.407487, -1.501196);
        LatLng Buggati = new LatLng(52.407502, -1.503315);
        LatLng charlesWard = new LatLng(52.408537, -1.505110);
        LatLng ellenTerry = new LatLng(52.406493, -1.504423);
        LatLng georgeEliot = new LatLng(52.408014, -1.50493);
        LatLng grahamSutherland = new LatLng(52.406927, -1.503062);
        LatLng jaguar = new LatLng(52.406996, -1.501109);
        LatLng jamesStarley = new LatLng(52.407689, -1.504095);
        LatLng mauriceFoss = new LatLng(52.407964, -1.503370);
        LatLng multiStoryCarPark = new LatLng(52.406222, -1.499679);
        LatLng richardCrossman = new LatLng(52.406673, -1.505223);
        LatLng sirJohnLaing = new LatLng(52.405848, -1.505070);
        LatLng sirWilliamLyons = new LatLng(52.407259, -1.499744);
        LatLng whiteFrairs = new LatLng(52.406117, -1.504147);
        LatLng williamMorris = new LatLng(52.406598, -1.501311);
        LatLng prioryBuilding = new LatLng(52.408601, -1.506145);
        LatLng sportsCenter = new LatLng(52.405717, -1.504179);





        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(theHub, 15));
        mMap.addMarker(new MarkerOptions().position(theHub).title("The Hub"));
        mMap.addMarker(new MarkerOptions().position(ecBuilding).title("Engineering and Computing"));
        mMap.addMarker(new MarkerOptions().position(library).title("The Library"));
        mMap.addMarker(new MarkerOptions().position(studentCenter).title("The Student Center"));
        mMap.addMarker(new MarkerOptions().position(Alma).title("Alma"));
        mMap.addMarker(new MarkerOptions().position(ArmstrongSiddely).title("Armstrong Siddely"));
        mMap.addMarker(new MarkerOptions().position(Buggati).title("Buggati"));
        mMap.addMarker(new MarkerOptions().position(charlesWard).title("Charles Ward"));
        mMap.addMarker(new MarkerOptions().position(ellenTerry).title("Ellen Terry"));
        mMap.addMarker(new MarkerOptions().position(allenBerry).title("Allen Berry"));
        mMap.addMarker(new MarkerOptions().position(georgeEliot).title("George Eliot"));
        mMap.addMarker(new MarkerOptions().position(grahamSutherland).title("Graham Sutherland"));
        mMap.addMarker(new MarkerOptions().position(jaguar).title("Jaguar"));
        mMap.addMarker(new MarkerOptions().position(jamesStarley).title("James Starley"));
        mMap.addMarker(new MarkerOptions().position(mauriceFoss).title("Maurice Foss"));
        mMap.addMarker(new MarkerOptions().position(multiStoryCarPark).title("MultiStory car park"));
        mMap.addMarker(new MarkerOptions().position(prioryBuilding).title("Priory Building"));
        mMap.addMarker(new MarkerOptions().position(richardCrossman).title("Richard Crossman"));
        mMap.addMarker(new MarkerOptions().position(sirJohnLaing).title("Sir John Laing"));
        mMap.addMarker(new MarkerOptions().position(sirWilliamLyons).title("Sir William Morris"));
        mMap.addMarker(new MarkerOptions().position(whiteFrairs).title("Whitefrairs"));
        mMap.addMarker(new MarkerOptions().position(williamMorris).title("William Morris"));
        mMap.addMarker(new MarkerOptions().position(sportsCenter).title("Sports Center"));

    }
}