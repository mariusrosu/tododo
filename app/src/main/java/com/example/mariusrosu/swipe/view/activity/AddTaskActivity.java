package com.example.mariusrosu.swipe.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.mariusrosu.swipe.R;
import com.example.mariusrosu.swipe.model.Task;
import com.example.mariusrosu.swipe.model.realm.RealmController;

//Haha
public class AddTaskActivity extends AppCompatActivity {
    private EditText mTitleEditText;
    private EditText mDescriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        mTitleEditText = (EditText) findViewById(R.id.add_title);
        mDescriptionEditText = (EditText) findViewById(R.id.add_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//dada
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mTitleEditText.getText().toString();
                String description = mDescriptionEditText.getText().toString();
                RealmController.with(AddTaskActivity.this).addTask(new Task(title, description));
                finish();
            }
        });
    }

    public static final String DUMMY_STRING = "dummy_dummy_oh_so_dummy";

    public String getDummyString() {
        return DUMMY_STRING;
    }

    public void setDummyString(String newDummyString) {
        throw new RuntimeException("It's a constant, you dummy!");
    }
    //patru
    //cinci
    //sase
    //sapte

    //Unu, doi, trei
}
