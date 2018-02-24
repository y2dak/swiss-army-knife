package com.jayd.swissarmyknife;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.jayd.swissarmyknife.models.Note;
import com.jayd.swissarmyknife.room.AppDatabase;
import com.jayd.swissarmyknife.room.note.NoteDao;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
        final NoteDao noteDao = appDatabase.noteDao();
        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(l -> noteDao.insert(new Note(UUID.randomUUID().toString(), editText.getText().toString())));
    }
}
