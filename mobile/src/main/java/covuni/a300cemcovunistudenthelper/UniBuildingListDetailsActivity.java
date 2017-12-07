package covuni.a300cemcovunistudenthelper;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Holmesy on 31/10/2017.
 */

public class UniBuildingListDetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    String uniName, uniBody, uniAddress;
    int uniId, uniImage;




    public static final String UNI_BUILDING_DETAILS = "uniId";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_building_list);

         uniId = (Integer)getIntent().getExtras().get(UNI_BUILDING_DETAILS);
        uniName = BuildingList.buildings[uniId].getName();
        textView = (TextView)findViewById(R.id.uni_buildings_name);
        textView.setText(uniName);

         uniBody = BuildingList.buildings[uniId].getBody();
        textView = (TextView)findViewById(R.id.uni_buildings_body);
        textView.setText(uniBody);

         uniAddress = BuildingList.buildings[uniId].getAddress();
        textView = (TextView)findViewById(R.id.address);
        textView.setText(uniAddress);

         uniImage = BuildingList.buildings[uniId].getImage();
        imageView = (ImageView)findViewById(R.id.uni_buildings_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, uniImage));
        imageView.setContentDescription(uniName);


    }


}
