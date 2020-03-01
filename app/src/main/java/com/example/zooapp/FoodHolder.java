/*
 * FOOD HOLDER
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.shashank.sony.fancytoastlib.FancyToast;

import org.w3c.dom.Text;

public class FoodHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    private final ImageView locationIcon;
    private final TextView locationName;
    private final TextView foodDescription;
    private final TextView foodPrice;

    private Food food;
    private Context context;



    @Override
    public void onClick(View v) {
        if (this.food != null) {
            // Show a fancy toast on click
            FancyToast.makeText(this.context, (context.getString(R.string.orderToast1) + " " + food.getName() + " " + context.getString(R.string.orderToast2)),FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
            // Increment the basket and increase the total cost
            ActivityFoodShop.numBasket++;
            String priceString = food.getPrice().replace("Price: ", "");
            priceString = priceString.replace("Цена: ", "");
            double priceDouble = Double.parseDouble(priceString.replace("£", ""));
            ActivityFoodShop.numPrice += priceDouble;
        }
    }

    public void bindFood(Food food) {
        // Bind the data to the ViewHolder
        this.food = food;
        this.locationName.setText(food.getName());
        this.locationIcon.setImageDrawable(food.getIcon());
        this.foodDescription.setText(food.getDescription());
        this.foodPrice.setText(food.getPrice());
    }

    public FoodHolder(Context context, View itemView) {
        super(itemView);

        this.context = context;

        this.locationIcon =
                (ImageView) itemView.findViewById(R.id.entry_food_icon);
        this.locationName =
                (TextView) itemView.findViewById(R.id.entry_food_name);
        this.foodDescription =
                (TextView) itemView.findViewById(R.id.entry_food_description);
        this.foodPrice =
                (TextView) itemView.findViewById(R.id.entry_food_price);

        // Set the "onClick" listener of the holder
        itemView.setOnClickListener(this);
    }
}
