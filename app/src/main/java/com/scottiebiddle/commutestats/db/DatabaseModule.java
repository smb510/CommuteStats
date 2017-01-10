package com.scottiebiddle.commutestats.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Module providing DB-Scoped Dependencies.
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


    @Provides
    @Singleton
    SQLiteDatabase provideReadableDatabase(CommuteStatsDb commuteStatsDb) {
        return commuteStatsDb.getReadableDatabase();
    }


}
