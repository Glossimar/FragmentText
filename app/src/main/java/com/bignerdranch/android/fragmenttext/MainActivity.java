package com.bignerdranch.android.fragmenttext;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    List<String> titlelist;
    List<View> mViews;
    View view1,view2;
    ViewAdapter mAdapter;
    LayoutInflater mLayoutInflater;
    ViewPager mViewPager;
     List<Fragment> mFragment;

   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiColors();

    }




    private void  intiColors(){

        mFragment=new ArrayList<Fragment>();
        mFragment.add(new FragmentOne());
        mFragment.add(new FragmentTwo());

        mLayoutInflater = getLayoutInflater();
        view1= mLayoutInflater.inflate(R.layout.page2,null);
        view2 = mLayoutInflater.inflate(R.layout.content,null);

        mViews=new ArrayList<View>();
        mViews.add(view1);
        mViews.add(view2);

        titlelist=new ArrayList<String>();
        titlelist.add("吃货吃货");
        titlelist.add("走走逛逛");

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);;
        tabLayout.addTab(tabLayout.newTab().setText(titlelist.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titlelist.get(1)));

        mAdapter = new ViewAdapter(getSupportFragmentManager(),titlelist);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mAdapter);

        tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabsFromPagerAdapter(mAdapter);
    }

}

