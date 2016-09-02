package com.example.mariusrosu.swipe.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.mariusrosu.swipe.view.BaseActivity;
import com.example.mariusrosu.swipe.R;
import com.example.mariusrosu.swipe.utils.IntentConstants;

public class ViewTaskActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);

        handleIntent();
    }

    private void handleIntent() {
        //TODO: Handle task intent
        /*Intent intent = getIntent();
        if (intent != null) {
            Bundle args = intent.getExtras();
            intializeToolbar(args.getString(IntentConstants.ITEM));
        }*/
    }

    private void intializeToolbar(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (title != null) {
            setTitle(title);
        }
    }
}
