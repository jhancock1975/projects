package com.fau.fautodo;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {

	public static final String filename = "SavedPrefs";
	SharedPreferences Prefs;
	public static final String TAG = "FAUToDo";
	
	// UI references.
	private EditText mUserName;
	private EditText mPassword;
	
	// Database Helper
	MYSQLiteHelper db;
	User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		db = new MYSQLiteHelper(getApplicationContext());
		
		// Link up UserName Edit Box
		mUserName= (EditText) findViewById(R.id.editText_username);
		mPassword = (EditText) findViewById(R.id.editText_password);
		
//		Prefs = getSharedPreferences(filename, MODE_PRIVATE);
//		mUserName.setText(Prefs.getString("EMAIL", ""));
//		mPassword.setText(Prefs.getString("PASSWORD", ""));
		
		//user = new User();
		user = db.getUser();
		if (user != null) {
			mUserName.setText(user.getUsername());
			mPassword.setText(user.getUserPassword());
		}
		
		// Link up Login Button
		findViewById(R.id.button_login).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						//Run this onClick

						Intent loginIntent = new Intent(LoginActivity.this, MainPageActivity.class);
						startActivity(loginIntent); 				
//						Log.d(TAG, "You Entered name ="+mUserName.getText());
//						Log.d(TAG, "You Entered password = "+mPassword.getText());
						//Dialog Box
						}
				});
		
		findViewById(R.id.textView_createaccount).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						//Run this onClick
						Intent i = new Intent(LoginActivity.this, CreateUserActivity.class);
						startActivity(i); 
						//Dialog Box
						}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
