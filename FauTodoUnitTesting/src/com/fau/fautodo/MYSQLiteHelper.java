package com.fau.fautodo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MYSQLiteHelper extends SQLiteOpenHelper {

	public static final String TAG = "FAUToDo";
	
		// TODO Auto-generated constructor stub
		public static final String 	TABLE_USERS			= "users";
		public static final String 	COLUMN_ID			= "id";
		public static final String 	COLUMN_USERNAME		= "username";
		public static final String 	COLUMN_PASSWORD		= "password";
		public static final String 	COLUMN_EMAIL		= "email";
		
		public static final String 	TABLE_SETTINGS		= "settings";

		public static final String 	TABLE_NOTES			= "notes";
		public static final String 	COLUMN_LABEL		= "label";
		public static final String 	COLUMN_DESCRIPTION	= "description";
		public static final String 	COLUMN_DUE_DATE		= "due_date";
		
		private static final String DATABASE_NAME		= "fau_todo.db";
		private static final int 	DATABASE_VERSION	= 3;
		
		public MYSQLiteHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		  
		private static final String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "(" + COLUMN_ID
			      + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USERNAME + " TEXT, "
			      + COLUMN_PASSWORD + " TEXT, " + COLUMN_EMAIL + " TEXT);";
		
		private static final String CREATE_NOTES_TABLE = "create table " + TABLE_NOTES + "(" + COLUMN_ID
			      + " integer primary key autoincrement, " + COLUMN_LABEL + " text not null, "
			      + COLUMN_DESCRIPTION + " text not null, " + COLUMN_DUE_DATE + " date);";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Database creation sql statement
		db.execSQL(CREATE_USERS_TABLE);		
		db.execSQL(CREATE_NOTES_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		 // Drop older tables if existed
		 db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
		 db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
		 // Create tables again
		 onCreate(db);
	}
	
	/*
	 * Adding a user
	 */
	public void addUser(User user) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(COLUMN_ID, user.getUserId());
	    values.put(COLUMN_USERNAME, user.getUsername());
	    values.put(COLUMN_PASSWORD, user.getUserPassword());
	    values.put(COLUMN_EMAIL, user.getUserEmail());
	 
	    // insert row
	    db.insert(TABLE_USERS, null, values);
	    db.close();
	}
	
	// Get a user
	 public User getUser() {
		 SQLiteDatabase db = this.getReadableDatabase();

		 String selectQuery = "SELECT * FROM " + TABLE_USERS;
		 Log.e(TAG, selectQuery);
		 
		 Cursor cursor = db.rawQuery(selectQuery, null);
		 
		 if (cursor != null)
			 cursor.moveToFirst();
		
		 if (cursor.getCount() > 0) {
		 User user = new User();
		 user.setUserId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
		 user.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
		 user.setUserEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
		 user.setUserPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
		 return user;
		 }
		 
		 return null;
	 }
	 /**
	  * This method checks if an e-mail address is
	  * already in the database
	  * in database, false otherwise
	  * @param emailAddress
	  * @return true if email address already 
	  */
	 public boolean emailInUse(String emailAddress){
		 boolean result = false;
		 SQLiteDatabase db = this.getReadableDatabase();
		 String[] columns = {COLUMN_EMAIL};
		 String[] selectionArgs = {emailAddress};
		 String selectQuery = "SELECT * FROM " + TABLE_USERS;// + " WHERE " + COLUMN_EMAIL+ "='" + emailAddress +  "'";
		 Log.e(TAG, selectQuery);
		 Cursor cursor =  db.query(TABLE_USERS, columns, COLUMN_EMAIL+"='?'", selectionArgs, null, null, null);
		 if (cursor != null)
			 cursor.moveToFirst();
		 if (cursor.getCount() > 0) {
			 Log.d(TAG, "found e-mail address " + cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
			 result = true;
		 } else {
			 Log.d(TAG, "email address not in db");
		 }
		 return result;
	 }
}
