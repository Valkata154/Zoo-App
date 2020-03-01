/*
 * RECYCLERVIEW ACTIVITY WITH LIST OF ANIMALS
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;
import com.r0adkll.slidr.Slidr;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;

public class ActivityAnimals extends AppCompatActivity {

    private RecyclerView attractionsListView;
    private ArrayList<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        // Swipe to go back
        Slidr.attach(this);

        // Fancy toast to notify the user that images are clickable
        FancyToast.makeText(this,getString(R.string.toast_warning),FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();

        attractionsListView = (RecyclerView)findViewById(R.id.animals_list);
        attractionsListView.setHasFixedSize(true);

        // Gets the data
        loadAnimals();

        // Initialize the Places adapter, which binds the data to the entry view
        AnimalsAdapter adapter = new AnimalsAdapter(this, R.layout.animal_entry, animals);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        attractionsListView.setLayoutManager(layoutManager);
        attractionsListView.setAdapter(adapter);
    }


    // Method to load in the data for the animals
    private void loadAnimals() {
        animals = new ArrayList<Animal>();

        // Creating all the animal objects
        Animal tiger = new Animal(
                getString(R.string.tiger),
                R.drawable.tiger2,
                getString(R.string.tiger_info));

        Animal wolf = new Animal(
                getString(R.string.wolf),
                R.drawable.wolf,
                getString(R.string.wolf_info));
        Animal eagle = new Animal(
                getString(R.string.eagle),
                R.drawable.eagle,
                getString(R.string.eagle_info));
        Animal cow = new Animal(
                getString(R.string.cow),
                R.drawable.cow,
                getString(R.string.cow_info));
        Animal gorilla = new Animal(
                getString(R.string.gorilla),
                R.drawable.gorilla,
                getString(R.string.gorilla_info));
        Animal elephant = new Animal(
                getString(R.string.elephant),
                R.drawable.elephant,
                getString(R.string.elephant_info));

        // Adding the animals to the list
        animals.add(tiger);
        animals.add(wolf);
        animals.add(eagle);
        animals.add(cow);
        animals.add(gorilla);
        animals.add(elephant);
    }
}
