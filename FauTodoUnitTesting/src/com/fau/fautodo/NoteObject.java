package com.fau.fautodo;

public class NoteObject {

	public int		noteId;
	public String	noteLabel;
	public String	noteDescription;
	public String	noteDueDate;
	
	public NoteObject() {
		// TODO Auto-generated constructor stub
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	
	public int getNoteId() {
		return noteId;
	}
	public void setNoteLabel(String label) {
		this.noteLabel = label;
	}
	
	public String getNoteLabel() {
		return noteLabel;
	}
	
	public void setNoteDescription(String descr) {
		this.noteDescription = descr;
	}
	
	public String getNoteDescription() {
		return noteDescription;
	}
	
	public void setNoteDueDate(String dueDate) {
		this.noteDueDate = dueDate;
	}
	
	public String getNoteDueDate() {
		return noteDueDate;
	}
	
	  // Will be used by the ArrayAdapter in the ListView
	  @Override
	  public String toString() {
		  return noteDescription;
	  }
}
