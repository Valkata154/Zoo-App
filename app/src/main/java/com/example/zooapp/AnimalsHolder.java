/*
 * ANIMALS HOLDER
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;


public class AnimalsHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    private final ImageView animalIcon;
    private final TextView animalName;

    private Animal animal;
    private Context context;

    public AnimalsHolder(Context context, View itemView) {
        super(itemView);

        this.context = context;

        this.animalIcon =
                (ImageView) itemView.findViewById(R.id.entry_animal_icon);
        this.animalName =
                (TextView) itemView.findViewById(R.id.entry_animal_name);

        // Set the "onClick" listener of the holder to this
        itemView.setOnClickListener(this);
    }


    public void bindAnimal(Animal animal) {
        // Bind the data to the ViewHolder
        this.animal = animal;
        this.animalName.setText(animal.getName());
        this.animalIcon.setImageDrawable(this.context.getResources().getDrawable(animal.getIconId()));
    }

    @Override
    public void onClick(View v) {
        // Create the click method
        if (this.animal != null) {
            Intent intent = new Intent(itemView.getContext(), AnimalDetails.class);
            intent.putExtra("animal", this.animal);
            itemView.getContext().startActivity(intent);
        }
    }
}
