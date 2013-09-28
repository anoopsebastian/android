package com.sebastian.reminder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{

	public static final String DATABASE_NAME = "REMINDER";
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_CREATE= "CREATE TABLE daily (" +
			"id integer PRIMARY KEY AUTOINCREMENT," +
			"title text NOT NULL," +
			"date text NOT NULL," +
			"time text NOT NULL," +
			"type text NOT NULL)";

	public DatabaseHelper(Context context) 
	{
		super(context, DATABASE_NAME,null,DATABASE_VERSION);		
	}

	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL(DATABASE_CREATE);
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		db.execSQL("DROP TABLE IF EXISTS daily");
		onCreate(db);
	}

}
