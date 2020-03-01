/*
 * CONTACT US ACTIVITY
 *
 * Created By: 40399682
 */

package com.example.zooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.r0adkll.slidr.Slidr;
import com.shashank.sony.fancytoastlib.FancyToast;

public class ActivityContact extends AppCompatActivity {
    // Set all the variables and duration time
    private ImageView imageView;
    long animationDurationX = 1500;
    long animationDurationY = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Swipe to go back
        Slidr.attach(this);

        // Open MAPS activity when clicking on imageButton.
        ImageButton imageButton = (ImageButton) findViewById(R.id.map);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityMaps = new Intent(ActivityContact.this, MapsActivity.class);
                startActivity(activityMaps);
            }
        });
        imageView = (ImageView) findViewById(R.id.dollarSign);
    }

    public void handleAnimation(View view){
        // When clicked make imageView visible
        imageView.setVisibility(View.VISIBLE);
        // Set all the animations
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(imageView,View.ALPHA, 0.0f, 1.0f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageView,"rotation", 0f, 360f);
        ObjectAnimator animatorZ = ObjectAnimator.ofFloat(imageView,View.ALPHA, 1.0f, 0.0f);
        // Set duration for the animations
        animatorX.setDuration(animationDurationX);
        animatorY.setDuration(animationDurationY);
        animatorZ.setDuration(animationDurationX);
        // Set delay for the dissapear animation
        animatorZ.setStartDelay(2500);
        // Play the animations
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorX, animatorY, animatorZ);
        animatorSet.start();

        // Display a success toast
        FancyToast.makeText(this,getString(R.string.toast_donate),FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
    }
}
