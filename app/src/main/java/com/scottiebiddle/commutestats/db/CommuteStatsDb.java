package com.scottiebiddle.commutestats.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by scottie on 1/9/17.
 */
@Singleton
public final class CommuteStatsDb extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "commute_stats";
    private static final int DATABASE_VERSION = 1;


    //Tables
    private static final String COMMUTES_TABLE = "commutes";

    //Commutes Table columns
    private static final String KEY_ID = "id";
    private static final String KEY_START_TIME = "commute_start_time";
    private static final String KEY_END_TIME = "commute_end_time";
    private static final String KEY_ROUTE = "route";
    private static final String KEY_FROM_STOP = "from_stop";
    private static final String KEY_TO_STOP = "to_stop";

    @Inject
    CommuteStatsDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
        db.enableWriteAheadLogging();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_COMMUTES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        switch(oldVersion) {
            default:
                // No op
                break;
        }
    }

    private static final String CREATE_COMMUTES_TABLE =
            "CREATE TABLE" + COMMUTES_TABLE +
                    "(" +
                        KEY_ID + " INTEGER PRIMARY KEY, " +
                        KEY_START_TIME + " INTEGER, " +
                        KEY_END_TIME + " INTEGER, " +
                        KEY_ROUTE + " TEXT, " +
                        KEY_FROM_STOP + " TEXT, " +
                        KEY_TO_STOP + " TEXT, " +
                    ")";

}
