package com.scottiebiddle.commutestats.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * SqliteOpenHelper for CommuteStats App.
 */
@Singleton
public final class CommuteStatsDb extends SQLiteOpenHelper {

  private static final String DATABASE_NAME = "commute_stats";
  private static final int DATABASE_VERSION = 1; // 04d35db


  //Tables
  public static final String COMMUTES_TABLE = "commutes";
  public static final String STOPS_TABLE = "stops";
  public static final String ROUTES_TABLE = "routes";

  // Common Keys
  static final String KEY_ID = "id";

  //Commutes Table columns
  private static final String KEY_START_TIME = "commute_start_time";
  private static final String KEY_END_TIME = "commute_end_time";
  private static final String KEY_ROUTE = "route";


  //Stops Table columns
  static final String KEY_STOP_NAME = "stop_name";
  static final String KEY_STOP_LATITUDE = "stop_latitude";
  static final String KEY_STOP_LONGITUDE = "stop_longitude";

  //Routes table column
  private static final String KEY_ROUTE_NAME = "route_name";
  private static final String KEY_ROUTE_START = "route_start";
  private static final String KEY_ROUTE_END = "route_end";
  private static final String KEY_ROUTE_OPPOSITE = "route_opposite_id";

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
    sqLiteDatabase.execSQL(CREATE_STOPS_TABLE);
    sqLiteDatabase.execSQL(CREATE_ROUTES_TABLE);
    sqLiteDatabase.execSQL(CREATE_COMMUTES_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    switch (oldVersion) {
      case 1:

      default:
        // No op
        break;
    }
  }

  private static final String CREATE_STOPS_TABLE =
      "CREATE TABLE " + STOPS_TABLE +
          "(" +
          KEY_ID + " INTEGER PRIMARY KEY, " +
          KEY_STOP_NAME + " TEXT, " +
          KEY_STOP_LATITUDE + " REAL, " +
          KEY_STOP_LONGITUDE + " REAL" +
          ")";

  private static final String CREATE_ROUTES_TABLE =
      "CREATE TABLE " + ROUTES_TABLE +
          "(" +
          KEY_ID + " INTEGER PRIMARY KEY, " +
          KEY_ROUTE_NAME + " TEXT, " +
          KEY_ROUTE_START + " INTEGER, " +
          KEY_ROUTE_END + " INTEGER, " +
          KEY_ROUTE_OPPOSITE + " INTEGER, " +
          "FOREIGN KEY(" + KEY_ROUTE_START + ") REFERENCES " + STOPS_TABLE + "(" + KEY_ID + ")," +
          "FOREIGN KEY(" + KEY_ROUTE_END + ") REFERENCES " + STOPS_TABLE + "(" + KEY_ID + ")" +
          ")";


  private static final String CREATE_COMMUTES_TABLE =
      "CREATE TABLE " + COMMUTES_TABLE +
          "(" +
          KEY_ID + " INTEGER PRIMARY KEY, " +
          KEY_START_TIME + " INTEGER, " +
          KEY_END_TIME + " INTEGER, " +
          KEY_ROUTE + " INTEGER, " +
          "FOREIGN KEY(" + KEY_ROUTE  + ") REFERENCES " + ROUTES_TABLE+ "(" + KEY_ID + ")" +
          ")";

}
