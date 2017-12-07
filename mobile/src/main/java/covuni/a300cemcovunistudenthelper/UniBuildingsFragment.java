package covuni.a300cemcovunistudenthelper;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
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

    public static int REQUEST_LOCATION = 1;



    private GoogleMap googleMap;
    MapView mapView;
    View view;
    private Location location;
    private GoogleApiClient client;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pubs_clubs, container, false);
        return view;
    }






    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        client = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(@Nullable Bundle connectionHint) {
                        getActivity().invalidateOptionsMenu();


                    }

                    @Override
                    public void onConnectionSuspended(int i) {

                    }
                })
                .addApi(LocationServices.API)
                .build();


    }




    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) this.view.findViewById(R.id.map);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.location);
        searchItem.setEnabled(client.isConnected());
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


    public void onMapReady(GoogleMap Map) {
        this.googleMap = Map;



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





        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(theHub, 15));
        this.googleMap.addMarker(new MarkerOptions().position(theHub).title("The Hub"));
        this.googleMap.addMarker(new MarkerOptions().position(ecBuilding).title("Engineering and Computing"));
        this.googleMap.addMarker(new MarkerOptions().position(library).title("The Library"));
        this.googleMap.addMarker(new MarkerOptions().position(studentCenter).title("The Student Center"));
        this.googleMap.addMarker(new MarkerOptions().position(Alma).title("Alma"));
        this.googleMap.addMarker(new MarkerOptions().position(ArmstrongSiddely).title("Armstrong Siddely"));
        this.googleMap.addMarker(new MarkerOptions().position(Buggati).title("Buggati"));
        this.googleMap.addMarker(new MarkerOptions().position(charlesWard).title("Charles Ward"));
        this.googleMap.addMarker(new MarkerOptions().position(ellenTerry).title("Ellen Terry"));
        this.googleMap.addMarker(new MarkerOptions().position(allenBerry).title("Allen Berry"));
        this.googleMap.addMarker(new MarkerOptions().position(georgeEliot).title("George Eliot"));
        this.googleMap.addMarker(new MarkerOptions().position(grahamSutherland).title("Graham Sutherland"));
        this.googleMap.addMarker(new MarkerOptions().position(jaguar).title("Jaguar"));
        this.googleMap.addMarker(new MarkerOptions().position(jamesStarley).title("James Starley"));
        this.googleMap.addMarker(new MarkerOptions().position(mauriceFoss).title("Maurice Foss"));
        this.googleMap.addMarker(new MarkerOptions().position(multiStoryCarPark).title("MultiStory car park"));
        this.googleMap.addMarker(new MarkerOptions().position(prioryBuilding).title("Priory Building"));
        this.googleMap.addMarker(new MarkerOptions().position(richardCrossman).title("Richard Crossman"));
        this.googleMap.addMarker(new MarkerOptions().position(sirJohnLaing).title("Sir John Laing"));
        this.googleMap.addMarker(new MarkerOptions().position(sirWilliamLyons).title("Sir William Morris"));
        this.googleMap.addMarker(new MarkerOptions().position(whiteFrairs).title("Whitefrairs"));
        this.googleMap.addMarker(new MarkerOptions().position(williamMorris).title("William Morris"));
        this.googleMap.addMarker(new MarkerOptions().position(sportsCenter).title("Sports Center"));

    }
}