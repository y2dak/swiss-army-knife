package com.jayd.swissarmyknife.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.Toolbar;

import com.jayd.swissarmyknife.R;
import com.jayd.swissarmyknife.fragments.CalendarFragment;
import com.jayd.swissarmyknife.fragments.ExpenseFragment;
import com.jayd.swissarmyknife.fragments.NoteFragment;
import com.jayd.swissarmyknife.room.note.NoteDBHelper;

public class MainActivity extends AppCompatActivity {

    private NoteDBHelper noteDBHelper;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    //Tab numbers
    private static final int Calendar = 0;
    private static final int Notes = 1;
    private static final int Expenses = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeViewPager();

        //TODO: Move commented code into Note fragment
//        noteDBHelper = ((MyApplication) getApplication()).getNoteDBHelper();

//        final EditText editText = findViewById(R.id.editText);
//        final Button button = findViewById(R.id.button);
//        button.setOnClickListener(l -> {
//            Note note = new Note(UUID.randomUUID().toString(), editText.getText().toString());
//            noteDBHelper.insert(note);
//            editText.setText("");
//        });
    }

    private void initializeViewPager(){
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);


        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //Set tab icons
        tabLayout.getTabAt(Calendar).setIcon(R.drawable.ic_calendar_icon);
        tabLayout.getTabAt(Notes).setIcon(R.drawable.ic_note_icon);
        tabLayout.getTabAt(Expenses).setIcon(R.drawable.ic_expenses_icon);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private static final int TAB_COUNT = 3;

        public ViewPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case Calendar:
                    return CalendarFragment.newInstance();
                case Notes:
                    return NoteFragment.newInstance();
                case Expenses:
                    return ExpenseFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }
    }
}
