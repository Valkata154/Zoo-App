/*
 * MAIN MENU ACTIVITY
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.r0adkll.slidr.Slidr;

public class ActivityA extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        // Swipe to go back
        Slidr.attach(this);

        // Opens ANIMALS activity
        Button button2 = (Button) findViewById(R.id.animalsButton);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityAnimals = new Intent(ActivityA.this, ActivityAnimals.class);
                startActivity(activityAnimals);
            }
        });

        // Opens FOODSHOP activity
        Button foodButton = (Button) findViewById(R.id.foodButton);
        foodButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityFoodShop = new Intent(ActivityA.this, ActivityFoodShop.class);
                startActivity(activityFoodShop);
            }
        });

        // Opens CONTACT US activity
        Button button3 = (Button) findViewById(R.id.contactButton);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityContact = new Intent(ActivityA.this, ActivityContact.class);
                startActivity(activityContact);
            }
        });

        // Opens FEEDBACK activity
        Button button4 = (Button) findViewById(R.id.feedbackButton);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityFeedback = new Intent(ActivityA.this, FeedbackActivity.class);
                startActivity(activityFeedback);
            }
        });
    }
}
