package covuni.a300cemcovunistudenthelper;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import static covuni.a300cemcovunistudenthelper.R.id.mapFrag;


/**
 * Created by Holmesy on 08/12/2017.
 */

public class LocateMapFragment extends FragmentActivity implements OnMapReadyCallback, LocateMeActivity.OnCurrentLocationChangeListener {

    public LocateMapFragment() {
    }

    private GoogleMap map;
    private Location location;
    private LatLng latLng;
    View view;
    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locate_map_fragment);
        LocateMeActivity.setOnCurrentLocationChangeListener(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(mapFrag);
        mapFragment.getMapAsync(this);
    }


// here we add the the location to the map using a marker
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        UiSettings mUiSettings = map.getUiSettings();
        mUiSettings.setZoomControlsEnabled(true);

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        location = LocateMeActivity.location;
        latLng = new LatLng(location.getLatitude(), location.getLongitude());
        map.addMarker(new MarkerOptions().position(latLng).title("You are here"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));


    }





    @Override
    public void onCurrentLocationChange(Location location) {
        this.location = location;
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
    }
}