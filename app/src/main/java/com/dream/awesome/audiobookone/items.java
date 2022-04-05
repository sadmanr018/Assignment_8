package com.dream.awesome.audiobookone;

public class items {
    private final int mImageResource;
    private final String mText1;
    private final String mText2;

    public items(int imageResource, String text1, String text2) {
        this.mImageResource = imageResource;
        this.mText1 = text1;
        this.mText2 = text2;
    }

    public int getImageResource() {
        return this.mImageResource;
    }

    public String getText1() {
        return this.mText1;
    }

    public String getText2() {
        return this.mText2;
    }
}