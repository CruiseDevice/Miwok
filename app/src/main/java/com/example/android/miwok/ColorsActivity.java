package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("red", "weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("green", "chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("black", "kululli",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("white", "kelelli",R.drawable.color_white,R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        //  LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        //  ArrayAdapter<String> itemsAdapter  = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,words);

        // Create an {@link WordAdapter}, whose data source is the list of {@link Word}s.
        // The adapter knows how to create list items for each item in the list

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_colors);

        ListView listView  = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();
                Word word = words.get(position);

                mp = MediaPlayer.create(ColorsActivity.this,word.getmToneResourceId());

                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {

                        Toast.makeText(getApplicationContext(),"audio finised",Toast.LENGTH_SHORT).show();
                        // Now that the sound file has finished playing, release the media player resources.
                        releaseMediaPlayer();
                    }

                });

                mp.start();
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        //When the activity is stopped, release the MediaPlayer resources because we
        //won't be playing any more sounds
        releaseMediaPlayer();
    }

    public void releaseMediaPlayer(){
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;
        }
    }
}
