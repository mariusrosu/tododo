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

public class AddTaskActivity extends AppCompatActivity {
    private EditText mTitleEditText;
    private EditText mDescriptionEditText;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        mTitleEditText = (EditText) findViewById(R.id.add_title);
        mDescriptionEditText = (EditText) findViewById(R.id.add_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
    //mess //mess //mess //mess //mess //mess //mess //mess //mess //mess
    //mess //mess //mess
    //mess //mess //mess //mess //mess //mess
    //mess
    //mess //mess //mess //mess
    //Start Car1
    //Start Car2
}
