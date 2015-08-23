package com.aot.android.tasktracker;

import java.util.Date;
import java.util.UUID;

/**
 * Created by AoT on 8/21/2015.
 */
public class Task {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Task(){
        //Generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
