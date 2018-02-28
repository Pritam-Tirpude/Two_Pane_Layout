package com.example.pritam.twopane;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        savedInstanceState = getIntent().getExtras();

        if (savedInstanceState != null) {
            DetailFragment fragment = new DetailFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.detail_container, fragment)
                    .commit();
        }
    }
}
