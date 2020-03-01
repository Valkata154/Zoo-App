/*
 * FOOD ADAPTER
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodHolder> {
    private final List<Food> foodList;
    private Context context;
    private int itemResource;

    public FoodAdapter(Context context, int itemResource, List<Food> foodList) {

        this.foodList = foodList;
        this.context = context;
        this.itemResource = itemResource;

    }

    @Override
    public FoodHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(this.itemResource, parent, false);
        return new FoodHolder(this.context, view);
    }

    @Override
    public void onBindViewHolder(FoodHolder holder, int position) {

        // Use position to access the correct food object
        Food f = this.foodList.get(position);

        // Bind the food object to the holder
        holder.bindFood(f);
    }

    // Return count of list
    @Override
    public int getItemCount() {
        return this.foodList.size();
    }
}
