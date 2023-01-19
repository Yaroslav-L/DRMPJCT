package com.example.drmpjct;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperRez extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "drmprjct.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "data"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FILE_REZ = "file_rez";
    public static final String COLUMN_JSON = "json";

    public DatabaseHelperRez(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE data (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FILE_REZ
                + " TEXT, " + COLUMN_JSON + "TEXT );");
        // добавление начальных данных
      /*  db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_ENG_NAME
                + ", " + COLUMN_RUS_NAME  + ", " +  COLUMN_KCAL + " ) VALUES ('banana', 'банан', '96');");
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_ENG_NAME
                + ", " + COLUMN_RUS_NAME  + ", " +  COLUMN_KCAL + " ) VALUES ('apple', 'яблоко', '52');");*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}