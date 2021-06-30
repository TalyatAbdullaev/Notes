package com.example.newnotes.ModelNotes;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {NoteEntity.class}, exportSchema = false, version = 1)
public abstract class NotesDB extends RoomDatabase {
    private static NotesDB notesDB;
    private static final String DB_NAME = "notes.db";
    private static Object LOCK = new Object();

    public static NotesDB getInstance(Context context) {
        synchronized (LOCK) {
            if (notesDB == null) {
                notesDB = Room.databaseBuilder(context, NotesDB.class, DB_NAME).build();
            }
        }
        return notesDB;
    }

    public abstract NotesDao notesDao();
}
