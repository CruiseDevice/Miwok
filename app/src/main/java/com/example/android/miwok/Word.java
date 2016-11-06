package com.example.android.miwok;

/**
 * {@link_Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and Miwok translation for that word.
 */
public class Word {

    /*Default translation for the word */
    private String mDefaultTranslation;

    /*Miwok translation fot the word*/
    private String mMiwokTranslation;


    public Word(String mDTranslation,String mMTranslation){
        mDefaultTranslation = mDTranslation;
        mMiwokTranslation = mMTranslation;
    }

    /**
     * Get the Miwok word
     */
    public String getMiwokWord() {
        return mMiwokTranslation;
    }

    /**
     * Get the Default Word
     */
    public String getDefaultWord() {
        return mDefaultTranslation;
    }
}
