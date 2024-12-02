package com.djowda.djowdaUser.MainBottomUI.NetworkUI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.djowda.djowdaUser.MainBottomUI.NetworkUI.FoodCollaborationUI.MainFoodCollaborationFragment;
import com.djowda.djowdaUser.R;
import com.google.android.material.button.MaterialButton;

public class NetworkFragment extends Fragment implements View.OnClickListener{

    private MaterialButton btnFoodCollaboration;

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

        btnFoodCollaboration = view.findViewById(R.id.btnFoodCollaboration);

        btnFoodCollaboration.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnFoodCollaboration) {
            MainFoodCollaborationFragment mainFoodCollaborationFragment = new MainFoodCollaborationFragment();
            mainFoodCollaborationFragment.show(requireActivity().getSupportFragmentManager(), "MainFoodCollaborationFragment");
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // remove listener
        btnFoodCollaboration.setOnClickListener(null);

    }
}