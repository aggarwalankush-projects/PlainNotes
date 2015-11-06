package com.example.anku.plainnotes;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class NotesCursorAdaptor extends CursorAdapter {
    public NotesCursorAdaptor(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.note_list_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String noteText = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NOTE_TEXT));
        if(noteText.contains("\n"))
            noteText = noteText.substring(0, noteText.indexOf('\n'))+"...";

        TextView listText= (TextView) view.findViewById(R.id.tvNote);
        listText.setText(noteText);

    }
}
