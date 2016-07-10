package com.swapsha.sqlmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {
    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "members.db", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS members_list (id INTEGER PRIMARY KEY AUTOINCREMENT, fullname TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS members_list");
        onCreate(db);
    }

    public void addMember(String fullname){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname", fullname);
        db.insert("members_list", null, contentValues);
    }

    public String showTable(){
        String string = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "SELECT * FROM members_list;", null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false){
            string += cursor.getString(cursor.getColumnIndex("fullname")) + " " + cursor.getInt(cursor.getColumnIndex("id"));
            string += "\n";
            cursor.moveToNext();
        }
        return string;
    }

    public void clear(String string){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("DELETE FROM members_list WHERE fullname = '" + string + "';");
    }
}
