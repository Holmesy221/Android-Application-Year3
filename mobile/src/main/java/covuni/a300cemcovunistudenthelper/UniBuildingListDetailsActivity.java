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

    public static final String UNI_BUILDING_DETAILS = "uniId";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_building_list);

        int uniId = (Integer)getIntent().getExtras().get(UNI_BUILDING_DETAILS);
        String uniName = BuildingList.buildings[uniId].getName();
        TextView textView = (TextView)findViewById(R.id.uni_buildings_name);
        textView.setText(uniName);
        String uniBody = BuildingList.buildings[uniId].getBody();
        TextView textView1 = (TextView)findViewById(R.id.uni_buildings_body);
        textView1.setText(uniBody);
        String uniAddress = BuildingList.buildings[uniId].getAddress();
        TextView textView2 = (TextView)findViewById(R.id.address);
        textView2.setText(uniAddress);

        int uniImage = BuildingList.buildings[uniId].getImage();
        ImageView imageView = (ImageView)findViewById(R.id.uni_buildings_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, uniImage));
        imageView.setContentDescription(uniName);


    }


}
