package com.example.ankhleu.trackingyourspendingv3.tripdata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ankhleu on 2018/1/31.
 */

public class tripDB extends SQLiteOpenHelper {
    final static  String DB_NAME = "Trip.sqlite"; //資料庫名稱(旅行)
    final static int VERSION = 1 ;
    final static String _Trip = "trip";     // 資料表名稱(活動)
    final static String _Payout = "payout"; // 資料表名稱(活動紀錄細項)

    public  tripDB (Context context)
    {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"trip\" ( `_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `Title` TEXT, `startdate` TEXT, `enddate` TEXT, `budget` INTEGER )");
        db.execSQL("CREATE TABLE \"tripdetail\" ( `_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `money` INTEGER, `_date` TEXT, `subject` TEXT, `Currency` TEXT, `note` TEXT )");
       // db.execSQL("SELECT*FROM tripdetail LEFT OUTER JOIN trip ON tripdetail._date=trip.enddate");//用join方法產生關聯（失敗）
        // SQLite trip id是否應該改為AI自動生成?
        //db.execSQL("SELECT ('now')-");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
