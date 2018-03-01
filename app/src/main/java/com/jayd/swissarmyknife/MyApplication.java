package com.jayd.swissarmyknife;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.facebook.stetho.Stetho;
import com.jayd.swissarmyknife.room.AppDatabase;
import com.jayd.swissarmyknife.room.note.NoteDBHelper;

public class MyApplication extends Application {

    private NoteDBHelper helper;

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "my_database")
                .allowMainThreadQueries()
                .build();
        helper = new NoteDBHelper(appDatabase);
    }

    public NoteDBHelper getNoteDBHelper() {
        return helper;
    }
}
