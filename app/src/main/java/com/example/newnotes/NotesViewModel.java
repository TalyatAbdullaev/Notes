package com.example.newnotes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.newnotes.ModelNotes.NoteEntity;
import com.example.newnotes.ModelNotes.NotesDB;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {
    private static NotesDB notesDB;
    public LiveData<List<NoteEntity>> notes;

    public NotesViewModel(@NonNull Application application) {
        super(application);

        notesDB = NotesDB.getInstance(application);
        notes = notesDB.notesDao().getAllNotes();
    }
}
