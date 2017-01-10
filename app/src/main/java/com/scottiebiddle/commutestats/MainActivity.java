package com.scottiebiddle.commutestats;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.scottiebiddle.commutestats.app.CommuteStatsApplication;
import com.scottiebiddle.commutestats.db.CommuteStatsDb;

import java.util.Locale;

import javax.inject.Inject;

/**
 * Main Activity to land on at launch
 */
public class MainActivity extends AppCompatActivity {

    @Inject SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((CommuteStatsApplication)getApplication()).getAppComponent().inject(this);
    }


    @Override
    public void onResume() {
        super.onResume();
        Cursor cursor = db.query(CommuteStatsDb.COMMUTES_TABLE, null /* projection */,
                null /* selection */, null /* selectionArgs */, null /* groupBy */,
                null /* having */, null /* orderBy */);
        try {
            int count = cursor.getCount();
            ((TextView)findViewById(R.id.textView)).setText(String.format(Locale.getDefault(), "Rows in db: %d", count));
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

    }
}
