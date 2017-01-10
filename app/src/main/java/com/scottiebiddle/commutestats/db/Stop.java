package com.scottiebiddle.commutestats.db;

import android.database.Cursor;

/**
 * Model class representing a shuttle stop
 */

public class Stop {

  private int id;
  private String stopName;
  private double latitude;
  private double longitude;


  private Stop(int id, String stopName, double latitude, double longitude) {
    this.id = id;
    this.stopName = stopName;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public static Stop newStop(String stopName, double latitude, double longitude) {
    return new Stop(-1, stopName, latitude, longitude);
  }

  public static Stop newStop(Cursor stopCursor) {
    int id = stopCursor.getInt(stopCursor.getColumnIndex(CommuteStatsDb.KEY_ID));
    String stopName = stopCursor.getString(stopCursor.getColumnIndex(CommuteStatsDb.KEY_STOP_NAME));
    double latitude = stopCursor.getDouble(stopCursor.getColumnIndex(CommuteStatsDb.KEY_STOP_LATITUDE));
    double longitude = stopCursor.getDouble(stopCursor.getColumnIndex(CommuteStatsDb.KEY_STOP_LONGITUDE));
    return new Stop(id, stopName, latitude, longitude);
  }
}
