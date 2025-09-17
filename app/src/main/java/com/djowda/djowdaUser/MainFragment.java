/*
 * Created by the Djowda Project Team
 * Copyright (c) 2017-2025 Djowda. All rights reserved.
 *
 * This file is part of the Djowda Project.
 *
 * Licensed under the Djowda Non-Commercial, Non-Profit License v1.0
 *
 * Permissions:
 * - You may use, modify, and share this file for non-commercial and non-profit purposes only.
 * - Commercial use of this file, in any form, requires prior written permission
 *   from the Djowda Project maintainers.
 *
 * Notes:
 * - This project is community-driven and continuously evolving.
 * - The Djowda Project reserves the right to relicense future versions.
 *
 * Last Modified: 2025-09-16 19:57
 */

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
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        bottomNavigationView = view.findViewById(R.id.main_nav_view);

        HandleBottomNavigationView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Show the home fragment by default
        replaceFragment(new HomeFragmentMS());
    }

    public void HandleBottomNavigationView() {
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_home) {
                replaceFragment(new HomeFragmentMS());
            } else if (itemId == R.id.navigation_carts) {
                replaceFragment(new MsCartsFragment());
            } else if (itemId == R.id.navigation_network) {
                replaceFragment(new NetworkFragment());
            } else if (itemId == R.id.navigation_Activities) {
                replaceFragment(new ActivitiesFragment());
            } else if (itemId == R.id.navigation_settings) {
                replaceFragment(new SettingsFragment());
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getParentFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.mainStart_host_fragment, fragment);
        ft.commit();
    }
}