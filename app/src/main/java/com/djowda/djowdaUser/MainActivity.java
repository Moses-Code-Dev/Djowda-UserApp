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
 * Last Modified: 2025-09-06 17:36
 */

package com.djowda.djowdaUser;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            LoadMainFragment();
        }

    }

    private void LoadMainFragment() {
        //begin transaction
        getSupportFragmentManager().beginTransaction()

                .replace(R.id.main_host_fragment, new MainFragment()).commit();

    }
}