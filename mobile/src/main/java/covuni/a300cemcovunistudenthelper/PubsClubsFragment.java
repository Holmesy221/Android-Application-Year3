package covuni.a300cemcovunistudenthelper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
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
        mView = inflater.inflate(R.layout.activity_pubs_clubs, container, false);
        return mView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
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
        MapsInitializer.initialize(getContext());

        // Add a marker in Sydney and move the camera
        LatLng covCity = new LatLng(52.4083001, -1.512276);

        mMap.addMarker(new MarkerOptions().position(covCity).title("Coventry City Center"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(covCity, 15));
    }
}
