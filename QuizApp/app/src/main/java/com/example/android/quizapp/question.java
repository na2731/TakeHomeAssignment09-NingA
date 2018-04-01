package com.example.android.quizapp;

/**
 * Created by anning on 2018/4/1.
 */

public class question {
    public int photoId;
    public String question;
    public boolean isTrue;

    public void setPhotoId(int photoId){this.photoId=photoId;}

    public int getPhotoId(){return photoId;}

    public void setQuestions(String question){this.question=question;}

    public String getQuestions(){return question;}

    public void setTrue(boolean isTrue){this.isTrue=isTrue;}

    public boolean isTrue(){return isTrue;}

    public question(int photoId,String question,boolean isTrue){
        this.photoId=photoId;
        this.question=question;
        this.isTrue=isTrue;
    }
}
