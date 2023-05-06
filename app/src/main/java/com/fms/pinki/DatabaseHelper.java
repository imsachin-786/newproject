package com.fms.pinki;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.PublicKey;

public class DatabaseHelper<email> extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Traindetails(trainno primary key,source text,dest text ,fare number,trainname text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }
    //inserting in database
    public boolean insert(String trainno,String trainname,String source,String dest,String fare){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Train No. ",trainno);
        contentValues.put("Train Name",trainname);
        contentValues.put("Fare",fare);
        contentValues.put("Source",source);
        contentValues.put("Destination",dest);

        long ins = db.insert("Traindetails",null,contentValues);
        if (ins == -1) return false;
        else return true;
    }

//    public Boolean checkmail(String email){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("Select * from user where email=?",new String[]{email});
//        if(cursor.getCount()>0) return false;
//        else return true;
//    }
//    //checking the email and password
//    public Boolean emailpassword(String email,String password){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
//        if (cursor.getCount()>0) return true;
//        else return false;
//    }
}
