package com.example.drmpjct;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "drmprjct.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "kcal"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ENG_NAME = "engname";
    public static final String COLUMN_RUS_NAME = "rusname";
    public static final String COLUMN_KCAL = "kcal";
    public static final String COLUMN_PIC_REZ = "picrez";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE kcal (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_ENG_NAME
                + " TEXT, " + COLUMN_RUS_NAME + " TEXT, " + COLUMN_KCAL + "TEXT );");
        // добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_ENG_NAME
                + ", " + COLUMN_RUS_NAME  + ", " +  COLUMN_KCAL + " ) VALUES ('banana', 'банан', '96');");
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_ENG_NAME
                + ", " + COLUMN_RUS_NAME  + ", " +  COLUMN_KCAL + " ) VALUES ('apple', 'яблоко', '52');");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}
