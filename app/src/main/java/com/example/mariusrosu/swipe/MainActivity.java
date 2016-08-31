package com.example.mariusrosu.swipe;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.example.mariusrosu.swipe.todo.ItemTouchHelperCallback;
import com.example.mariusrosu.swipe.todo.ToDoAdapter;
import com.example.mariusrosu.swipe.todo.ToDoItemDecoration;

public class MainActivity extends AppCompatActivity implements ToDoAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToDoAdapter adapter = new ToDoAdapter(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        RecyclerView.ItemDecoration dividerItemDecoration = new ToDoItemDecoration(ResourcesCompat.getDrawable(getResources(), R.drawable.divider, null));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onItemClick(String item) {
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }
}
