package com.fau.fautodo;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class NotesListActivity extends Activity implements OnClickListener {

	ArrayList<NoteObject> notes = null;
	NoteObject note;
	ListView notesList;
	NotesAdapter notesAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notes_list);
		
		notesList = (ListView) findViewById(R.id.listView_notesList);
		
		String[] values = new String[] { "HW 1", "Submit Project", "Final Project" };
		
		notes					= new ArrayList<NoteObject> ();
		note					= new NoteObject ();
		note.setNoteLabel("FauToDo Project");
		note.setNoteDescription("Android todo list application");
		note.setNoteDueDate("Feb 10, 2014 11:30");
		notes.add(note);
		
		note					= new NoteObject ();
		note.setNoteLabel("Final Project");
		note.setNoteDescription("Android todo list Final Project Due");
		note.setNoteDueDate("Feb 20, 2014 12:00");
		notes.add(note);

	    notesAdapter = new NotesAdapter(NotesListActivity.this, R.layout.notes_list_row, notes);
		notesList.setAdapter(notesAdapter);
		
		notesAdapter.notifyDataSetChanged();
		
		notesList.setOnItemClickListener(new OnItemClickListener() {
			
			  @Override
			  public void onItemClick(AdapterView<?> parent, View view,
			    int position, long id) {
			    Toast.makeText(getApplicationContext(),
			      "Click ListItem Number " + position, Toast.LENGTH_SHORT)
			      .show();
			  }
			}); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notes_list, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
