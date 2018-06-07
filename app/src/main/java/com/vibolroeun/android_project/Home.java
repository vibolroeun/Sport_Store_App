package com.vibolroeun.android_project;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vibolroeun.android_project.Adapter.Home_ViewPager_Adapter;


public class Home extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Home_ViewPager_Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout = view.findViewById(R.id.tab_layoutID);
        viewPager = view.findViewById(R.id.hf_viewPagerID);
        adapter = new Home_ViewPager_Adapter(getFragmentManager());

        adapter.AddFragment(new boots(), "Boots");
        adapter.AddFragment(new clothings(), "Clothing");
        adapter.AddFragment(new equipments(), "Equipments");
        adapter.AddFragment(new kidboots(), "Kid Boots");
        adapter.AddFragment(new accessories(), "Accessories");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        // Inflate the layout for this fragment
        return view;
    }


}
