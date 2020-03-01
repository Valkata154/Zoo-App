/*
 * FOOD ACTIVITY
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

import java.util.ArrayList;

public class ActivityFoodShop extends AppCompatActivity {
    // Variables
    private RecyclerView attractionsListView;
    private ArrayList<Food> foodList;
    public static int numBasket = 0;
    public static double numPrice = 0.00;
    private TextView basketCount;
    private TextView totalPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_shop);

        // Swipe to go back
        Slidr.attach(this);

        basketCount = (TextView) findViewById(R.id.basket);
        totalPrice = (TextView) findViewById(R.id.totalPrice);

        // Thread to update the text every 0.5seconds
        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                basketCount.setText(String.valueOf(numBasket));
                                totalPrice.setText(getString(R.string.total) + " " + String.valueOf(Math.round(numPrice * 100.0) / 100.0) + "£");
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        // Start the thread
        t.start();

        attractionsListView = (RecyclerView)findViewById(R.id.foods_list);
        // if the recyclerview doesn't change size, we can set this true and
        attractionsListView.setHasFixedSize(true);

        // get the data
        loadFood();

        // Initialize the Places adapter, which binds the data to the entry view

        FoodAdapter adapter =
                new FoodAdapter(this, R.layout.food_entry, foodList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        attractionsListView.setLayoutManager(layoutManager);

        attractionsListView.setAdapter(adapter);

    }

    private void loadFood() {
        foodList = new ArrayList<Food>();

        // Creating all the food objects
        Food pizza = new Food(
                getString(R.string.pizza),
                getResources().getDrawable(R.drawable.pizza),
                getString(R.string.pizzaDesc),
                getString(R.string.pizzaP));

        Food steak = new Food(
                getString(R.string.steak),
                getResources().getDrawable(R.drawable.steak),
                getString(R.string.steakDesc),
                getString(R.string.steakP));

        Food soup = new Food(
                getString(R.string.soup),
                getResources().getDrawable(R.drawable.soup),
                getString(R.string.soupDesc),
                getString(R.string.soupP));

        Food chickenRice = new Food(
                getString(R.string.chickenRice),
                getResources().getDrawable(R.drawable.chicken_rice),
                getString(R.string.chickenRiceDesc),
                getString(R.string.chickenRiceP));

        Food fishChips = new Food(
                getString(R.string.fishChips),
                getResources().getDrawable(R.drawable.salmon_chips),
                getString(R.string.fishChipsDesc),
                getString(R.string.fishChipsP));

        Food sushi = new Food(
                getString(R.string.sushi),
                getResources().getDrawable(R.drawable.sushi),
                getString(R.string.sushiDesc),
                getString(R.string.sushiP));

        // Adding the items to the list
        foodList.add(pizza);
        foodList.add(steak);
        foodList.add(soup);
        foodList.add(chickenRice);
        foodList.add(fishChips);
        foodList.add(sushi);
    }

    // Running the dialog on click
    public void orderSubmit(View view){
        openDialog();
    }

    // Method to create a dialog
    public void openDialog(){
        DialogOrder dialog = new DialogOrder();
        dialog.show(getSupportFragmentManager(), "Dialog");
    }
}
