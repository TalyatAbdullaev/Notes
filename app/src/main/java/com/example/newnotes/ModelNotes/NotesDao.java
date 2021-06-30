package com.example.newnotes.ModelNotes;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NotesDao {
    @Query("SELECT * FROM notes")
    LiveData<List<NoteEntity>> getAllNotes();

    @Insert
    void insertNote(NoteEntity note);

    @Delete
    void deleteNote(NoteEntity note);

    @Query("DELETE FROM notes")
    void deleteAllNotes();
}
