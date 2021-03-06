package com.sebastian.reminder;

import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DatabaseControl 
{
	private static final String DATABASE_TABLE = "daily";	
	private static final String KEY_ROWID = "id";
	private static final String KEY_TITLE = "title";
	private static final String KEY_DATE = "date";
	private static final String KEY_TIME = "time";
	private static final String KEY_TYPE = "type";
	
	private Context context;
	private SQLiteDatabase database;
	private DatabaseHelper database_helper;
	
	public DatabaseControl (Context context)
	{
		this.context = context;
	}
	
	public DatabaseControl openDatabase () throws SQLiteException
	{
		database_helper = new DatabaseHelper(context);
		database = database_helper.getWritableDatabase();
		return this;		
	}
	
	public void closeDatabase ()
	{
		database_helper.close();
	}
	
	public long addDailyEvent(String title,String date,String time,String remindertype)
	{
		ContentValues contentValues = createContentValues(title,date,time,remindertype);
		return database.insert(DATABASE_TABLE, null, contentValues);
	}
	
	public int updateDailyEvent (long id, String title, String date, String time, String remindertype)
	{
		ContentValues contentValues = createContentValues(title,date,time,remindertype);
		return database.update(DATABASE_TABLE, contentValues, KEY_ROWID + "="+ id, null);
	}
	
	public long getItemIdByDate(String date)
	{
		Cursor databaseCursor;
		long id = 0;
		
		try {
			databaseCursor = database.query(true, DATABASE_TABLE, new String[] {KEY_ROWID}, KEY_DATE + "= '"+date + "'", null, null, null, null, null, null);
			databaseCursor.moveToFirst();
			id = databaseCursor.getLong(databaseCursor.getColumnIndex(KEY_DATE));
			
		} catch (SQLiteException e) {
			id = -1;
		}
		
		return id;
	}
	
	public String getAllItems()
	{
		String alldata = "";
		Cursor cursor;
		
		cursor = database.query(DATABASE_TABLE, new String[] {KEY_ROWID,KEY_TITLE,KEY_DATE,KEY_TIME,KEY_TYPE}, null, null, null, null, null);
		return alldata;
	}

	private ContentValues createContentValues(String title, String date, String time, String remindertype)
	{		
		ContentValues contentValues = new ContentValues();
		contentValues.put(KEY_TITLE, title);
		contentValues.put(KEY_DATE, date);
		contentValues.put(KEY_TIME, time);
		contentValues.put(KEY_TYPE, remindertype);
				
		return contentValues;
	}
}















