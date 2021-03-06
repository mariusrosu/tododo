package com.example.mariusrosu.swipe.view.utils;

/**
 * Created by Marius-Andrei Rosu on 29/08/16.
 *
 * Interface to notify a {@link android.support.v7.widget.RecyclerView.Adapter} of moving and dismissal
 * event from a {@link android.support.v7.widget.helper.ItemTouchHelper.Callback}.
 */

public interface ItemTouchHelperAdapter {
    /**
     * Called when an item has been dragged far enough to trigger a move. This is called every time
     * an item is shifted, and not at the end of a "drop" event.
     *
     * @param fromPosition The start position of the moved item.
     * @param toPosition   Then end position of the moved item.
     */
    void onItemMove(int fromPosition, int toPosition);


    /**
     * Called when an item has been dismissed by a swipe.
     *
     * @param position The position of the item dismissed.
     */
    void onItemDismiss(int position);
}
