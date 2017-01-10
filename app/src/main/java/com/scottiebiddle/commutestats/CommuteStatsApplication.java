package com.scottiebiddle.commutestats;

import android.app.Application;

import com.scottiebiddle.commutestats.db.DatabaseModule;

/**
 * Created by scottie on 1/9/17.
 */

public class CommuteStatsApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .databaseModule(new DatabaseModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
