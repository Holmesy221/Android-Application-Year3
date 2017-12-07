package covuni.a300cemcovunistudenthelper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Holmesy on 07/12/2017.
 */

public class PageAdapter extends FragmentPagerAdapter {

    private Context context;
    public PageAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public int getCount(){
        return 3;
    }

    @Override

    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new AboutFragment();
            case 1:
                return new AboutMeFragment();
            case 2:
                return new ResourcesFragment();
            default:
                return null;
        }
    }


    @Override
    public CharSequence getPageTitle(int position){

        switch(position){
            case 0:
                return context.getString(R.string.about_fragment);
            case 1:
                return context.getString(R.string.about_me);
            case 2:
                return context.getString(R.string.resources);
            default:
                return null;

        }


    }







}
