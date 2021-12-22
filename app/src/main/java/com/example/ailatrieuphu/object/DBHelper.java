package com.example.ailatrieuphu.object;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "PlayerList.db";
    public static final String PLAYER_TABLE_NAME ="user";
    public static final String PLAYER_COLUMN_NAME ="name";
    public static final String PLAYER_COLUMN_COIN = "coin";
    public static final String PLAYER_COLUMN_QUESTION = "question";
    public DBHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users" + "(id integer primary key AUTOINCREMENT, name text , coin text , ques text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
       onCreate(db);
    }
    public  void insertInfor(String name , String coin , String question) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PLAYER_COLUMN_QUESTION,question);
        values.put(PLAYER_COLUMN_NAME,name);
        values.put(PLAYER_COLUMN_COIN,coin);
        database.insert("users",null,values);
    }

    public ArrayList<Infor_Millionaries> getDataInfor() {
        ArrayList<Infor_Millionaries> arrayList = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor res = database.rawQuery("select * from users" ,null);
        res.moveToFirst(); /*Move the cursor to the last row.*/
        while (res.isAfterLast()==false) {
           /* cursor.isAfterLast() returns true when cursor is at last row position. Adding a ! (not) means perform till it is not at the end of cursor.

            so while(!cursor.isAfterLast()){} means while loop will traverse till last record of cursor.

            Here cursor is a class which holds the row of your data fetch from the table using sql query.*/
            String name = res.getString(res.getColumnIndex(PLAYER_COLUMN_NAME));
            int coin = Integer.parseInt(res.getString(res.getColumnIndex(PLAYER_COLUMN_COIN)));
            String ques = res.getString(res.getColumnIndex(PLAYER_COLUMN_QUESTION));
            arrayList.add(new Infor_Millionaries(name,coin,ques));
            res.moveToNext(); /*Move the cursor to the previous row.*/
        }
        return arrayList;
    }
}
