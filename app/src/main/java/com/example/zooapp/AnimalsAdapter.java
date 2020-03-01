/*
 * ANIMALS HOLDER
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

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsHolder>  {
    private final List<Animal> animals;
    private Context context;
    private int itemResource;

    public AnimalsAdapter(Context context, int itemResource, List<Animal> animals) {

        this.animals = animals;
        this.context = context;
        this.itemResource = itemResource;
    }

    @Override
    public AnimalsHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(this.itemResource, parent, false);
        return new AnimalsHolder(this.context, view);
    }

    @Override
    public void onBindViewHolder(AnimalsHolder holder, int position) {

        // Use position to access the correct place object
        Animal a = this.animals.get(position);

        // Bind the place object to the holder
        holder.bindAnimal(a);
    }

    // Return count of list
    @Override
    public int getItemCount() {
        return this.animals.size();
    }
}
