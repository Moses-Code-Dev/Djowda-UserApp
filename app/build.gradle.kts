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

plugins {
    alias(libs.plugins.android.application)
    // alias(libs.plugins.google.gms.google.services)
    // alias(libs.plugins.google.firebase.crashlytics)
}

android {
    namespace = "com.djowda.djowdaUser"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.djowda.djowdaUser"
        minSdk = 27
        targetSdk = 36
        versionCode = 1  // will be auto-incremented by Fastlane if configured
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.schemaLocation"] = "$projectDir/schemas"
            }
        }
    }

    signingConfigs {
        create("release") {
            // Use the keystore created dynamically by GitHub Actions
            val keystoreFile = rootProject.file("release.keystore") // path relative to root
            if (!keystoreFile.exists()) {
                println("WARNING: release.keystore not found! Build may fail on CI.")
            }
            storeFile = keystoreFile
            storePassword = System.getenv("RELEASE_STORE_PASSWORD")
            keyAlias = System.getenv("RELEASE_KEY_ALIAS")
            keyPassword = System.getenv("RELEASE_KEY_PASSWORD")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(project(":DjowdaMap"))

    implementation(libs.core.splashscreen)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    implementation(libs.whynotimagecarousel)
    implementation(libs.glide)
    implementation(libs.lifecycle.livedata)

    annotationProcessor(libs.compiler)
    implementation(libs.glide.transformations)

    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)

    implementation(libs.libphonenumber)

    debugImplementation(libs.leakcanary.android)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
