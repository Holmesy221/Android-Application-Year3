package covuni.a300cemcovunistudenthelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import static covuni.a300cemcovunistudenthelper.PubsClubsList.pubBuildings;

/**
 * Created by Holmesy on 06/11/2017.
 */

public class PubsClubsListFragment extends Fragment {
public PubsClubsListFragment(){}

    RecyclerView mRecyclerView;
    RecylerViewAdapter recylerViewAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_pubs_clubs_list, container, false);


        /*
        Adding the dataset to the two arrays
         */

        String[] buildingNames = new String[pubBuildings.length];
        for (int i = 0;
             i < buildingNames.length; i++) {
            buildingNames[i] = pubBuildings[i].getName();
        }

        int[] buildingImages = new int[pubBuildings.length];
        for (int i = 0;
             i < buildingImages.length; i++) {
            buildingImages[i] = pubBuildings[i].getImage();
        }

        setHasOptionsMenu(true);

        //layout manager to determine the layout - I use GRID - with two columns
        layoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(layoutManager);

        //specify the adapter by passing the arrays to it
        recylerViewAdapter = new RecylerViewAdapter(buildingNames,buildingImages);
        mRecyclerView.setAdapter(recylerViewAdapter);

        // implements the onclick listener to click on a selected pub/club to take to new activity
        //gets the id
        recylerViewAdapter.setListener(new RecylerViewAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PubsClubsBuildingsListDetailActivity.class);
                intent.putExtra(PubsClubsBuildingsListDetailActivity.PUB_BUILDING_DETAILS,position);
                getActivity().startActivity(intent);
            }
        });


        return mRecyclerView;

    }








    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.uni_buildings_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.uni_loc:
                Fragment fragment = new PubsClubsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            default:
                return super.onOptionsItemSelected(item);


        }

    }
}