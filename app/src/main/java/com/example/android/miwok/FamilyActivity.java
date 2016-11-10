package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create a list of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("father", "әpә"));
        words.add(new Word("mother", "әṭa"));
        words.add(new Word("son", "angsi"));
        words.add(new Word("daughter", "tune"));
        words.add(new Word("older brother", "taachi"));
        words.add(new Word("younger brother", "chalitti"));
        words.add(new Word("older sister", "teṭe"));
        words.add(new Word("younger sister", "kolliti"));
        words.add(new Word("grandmother", "ama"));
        words.add(new Word("grandfather", "paapa"));


        //  LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        //  ArrayAdapter<String> itemsAdapter  = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,words);

        // Create an {@link WordAdapter}, whose data source is the list of {@link Word}s.
        // The adapter knows how to create list items for each item in the list

        WordAdapter adapter = new WordAdapter(this,words);

        ListView listView  = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
