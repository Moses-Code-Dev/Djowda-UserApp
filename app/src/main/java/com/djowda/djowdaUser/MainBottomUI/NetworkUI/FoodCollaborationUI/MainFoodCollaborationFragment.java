package com.djowda.djowdaUser.MainBottomUI.NetworkUI.FoodCollaborationUI;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.djowda.djowdaUser.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class MainFoodCollaborationFragment extends DialogFragment implements View.OnClickListener{

    private MaterialButton btnWhyAsk;
    private MaterialButton btnWhyDonate;


    // singleton pattern
    private static MainFoodCollaborationFragment instance = null;

    public static MainFoodCollaborationFragment getInstance() {
        if (instance == null) {
            instance = new MainFoodCollaborationFragment();
        }
        return instance;
    }

    public MainFoodCollaborationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Objects.requireNonNull(getDialog()).getWindow().setBackgroundDrawableResource(android.R.color.white);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_food_collaboration, container, false);

        btnWhyAsk = view.findViewById(R.id.btnWhyAsk);
        btnWhyDonate = view.findViewById(R.id.btnWhyDonate);

        btnWhyAsk.setOnClickListener(this);
        btnWhyDonate.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnWhyAsk) {
            WhyAskDialogFragment whyAskDialogFragment = new WhyAskDialogFragment();
            whyAskDialogFragment.show(requireActivity().getSupportFragmentManager(), "WhyAskDialogFragment");

        } else if (id == R.id.btnWhyDonate) {
            WhyDonateDialogFragment whyDonateDialogFragment = new WhyDonateDialogFragment();
            whyDonateDialogFragment.show(requireActivity().getSupportFragmentManager(), "WhyDonateDialogFragment");

        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // remove listener
        btnWhyAsk.setOnClickListener(null);
        btnWhyDonate.setOnClickListener(null);

    }
}