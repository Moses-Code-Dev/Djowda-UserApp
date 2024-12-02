package com.djowda.djowdaUser.MainBottomUI.SettingsUI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.djowda.djowdaUser.R;

public class SettingsFragment extends Fragment {

    // singleton pattern
    private static SettingsFragment instance = null;

    public static SettingsFragment getInstance() {
        if (instance == null) {
            instance = new SettingsFragment();
        }
        return instance;
    }


    public SettingsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        return view;
    }
}