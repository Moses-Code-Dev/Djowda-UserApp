package com.djowda.djowdaUser.MainBottomUI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.djowda.djowdaUser.R;

public class NetworkFragment extends Fragment {

    // singleton pattern
    private static NetworkFragment instance = null;

    public static NetworkFragment getInstance() {
        if (instance == null) {
            instance = new NetworkFragment();
        }
        return instance;
    }

    public NetworkFragment() {
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
        View view = inflater.inflate(R.layout.fragment_network, container, false);

        return view;
    }
}