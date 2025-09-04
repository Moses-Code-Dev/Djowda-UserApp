package com.djowda.djowdaUser;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        SplashScreen.installSplashScreen(this);
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