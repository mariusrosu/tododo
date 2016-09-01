package com.example.mariusrosu.swipe.view.todo;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.mariusrosu.swipe.BaseActivity;
import com.example.mariusrosu.swipe.R;
import com.example.mariusrosu.swipe.utils.IntentConstants;
import com.example.mariusrosu.swipe.view.task.AddTaskActivity;
import com.example.mariusrosu.swipe.view.task.ViewTaskActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToDoListActivity extends BaseActivity implements ToDoAdapter.OnItemActionListener {
    @BindView(R.id.main_container)
    CoordinatorLayout mCoordinatorLayout;

    @BindView(R.id.main_recycler)
    RecyclerView mRecyclerView;

    private ToDoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new ToDoAdapter(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(mAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        RecyclerView.ItemDecoration dividerItemDecoration
                = new ToDoItemDecoration(ResourcesCompat.getDrawable(getResources(), R.drawable.divider, null));
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onItemClick(String item) {
        Intent viewTaskIntent = new Intent(this, ViewTaskActivity.class);
        viewTaskIntent.putExtra(IntentConstants.ITEM, item);
        startActivity(viewTaskIntent);
    }

    @Override
    public void onItemDismiss(final String item, final int position) {
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

    @OnClick(R.id.main_add)
    public void onClick() {
        Intent addTaskIntent = new Intent(this, AddTaskActivity.class);
        startActivity(addTaskIntent);
    }
}
