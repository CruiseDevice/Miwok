package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Where are you going?", "minto wuksus",0,R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә",0,R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...",0,R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?",0,R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "kuchi achit",0,R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?",0,R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm",0,R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "әәnәm",0,R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis",0,R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem",0,R.raw.phrase_come_here));


        //  LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        //  ArrayAdapter<String> itemsAdapter  = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,words);

        // Create an {@link WordAdapter}, whose data source is the list of {@link Word}s.
        // The adapter knows how to create list items for each item in the list

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_phrases);

        ListView listView  = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();
                Word word = words.get(position);
                mp = MediaPlayer.create(PhrasesActivity.this,word.getmToneResourceId());
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
