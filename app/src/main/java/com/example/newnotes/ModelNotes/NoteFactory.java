package com.example.newnotes.ModelNotes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.newnotes.NotesViewModel;

public class NoteFactory extends ViewModelProvider.NewInstanceFactory {
    private Application application;

    public NoteFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == NotesViewModel.class)
            return (T) new NotesViewModel(application);

        return null;
    }
}
