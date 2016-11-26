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

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mToneResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String mDTranslation,String mMTranslation, int mIRID, int mTRID){
        mDefaultTranslation = mDTranslation;
        mMiwokTranslation = mMTranslation;
        mImageResourceId = mIRID;
        mToneResourceId = mTRID;
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

    public int getmImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmToneResourceId(){
        return mToneResourceId;
    }
}
