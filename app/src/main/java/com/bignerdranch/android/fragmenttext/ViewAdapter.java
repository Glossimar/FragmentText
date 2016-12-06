package com.bignerdranch.android.fragmenttext;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2016/12/6.
 */

public class ViewAdapter extends FragmentPagerAdapter {
    private List< View> viewtlist;
    private List<String> listtitle;

    public ViewAdapter(FragmentManager fm,List<String> listtitle){
        super(fm);
        this.listtitle=listtitle;

    }

    @Override
    public int getCount() {
        return listtitle.size();
    }


    public CharSequence getPageTitle(int position) {

        return listtitle.get(position % listtitle.size());
    }


    @Override
    public Fragment getItem(int position) {
        if(position==1){
            return new FragmentTwo();
        }else {
            return new FragmentOne();
        }
    }
}
