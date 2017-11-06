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

public class PubsClubsFragment extends Fragment implements OnMapReadyCallback {


    // Followed TUT from https://www.youtube.com/watch?v=0dToEEuPL9Y for a part of it.

    private GoogleMap mMap;
    MapView mMapView;
    View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        mView = inflater.inflate(R.layout.activity_pubs_clubs, container, false);
        return mView;

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
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
                Fragment newFragment = new PubsClubsListFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, newFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            default:
                return super.onOptionsItemSelected(item);



        }


    }


    @Override
public void onViewCreated(View view,  Bundle savedInstanceState){
    super.onViewCreated(view, savedInstanceState);
    mMapView = (MapView) mView.findViewById(R.id.map);
    if (mMapView != null){
        mMapView.onCreate(null);
        mMapView.onResume();
        mMapView.getMapAsync(this);
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

    //TODO: Populate with local pubs and clubs

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng covCity = new LatLng(52.4083001, -1.512276);
        LatLng cosmos = new LatLng(52.409992, -1.512689);
        LatLng slugLettuce = new LatLng(52.408013, -1.508709);
        LatLng flyingStandard = new LatLng(52.409068, -1.509493);
        LatLng nandos = new LatLng(52.409294, -1.509047);
        LatLng hansDyansty = new LatLng(52.409380, -1.507867);
        LatLng earlMercia = new LatLng(52.407084, -1.508628);
        LatLng drapersBar = new LatLng(52.407031, -1.507065);
        LatLng ivyHouse = new LatLng(52.406723, -1.505650);
        LatLng phoenix = new LatLng(52.406661, -1.503966);
        LatLng quidsInn = new LatLng(52.406624, -1.503203);
        LatLng kasbah = new LatLng(52.412904, -1.503281);
        LatLng townWallTavern = new LatLng(52.409748, -1.515141);
        LatLng artisianBarGrill = new LatLng(52.409846, -1.516681);
        LatLng townCrier = new LatLng(52.407932, -1.515839);
        LatLng oakInn = new LatLng(52.406613, -1.503428);


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(covCity, 15));
        mMap.addMarker(new MarkerOptions().position(covCity).title("Coventry City Center"));
        mMap.addMarker(new MarkerOptions().position(cosmos).title("Cosmos Bar and Restaurant"));
        mMap.addMarker(new MarkerOptions().position(slugLettuce).title("Slug and Lettuce Bar and Restaurant"));
        mMap.addMarker(new MarkerOptions().position(flyingStandard).title("Flying Standard Bar and Restaurant"));
        mMap.addMarker(new MarkerOptions().position(nandos).title("Nandos Restaurant"));
        mMap.addMarker(new MarkerOptions().position(hansDyansty).title("Hans Dyansty Restaurant"));
        mMap.addMarker(new MarkerOptions().position(earlMercia).title("The Earl of Mercia Bar and Restaurant"));
        mMap.addMarker(new MarkerOptions().position(drapersBar).title("Drapers Bar and Kitchen"));
        mMap.addMarker(new MarkerOptions().position(ivyHouse).title("Ivy House"));
        mMap.addMarker(new MarkerOptions().position(phoenix).title("Phoenix Bar"));
        mMap.addMarker(new MarkerOptions().position(quidsInn).title("Quidds inn Bar"));
        mMap.addMarker(new MarkerOptions().position(kasbah).title("Kasbah NighClub"));
        mMap.addMarker(new MarkerOptions().position(townWallTavern).title("Town Wall Tavern"));
        mMap.addMarker(new MarkerOptions().position(artisianBarGrill).title("The Artisian Bar and Grill"));
        mMap.addMarker(new MarkerOptions().position(townCrier).title("The Town Crier"));
        mMap.addMarker(new MarkerOptions().position(oakInn).title("The Oak Inn"));

    }
}
