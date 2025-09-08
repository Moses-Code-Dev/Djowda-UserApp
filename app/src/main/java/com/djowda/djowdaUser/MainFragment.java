package com.djowda.djowdaUser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.djowda.djowdaUser.MainBottomUI.ActivitiesFragment;
import com.djowda.djowdaUser.MainBottomUI.HomeFragmentMS;
import com.djowda.djowdaUser.MainBottomUI.MsCartsFragment;
import com.djowda.djowdaUser.MainBottomUI.NetworkFragment;
import com.djowda.djowdaUser.MainBottomUI.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;

    private HomeFragmentMS homeFragmentMS;
    private MsCartsFragment msCartsFragment;
    private NetworkFragment networkFragment;
    private ActivitiesFragment activitiesFragment;
    private SettingsFragment settingsFragment;

    public MainFragment() {
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        bottomNavigationView = view.findViewById(R.id.main_nav_view);

        if (homeFragmentMS == null) homeFragmentMS = new HomeFragmentMS();

        if (msCartsFragment == null) msCartsFragment = MsCartsFragment.getInstance();
        if (networkFragment == null) networkFragment = NetworkFragment.getInstance();
        if (activitiesFragment == null) activitiesFragment = ActivitiesFragment.getInstance();
        if (settingsFragment == null) settingsFragment = SettingsFragment.getInstance();


        HandleBottomNavigationView();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // show the home fragment by default
        showFragment(homeFragmentMS);
    }

    public void HandleBottomNavigationView() {

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_home) {
                showFragment(homeFragmentMS);

            } else if (itemId == R.id.navigation_carts) {

                showFragment(msCartsFragment);

            } else if (itemId == R.id.navigation_network) {

                showFragment(networkFragment);

            } else if (itemId == R.id.navigation_Activities) {

                showFragment(activitiesFragment);

            } else if (itemId == R.id.navigation_settings) {

                showFragment(settingsFragment);

            }


            return true;
        });
    }

    private void showFragment(Fragment fragment) {


        FragmentManager fm = getParentFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        // Hide other fragments before showing the selected fragment
        if (fragment != (homeFragmentMS) && homeFragmentMS.isAdded())
            ft.hide(homeFragmentMS);

        if (fragment != (msCartsFragment) && msCartsFragment.isAdded())
            ft.remove(msCartsFragment);


        if (fragment != (networkFragment) && networkFragment.isAdded())
            ft.remove(networkFragment);

        if (fragment != (activitiesFragment) && activitiesFragment.isAdded())
            ft.remove(activitiesFragment);

        if (fragment != (settingsFragment) && settingsFragment.isAdded())
            ft.remove(settingsFragment);

        // show the selected fragment
        if (fragment.isAdded()) {
            ft.show(fragment);

        } else {
            ft.add(R.id.mainStart_host_fragment, fragment);
        }
        ft.commit();

    }


}