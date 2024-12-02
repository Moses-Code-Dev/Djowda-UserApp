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

import com.djowda.djowdaUser.MainBottomUI.HomeUI.HomeFragment;
import com.djowda.djowdaUser.MainBottomUI.NetworkUI.NetworkFragment;
import com.djowda.djowdaUser.MainBottomUI.SettingsUI.SettingsFragment;
import com.djowda.djowdaUser.MainBottomUI.StoresUI.StoresFragment;
import com.djowda.djowdaUser.MainBottomUI.cartUI.CartFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainFragment extends Fragment {

    BottomNavigationView bottomNavigationView;

    // defining the main navigation
    private HomeFragment homeFragment;
    private StoresFragment storesFragment;
    private NetworkFragment networkFragment;
    private CartFragment cartFragment;
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

        homeFragment = HomeFragment.getInstance();
        storesFragment = StoresFragment.getInstance();
        networkFragment = NetworkFragment.getInstance();
        cartFragment = CartFragment.getInstance();
        settingsFragment = SettingsFragment.getInstance();

        HandleBottomNavigationView();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // show the home fragment by default
        showFragment(homeFragment);
    }

    public void HandleBottomNavigationView() {

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_home) {
                showFragment(homeFragment);

            } else if (itemId == R.id.navigation_stores) {


                showFragment(storesFragment);

            } else if (itemId == R.id.navigation_network) {


                showFragment(networkFragment);

            } else if (itemId == R.id.navigation_cart) {

                showFragment(cartFragment);


            } else if (itemId == R.id.navigation_settings) {

                showFragment(settingsFragment);


            }

            return true;
        });
    }

    private void showFragment(Fragment fragment) {


        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        // Hide other fragments before showing the selected fragment
        if (fragment != (homeFragment) && homeFragment.isAdded())
            ft.hide(homeFragment).addToBackStack(null);
        if (fragment != (storesFragment) && storesFragment.isAdded())
            ft.remove(storesFragment).addToBackStack(null);
        if (fragment != (networkFragment) && networkFragment.isAdded())
            ft.remove(networkFragment).addToBackStack(null);
        if (fragment != (cartFragment) && cartFragment.isAdded())
            ft.remove(cartFragment).addToBackStack(null);
        if (fragment != (settingsFragment) && settingsFragment.isAdded())
            ft.remove(settingsFragment).addToBackStack(null);

        // show the selected fragment
        if (fragment.isAdded()) {
            ft.show(fragment);
//            if (fragment.equals(homeFragment)) {
//                homeFragment.showAllSections();
//            }
        } else {
            ft.add(R.id.mainStart_host_fragment, fragment);
        }
        ft.commit();

    }
}