package com.fau.fautodo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainPageActivity extends Activity {

	private ImageButton addNoteButton;
	private ImageButton notesListButton;
	private ImageButton settingsButton;
	
	// Database Helper
	MYSQLiteHelper db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		
		addNoteButton	= (ImageButton) findViewById(R.id.imageButton_addNote);
		notesListButton	= (ImageButton) findViewById(R.id.imageButton_notesList);
		settingsButton	= (ImageButton) findViewById(R.id.imageButton_settings);
		
		// Link up Login Button
				findViewById(R.id.imageButton_notesList).setOnClickListener(
						new View.OnClickListener() {
							@Override
							public void onClick(View view) {
								//Run this onClick
				
								Intent i = new Intent(MainPageActivity.this, NotesListActivity.class);
								startActivity(i); 
								//Dialog Box
								}
						});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

}
