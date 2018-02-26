package com.jayd.swissarmyknife.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.jayd.swissarmyknife.MyApplication;
import com.jayd.swissarmyknife.R;
import com.jayd.swissarmyknife.models.Note;
import com.jayd.swissarmyknife.room.note.NoteDBHelper;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private NoteDBHelper noteDBHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteDBHelper = ((MyApplication) getApplication()).getNoteDBHelper();

        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(l -> {
            Note note = new Note(UUID.randomUUID().toString(), editText.getText().toString());
            noteDBHelper.insert(note);
            editText.setText("");
        });
    }
}
