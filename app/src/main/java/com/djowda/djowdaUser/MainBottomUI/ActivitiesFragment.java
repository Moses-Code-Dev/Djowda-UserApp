package com.djowda.djowdaUser.MainBottomUI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.djowda.djowdaUser.R;

public class ActivitiesFragment extends Fragment {

    // singleton pattern
    private static ActivitiesFragment instance = null;

    public static ActivitiesFragment getInstance() {
        if (instance == null) {
            instance = new ActivitiesFragment();
        }
        return instance;
    }

    public ActivitiesFragment() {
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
        View view = inflater.inflate(R.layout.fragment_activities, container, false);

        return view;
    }
}