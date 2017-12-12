package covuni.a300cemcovunistudenthelper;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.List;

/**
 * Created by Holmesy on 07/12/2017.
 */


//Tutorial Sample code
public class LocateMeActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    public static int REQUEST_LOCATION = 1;
    static public Location location;
    static private OnCurrentLocationChangeListener onCurrentLocationChangeListener;
    Button button;
    TextView output;

    protected Button locateButton;
    protected GoogleApiClient googleApiClient;
    protected LocationRequest locationRequest;
    protected Geocoder geocoder;


    public static void setOnCurrentLocationChangeListener(OnCurrentLocationChangeListener
                                                                  onCurrentLocationChangeListener) {
        LocateMeActivity.onCurrentLocationChangeListener = onCurrentLocationChangeListener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locate_me_actvity);
        locateButton = (Button) findViewById(R.id.locateMe);
        button = (Button) findViewById(R.id.locatefrag);
        output = (TextView) findViewById(R.id.output);
        locateButton.setEnabled(false);
        output.setText("");
        button.setEnabled(false);

        //Here we allow googleApi to connect to remote services, with two interfaces the class implements

        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        //request location, and how often it updates
        locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }


//here we check if have permission to access location
// also for permission for request location
//lastly specify the adapter for onLocationChanged
    @Override
    public void onConnected(@Nullable Bundle connectionHint) {

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {


            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION);
        } else {
            location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
        }
    }
    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_LOCATION) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onConnected(null);
            }
        }
    }

    //updates UI if location changed
    @Override
    public void onLocationChanged(Location location) {
        this.location = location;
        if (onCurrentLocationChangeListener != null) {
            onCurrentLocationChangeListener.onCurrentLocationChange(location);
        }
    }

    //Stop and start the Location services

    public void onStartClicked(View v) {
        if (!googleApiClient.isConnected()) {
            googleApiClient.connect();
            locateButton.setEnabled(true);
            button.setEnabled(true);
            output.setText("Now Hit the Locate me button to find your location");
        } else {
            googleApiClient.disconnect();
            locateButton.setEnabled(false);
            button.setEnabled(false);

            output.setText("You've stopped Locate Me!.");
        }
    }


    // Method to display the location converted into a street address using geocoder
    public void onLocateClicked(View v) {
        geocoder = new Geocoder(this);
        try {
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

            if (addresses.size() == 1) {
                Address address = addresses.get(0);
                StringBuilder addressLines = new StringBuilder();
                if (address.getMaxAddressLineIndex() > 0) {
                    for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                        addressLines.append(address.getAddressLine(i) + "\n" );
                    }
                } else {
                    addressLines.append(address.getAddressLine(0));
                }
                output.setText(addressLines);
            } else {
                output.setText("WARNING! Geocoder returned more than 1 addresses!");
            }
        } catch (Exception e) {
            output.setText("WARNING! Geocoder.getFromLocation() didn't work!");
        }
    }

    public void onMapFragClicked(View v) {
        startActivity(new Intent(this, LocateMapFragment.class));
    }


    public interface OnCurrentLocationChangeListener {
        void onCurrentLocationChange(Location location);



   }
}