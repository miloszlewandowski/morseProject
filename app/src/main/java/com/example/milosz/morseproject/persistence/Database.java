package com.example.milosz.morseproject.persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, "Database", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Points (points INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Points");
        onCreate(db);
    }

    public void saveScore(int score) {
        this.getWritableDatabase().execSQL(String.format("INSERT INTO Points VALUES (%d)", score));
    }

    public List<Integer> getScores() {
        List<Integer> out = new ArrayList<>();
        Cursor c =this.getReadableDatabase().rawQuery("SELECT points FROM Points ORDER BY points DESC",new String[0]);
        while (c.moveToNext()) {
            out.add(c.getInt(0));
        }
        c.close();
        return out;
    }
}
