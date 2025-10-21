package com.djowda.djowdamap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.djowda.djowdamap.MapTest.Bubbles.ChatFragment;
import com.djowda.djowdamap.MapTest.Bubbles.ComponentOverViewFragment;
import com.djowda.djowdamap.MapTest.Bubbles.MapToolsFragment;
import com.djowda.djowdamap.MapTest.Bubbles.StatisticsFragment;
import com.djowda.djowdamap.MapTest.Custom2DScrollView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MapFragment extends DialogFragment {

    private RecyclerView recyclerView;
    private Custom2DScrollView scrollView;

    private FloatingActionButton btn_exitMap;

    public MapFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, com.djowda.shared_res.R.style.Theme_App_FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        btn_exitMap = view.findViewById(R.id.btn_exitMap);


        btn_exitMap.setOnClickListener(view1 -> ExitMapView());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AttachBubbles();
    }


    private void ExitMapView() {
        dismiss();
    }


















    private void AttachBubbles() {
        AttachChatFragment();
        AttachComponentOverViewFragment();
        AttachMapToolsFragment();
        AttachStatisticsFragment();
//        AttachCommunityFragment();
    }

    private void AttachChatFragment() {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.DjowdaChatHostFragment, new ChatFragment(), "ChatFragment");
        fragmentTransaction.commit();
    }

    private void AttachComponentOverViewFragment() {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ComponentOverViewHostFragment, new ComponentOverViewFragment(), "ComponentOverViewFragment");
        fragmentTransaction.commit();
    }

    private void AttachMapToolsFragment() {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.MapToolsHostFragment, new MapToolsFragment(), "MapToolsFragment");
        fragmentTransaction.commit();
    }

    private void AttachStatisticsFragment() {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.StatisticsHostFragment, new StatisticsFragment(), "StatisticsFragment");
        fragmentTransaction.commit();
    }

//    private void AttachCommunityFragment() {
//        FragmentManager fragmentManager = getChildFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.CommunityHostFragment, new CommunityFragment(), "CommunityFragment");
//        fragmentTransaction.commit();
//    }
}