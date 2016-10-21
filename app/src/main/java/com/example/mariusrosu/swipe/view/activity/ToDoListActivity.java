package com.example.mariusrosu.swipe.view.activity;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.mariusrosu.swipe.model.realm.RealmController;
import com.example.mariusrosu.swipe.view.BaseActivity;
import com.example.mariusrosu.swipe.R;
import com.example.mariusrosu.swipe.utils.IntentConstants;
import com.example.mariusrosu.swipe.view.adapter.RealmToDoAdapter;
import com.example.mariusrosu.swipe.view.utils.ItemTouchHelperCallback;
import com.example.mariusrosu.swipe.view.adapter.ToDoAdapter;
import com.example.mariusrosu.swipe.view.utils.ToDoItemDecoration;

import io.realm.RealmObject;

public class ToDoListActivity extends BaseActivity implements ToDoAdapter.OnItemActionListener {
    private CoordinatorLayout mCoordinatorLayout;
    private RecyclerView mRecyclerView;

    private ToDoAdapter mAdapter;
    int a;
    int integerFor;
    float someFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

        mAdapter = new ToDoAdapter(this);
        mAdapter.setRealmAdapter(new RealmToDoAdapter(this, RealmController.with(this).getTasks()));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(mAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        RecyclerView.ItemDecoration dividerItemDecoration
                = new ToDoItemDecoration(ResourcesCompat.getDrawable(getResources(), R.drawable.divider, null));
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void initializeViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_container);
        findViewById(R.id.main_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addTaskIntent = new Intent(ToDoListActivity.this, AddTaskActivity.class);
                startActivity(addTaskIntent);
            }
        });
    }

    @Override
    public void onItemClick(RealmObject item) {
        Intent viewTaskIntent = new Intent(this, ViewTaskActivity.class);
        //TODO: Handle Task object instead of RealmObject here.
        //viewTaskIntent.putExtra(IntentConstants.ITEM, item.getTitle());
        startActivity(viewTaskIntent);
    }

    @Override
    public void onItemDismiss(final RealmObject item, final int position) {
        Snackbar dismissSnackbar = Snackbar
                .make(mCoordinatorLayout, getString(R.string.delete_item, item), Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.undo), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mAdapter.addItem(item, position);
                        Snackbar restoreSnackbar = Snackbar.make(mCoordinatorLayout,
                                getString(R.string.restore_item, item), Snackbar.LENGTH_SHORT);
                        restoreSnackbar.show();
                    }
                });

        dismissSnackbar.show();
    }
}
