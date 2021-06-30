package com.example.newnotes.ViewNotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.newnotes.ModelNotes.NoteEntity;
import com.example.newnotes.ModelNotes.NotesDB;
import com.example.newnotes.R;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextDescription;
    private Spinner spinnerDaysOfWeek;
    private RadioGroup radioGroupPriority;
    private static NotesDB notesDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        spinnerDaysOfWeek = findViewById(R.id.spinnerDaysOfWeek);
        radioGroupPriority = findViewById(R.id.radioGroupPriority);

        notesDB = NotesDB.getInstance(this);
    }

    public void saveNoteClickListener(View view) {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int dayOfWeekNumber = spinnerDaysOfWeek.getSelectedItemPosition();
        int priority = 0;
        int radioBtnId = radioGroupPriority.getCheckedRadioButtonId();
        switch (radioBtnId) {
            case R.id.radioBtnLow:
                priority = 0;
                break;
            case R.id.radioBtnMedium:
                priority = 1;
                break;
            case R.id.radioBtnHigh:
                priority = 2;
                break;
        }
        NoteEntity note = new NoteEntity(title, description, dayOfWeekNumber, priority);
        new AddNoteToDB().execute(note);
        startActivity(new Intent(this, MainActivity.class));
    }

    class AddNoteToDB extends AsyncTask<NoteEntity, Void, Void> {
        @Override
        protected Void doInBackground(NoteEntity... noteEntities) {
            NoteEntity note = noteEntities[0];
            notesDB.notesDao().insertNote(note);
            return null;
        }
    }
}

