package covuni.a300cemcovunistudenthelper;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Holmesy on 06/11/2017.
 */

public class PubsClubsBuildingsListDetailActivity extends AppCompatActivity {



    //constant to pass id as xtra info in the intent
    public static final String PUB_BUILDING_DETAILS = "pubId";

    TextView textView;
    ImageView imageView;
    String pubName, pubBody, pubAddress;
    int pubImage, pubId;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubs_building_list);


        /*
        here we use the id to populate the imageviews and textviews
         */
        //get the selected pub/club the user choose from the intent
        pubId = (Integer)getIntent().getExtras().get(PUB_BUILDING_DETAILS);
        pubName = PubsClubsList.pubBuildings[pubId].getName();
        textView = (TextView)findViewById(R.id.pub_building_name);
        textView.setText(pubName);

        pubBody = PubsClubsList.pubBuildings[pubId].getBody();
        textView = (TextView)findViewById(R.id.pub_building_body);
        textView.setText(pubBody);

        pubAddress = PubsClubsList.pubBuildings[pubId].getAddress();
        textView = (TextView)findViewById(R.id.pub_building_address);
        textView.setText(pubAddress);



         pubImage = PubsClubsList.pubBuildings[pubId].getImage();
        imageView = (ImageView)findViewById(R.id.pub_buildings_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pubImage));
        imageView.setContentDescription(pubName);


    }

}
