package com.fau.fautodo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class CreateUserActivity extends Activity {
	
	public static final String filename = "SavedPrefs";
	SharedPreferences Prefs;
	
	public static final String TAG = "FAUToDo";
	
	private EditText nameTextField;
	private EditText emailTextField;
	private EditText passwordTextField;
	private EditText confirmPasswordTextField;
	
	// Database Helper
			MYSQLiteHelper db;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_user);
		
		db = new MYSQLiteHelper(getApplicationContext());
		
		nameTextField				= (EditText) findViewById(R.id.editText_name);
		emailTextField				= (EditText) findViewById(R.id.editText_email);
		passwordTextField			= (EditText) findViewById(R.id.editText_password);
		confirmPasswordTextField	= (EditText) findViewById(R.id.editText_confirm_password);
		
		// Link up Create Button

				findViewById(R.id.createButton).setOnClickListener(
						new View.OnClickListener() {
							@Override
							public void onClick(View view) {
								//Check that all fields have data
								if (nameTextField.getText().length() > 0 && emailTextField.getText().length() > 0 && passwordTextField.getText().length() > 0 && confirmPasswordTextField.getText().length() > 0) {
									//Check that passwords match
									String password		= passwordTextField.getText().toString();
									String cPassword	= confirmPasswordTextField.getText().toString();
									if (password.equals(cPassword)) {
										
										
										User user = new User();
										user.setUserEmail(emailTextField.getText().toString());
										user.setUsername(nameTextField.getText().toString());
										user.setUserPassword(passwordTextField.getText().toString());
										db.addUser(user);
										
//										//Save the user info to shared preferences
//										Prefs = getSharedPreferences(filename, MODE_PRIVATE);
//										SharedPreferences.Editor editor = Prefs.edit();
//										editor.putString("NAME", nameTextField.getText().toString());
//										editor.putString("EMAIL", emailTextField.getText().toString());
//										editor.putString("PASSWORD", passwordTextField.getText().toString());
//										editor.commit();
										
										//Run this onClick
										Intent CreateAccount = new Intent(CreateUserActivity.this, MainPageActivity.class);
										startActivity(CreateAccount); 
									} else {
										AlertDialog.Builder builder = new AlertDialog.Builder(CreateUserActivity.this);
										builder.setMessage(R.string.dialog_password_match_message).setTitle(R.string.dialog_title);
										
										//Add the buttons
										builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener () {
											public void onClick(DialogInterface dialog, int id) {
												
											}
										});
										
										builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener () {
											public void onClick(DialogInterface dialog, int id) {
												
											}
										});
										builder.show();
									}
								} else {
									AlertDialog.Builder builder = new AlertDialog.Builder(CreateUserActivity.this);
									builder.setMessage(R.string.dialog_enter_all_data_message).setTitle(R.string.dialog_title);
									
									//Add the buttons
									builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener () {
										public void onClick(DialogInterface dialog, int id) {
											
										}
									});
									builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener () {
										public void onClick(DialogInterface dialog, int id) {
											
										}
									});
									builder.show();
								}
								

								//Dialog Box
								}
						});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_user, menu);
		return true;
	}

}
