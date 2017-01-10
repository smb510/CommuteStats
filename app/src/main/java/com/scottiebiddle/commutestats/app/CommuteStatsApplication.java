package com.scottiebiddle.commutestats.app;

import android.app.Application;

import com.scottiebiddle.commutestats.db.DatabaseModule;

/**
 * Application subclass for CommuteStats
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
