/*
 * ANIMAL DETAILS ACTIVITY
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.r0adkll.slidr.Slidr;

public class AnimalDetails extends AppCompatActivity {
    ViewFlipper v_flipper;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        // Swipe to go back
        Slidr.attach(this);

        Animal animal =
                (Animal) getIntent().getParcelableExtra("animal");

        if (animal != null) {
            TextView locationTitle =
                    (TextView) findViewById(R.id.animal_info_title);
            TextView locationInfo =
                    (TextView) findViewById(R.id.animal_info_body);

            locationTitle.setText(animal.getName());
            locationInfo.setText(animal.getInfo());
        }

        // Arrays with images for the different animals
        int imagesWolf[] = {R.drawable.wolf, R.drawable.wolf2, R.drawable.wolf3, R.drawable.wolf4};
        int imagesGorilla[] = {R.drawable.gorilla, R.drawable.gorilla2, R.drawable.gorilla3, R.drawable.gorilla4};
        int imagesEagle[] = {R.drawable.eagle, R.drawable.eagle2, R.drawable.eagle3, R.drawable.eagle4};
        int imagesTiger[] = {R.drawable.tiger2, R.drawable.tiger, R.drawable.tiger3, R.drawable.tiger4};
        int imagesElephant[] = {R.drawable.elephant, R.drawable.elephant2, R.drawable.elephant3, R.drawable.elephant4};
        int imagesCow[] = {R.drawable.cow, R.drawable.cow2, R.drawable.cow3, R.drawable.cow4};

        // View Flipper
        v_flipper = findViewById(R.id.v_flipper);
        ImageView animalMap = (ImageView) findViewById(R.id.location_image);

        // Check which animal is clicked and run the flipperImages method on its images, also change SOUND and MAP based on the animal
        if(animal.getName().equalsIgnoreCase("wolf") || animal.getName().equalsIgnoreCase("вълк")){
            animalMap.setImageResource(R.drawable.wolf_map);
            mp = MediaPlayer.create(this, R.raw.wolf_sound);
            for (int image: imagesWolf){
                flipperImages(image);
            }
        } else if(animal.getName().equalsIgnoreCase("tiger") || animal.getName().equalsIgnoreCase("тигър")){
            animalMap.setImageResource(R.drawable.tiger_map);
            mp = MediaPlayer.create(this, R.raw.tiger_sound);
            for (int image: imagesTiger){
                flipperImages(image);
            }
        } else if(animal.getName().equalsIgnoreCase("eagle") || animal.getName().equalsIgnoreCase("орел")){
            animalMap.setImageResource(R.drawable.eagle_map);
            mp = MediaPlayer.create(this, R.raw.eagle_sound);
            for (int image: imagesEagle){
                flipperImages(image);
            }
        } else if(animal.getName().equalsIgnoreCase("elephant") || animal.getName().equalsIgnoreCase("слон")){
            animalMap.setImageResource(R.drawable.elephant_map);
            mp = MediaPlayer.create(this, R.raw.elephant_sound);
            for (int image: imagesElephant){
                flipperImages(image);
            }
        } else if(animal.getName().equalsIgnoreCase("cow") || animal.getName().equalsIgnoreCase("крава")){
            animalMap.setImageResource(R.drawable.cow_map);
            mp = MediaPlayer.create(this, R.raw.cow_sound);
            for (int image: imagesCow){
                flipperImages(image);
            }
        } else if(animal.getName().equalsIgnoreCase("gorilla") || animal.getName().equalsIgnoreCase("горила")){
            animalMap.setImageResource(R.drawable.gorilla_map);
            mp = MediaPlayer.create(this, R.raw.gorilla_sound);
            for (int image: imagesGorilla){
                flipperImages(image);
            }
        }

        // Toggle the location image and the view flipper
        Button findMeBtn = (Button) findViewById(R.id.findMe);
        findMeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(findViewById(R.id.v_flipper).getVisibility() == View.INVISIBLE)
                {
                    findViewById(R.id.v_flipper).setVisibility(View.VISIBLE);
                    findViewById(R.id.location_image).setVisibility(View.INVISIBLE);
                }
                else if (findViewById(R.id.v_flipper).getVisibility() == View.VISIBLE)
                {
                    findViewById(R.id.v_flipper).setVisibility(View.INVISIBLE);
                    findViewById(R.id.location_image).setVisibility(View.VISIBLE);
                }
            }
        });

        // Play the animal sound of button click
        Button hearMeBtn = (Button) findViewById(R.id.hearMe);
        hearMeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.setVolume(100,100);
                mp.start();
            }
        });

    }

    // Method to flip the images
    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        // Add the image
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000); // 4s
        v_flipper.setAutoStart(true);

        // Animation for ViewFlipper
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
