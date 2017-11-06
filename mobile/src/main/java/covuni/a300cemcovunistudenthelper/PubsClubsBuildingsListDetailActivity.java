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

    public static final String PUB_BUILDING_DETAILS = "pubId";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubs_building_list);

        int pubId = (Integer)getIntent().getExtras().get(PUB_BUILDING_DETAILS);
        String pubName = PubsClubsList.pubBuildings[pubId].getName();
        TextView textView = (TextView)findViewById(R.id.pub_building_name);
        textView.setText(pubName);


        int pubImage = PubsClubsList.pubBuildings[pubId].getImage();
        ImageView imageView = (ImageView)findViewById(R.id.pub_buildings_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pubImage));
        imageView.setContentDescription(pubName);


    }

}
