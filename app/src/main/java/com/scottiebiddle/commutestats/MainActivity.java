package com.scottiebiddle.commutestats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.scottiebiddle.commutestats.db.CommuteStatsDb;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject CommuteStatsDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((CommuteStatsApplication)getApplication()).getAppComponent().inject(this);
    }
}
