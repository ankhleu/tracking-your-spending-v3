package com.example.ankhleu.trackingyourspendingv3.tripdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ankhleu.trackingyourspendingv3.Tripadddetail;

import java.util.ArrayList;

/**
 * Created by ankhleu on 2018/1/31.
 */

public class tripDetail implements tripDetailDAO {

    Context context;
    SQLiteDatabase db;
    public static int trip_id=0;

    public tripDetail(Context context) {
        this.context = context;
        tripDB helper = new tripDB(context);
        db = helper.getWritableDatabase();
    }

    @Override
    public boolean add(tripadd_constructor t) {
        ContentValues cv = new ContentValues();
//        cv.put("_id",t.id); ID 自動生成應該不用+
        cv.put("trip_id",t.trip_id);
        cv.put("money",t.money);
        cv.put("_date",t.date);
        cv.put("subject",t.subject);
        cv.put("Currency",t.currency);
        cv.put("note",t.note);
        db.insert("tripdetail",null,cv);
        return true;
    }

    @Override
    public ArrayList<tripadd_constructor> getList() {
        ArrayList<tripadd_constructor> mlist = new ArrayList<>();
        Cursor c = db.query("tripdetail", new String[]{"_id","trip_id","money","_date","subject","Currency","note"},null,null,null,null,null);
        if (c.moveToFirst())
        {
            tripadd_constructor s1 = new tripadd_constructor(c.getInt(0),c.getString(1), c.getInt(2), c.getString(3),c.getString(4),c.getString(5));
            mlist.add(s1);
            while(c.moveToNext())
            {
                tripadd_constructor s = new tripadd_constructor(c.getInt(0),c.getString(1), c.getInt(2), c.getString(3),c.getString(4),c.getString(5));
                mlist.add(s);
            }
        }
        return mlist;
    }

    @Override
    public tripadd_constructor getTrip(int id) {
        Cursor c = db.query("tripdetail", new String[] {"_id","trip_id", "money", "_date","subject","Currency","note"}, "_id=?", new String[] {String.valueOf(id)}, null, null, null);
        if (c.moveToFirst())
        {



            if (trip_constructor.id==-1)
            //if (trip_constructor.id==-1&&trip_id==-1)
          //  if (trip_id>=0)

            {
                trip_id=1;
                tripadd_constructor s1 = new tripadd_constructor(c.getInt(0),c.getString(1), c.getInt(2), c.getString(3),c.getString(4),c.getString(5));
                return s1;

                //return null;
                

            }
            else
                {
                    trip_constructor.id=0;
                    getTrip(trip_id=0);
                    return null;
                }

        }
        Log.d("checkdata","data");
        return null;
    }

    @Override
    public boolean update(tripadd_constructor t) {
        ContentValues cv = new ContentValues();
        cv.put("trip_id",t.trip_id);
        cv.put("money",t.money);
        cv.put("_date",t.date);
        cv.put("subject",t.subject);
        cv.put("Currency",t.currency);
        cv.put("note",t.note);
        db.update("tripdetail",cv,"_id=?",new String[] {String.valueOf(t.trip_id)});
        return true;
    }

    @Override
    public boolean delete(int id) {
        db.delete("tripdeatail","_id=?", new String[] {String.valueOf(id)});
        return true;
    }
}
