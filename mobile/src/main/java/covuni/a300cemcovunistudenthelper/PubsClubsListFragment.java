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

    RecyclerView mRecyclerView;
    RecylerViewAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View view = inflater.inflate(R.layout.fragment_uni_buildings_list, container, false);
        setHasOptionsMenu(true);
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_pubs_clubs_list, container, false);

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
        mLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecylerViewAdapter(buildingNames,buildingImages);
        mRecyclerView.setAdapter(mAdapter);
        // mRecyclerView.setHasFixedSize(true);
        mAdapter.setListener(new RecylerViewAdapter.Listener() {
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