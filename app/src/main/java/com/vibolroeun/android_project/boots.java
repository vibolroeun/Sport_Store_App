package com.vibolroeun.android_project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vibolroeun.android_project.Adapter.Recycler_View_Adapter;
import com.vibolroeun.android_project.Models.list_row;

import java.util.ArrayList;
import java.util.List;

public class boots extends Fragment {

    private RecyclerView recyclerView;
    private List<list_row> rowList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boots, container, false);

        recyclerView = view.findViewById(R.id.recycler_bootID);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(getContext(), rowList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rowList = new ArrayList<>();
        rowList.add(new list_row("Adidas X 17.1 FG/AG White/Real Coral/Core Black A", R.drawable.icon1, "Description", "100", "new"));
        rowList.add(new list_row("Adidas X 17.1 FG/AG White/Real Coral/Core Black B", R.drawable.icon2, "Description", "90", "new"));
        rowList.add(new list_row("Adidas X 17.1 FG/AG White/Real Coral/Core Black C", R.drawable.icon3, "Description", "80", "new"));

    }
}
