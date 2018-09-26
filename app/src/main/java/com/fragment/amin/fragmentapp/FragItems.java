package com.fragment.amin.fragmentapp;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragItems extends ListFragment {
    onItemClick activity;
    public interface onItemClick {
        void onClick(int index);
    }

    public FragItems() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (onItemClick) context;
    }

    // This override function is used for when mobile is on landscape mode and vice versa
    // The data is oncreated again.
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] data= getResources().getStringArray(R.array.pieces);
        setListAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, data));

        if(this.getActivity().findViewById(R.id.layout_land) != null) {
            activity.onClick(0);
        }

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        activity.onClick(position);
    }
}
