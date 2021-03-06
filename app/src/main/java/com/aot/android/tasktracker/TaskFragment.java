package com.aot.android.tasktracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
//import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import java.text.DateFormat;

/**
 * Created by AoT on 8/21/2015.
 */
public class TaskFragment extends Fragment {
    private Task mTask;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    private android.text.format.DateFormat mDateFormat;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mTask = new Task();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_task, container, false);
        mTitleField = (EditText)v.findViewById(R.id.task_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTask.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //Doing some date format here. I don't know why github sometimes detects the change here and sometimes it doesn't
        mDateButton =  (Button)v.findViewById(R.id.task_date);
        DateFormat dateFormat = mDateFormat.getLongDateFormat(getActivity());
        dateFormat.format(mTask.getDate());
        mDateButton.setText(dateFormat.format(mTask.getDate()));
        mDateButton.setEnabled(false);
        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.task_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTask.setSolved(isChecked);
            }
        });
        return v;
    }
}
