package com.djowda.djowdaUser.MainBottomUI.NetworkUI.FoodCollaborationUI;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.djowda.djowdaUser.R;
import com.google.android.material.button.MaterialButton;

public class WhyDonateDialogFragment extends DialogFragment {

    private MaterialButton dismissDialogButton;


    public WhyDonateDialogFragment() {
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
        View view = inflater.inflate(R.layout.fragment_why_donate_dialog, container, false);

        dismissDialogButton = view.findViewById(R.id.dismissDialogButton);
        dismissDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }
}