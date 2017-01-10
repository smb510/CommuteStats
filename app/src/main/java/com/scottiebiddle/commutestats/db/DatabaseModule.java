package com.scottiebiddle.commutestats.db;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by scottie on 1/9/17.
 */
@Module
public class DatabaseModule {

    private final Context appContext;

    public DatabaseModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @Singleton
    CommuteStatsDb provideCommuteStatsDb() {
        return new CommuteStatsDb(appContext);
    }


}
