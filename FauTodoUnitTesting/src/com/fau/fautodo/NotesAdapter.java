package com.fau.fautodo;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NotesAdapter extends ArrayAdapter <NoteObject> {

	int resource;
	Context context;
	List<NoteObject> noteItems;
	
	public NotesAdapter (Context context, int resource, List <NoteObject> items) {
		super(context, resource, items);
		this.resource = resource;
		this.noteItems = items;
	}

	@Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LinearLayout rowView;
        //Get the current device object
        NoteObject obj = getItem(position); 
 
        //Inflate the view
        if(convertView == null)
        {   
        	rowView = new LinearLayout(getContext());
        	String inflater = Context.LAYOUT_INFLATER_SERVICE;
        	LayoutInflater vi;
        	vi = (LayoutInflater) getContext().getSystemService(inflater);
        	vi.inflate(resource, rowView, true);
        } else {
        	rowView = (LinearLayout) convertView;
        }
        
        TextView noteLabel			= (TextView) rowView.findViewById(R.id.textView_noteLabel);
        TextView noteDescription	= (TextView) rowView.findViewById(R.id.textView_noteDescription);
        TextView noteDueDate		= (TextView) rowView.findViewById(R.id.textView_noteDueDate);
        
        noteLabel.setText(obj.getNoteLabel().toString());
        noteDescription.setText(obj.getNoteDescription().toString());
        noteDueDate.setText(obj.getNoteDueDate().toString());
        
        return rowView;
    }
}
