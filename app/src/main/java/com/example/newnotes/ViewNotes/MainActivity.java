package com.example.newnotes.ViewNotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newnotes.ModelNotes.NoteEntity;
import com.example.newnotes.ModelNotes.NoteFactory;
import com.example.newnotes.ModelNotes.NotesDB;
import com.example.newnotes.NotesViewModel;
import com.example.newnotes.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private static NotesViewModel notesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        notesViewModel = new ViewModelProvider(this, new NoteFactory(getApplication())).get(NotesViewModel.class);
        notesViewModel.notes.observe(this, new Observer<List<NoteEntity>>() {
            @Override
            public void onChanged(List<NoteEntity> noteEntities) {
                recyclerView.setAdapter(new NotesAdapter(noteEntities));
            }
        });

    }

    public void addNoteClickListener(View view) {
        startActivity(new Intent(this, AddNoteActivity.class));
    }
}