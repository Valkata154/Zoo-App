/*
* START PAGE
*
* Created By: 40399682
*/
package com.example.zooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Opens MENU activity
        Button button1 = (Button) findViewById(R.id.menuButton);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityAnimals = new Intent(MainActivity.this, ActivityA.class);
                startActivity(activityAnimals);
            }
        });
    }
}
