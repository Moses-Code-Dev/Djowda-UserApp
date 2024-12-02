package com.djowda.djowdaUser.MainBottomUI.StoresUI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.djowda.djowdaUser.R;

public class StoresFragment extends Fragment {

    // singleton pattern

    private static StoresFragment instance = null;

    public static StoresFragment getInstance() {
        if (instance == null) {
            instance = new StoresFragment();
        }
        return instance;
    }

    public StoresFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stores, container, false);

        return view;
    }
}