/*
 * FEEDBACK PAGE
 *
 * Created By: 40399682
 */
package com.example.zooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.hsalf.smilerating.SmileRating;
import com.r0adkll.slidr.Slidr;

public class FeedbackActivity extends AppCompatActivity {
    private Firebase Ref;
    private EditText username, feedback, likes, dislikes;
    private String rating;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        button = (Button) findViewById(R.id.buttonFeedback);

        // Swipe to go back
        Slidr.attach(this);

        // Smiley Face Rating Bar
        SmileRating smileRating = (SmileRating) findViewById(R.id.smile_rating);
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                // Swtich to get the rating and save it to a string
                switch (smiley) {
                    case SmileRating.BAD:
                        rating = "Bad";
                        break;
                    case SmileRating.GOOD:
                        rating = "Good";
                        break;
                    case SmileRating.GREAT:
                        rating = "Great";
                        break;
                    case SmileRating.OKAY:
                        rating = "Okay";
                        break;
                    case SmileRating.TERRIBLE:
                        rating = "Terrible";
                        break;
                }
            }
        });

        smileRating.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

            }
        });

        // Firebase and assigning the variables
        username = (EditText)findViewById(R.id.username);
        feedback = (EditText)findViewById(R.id.feedback);
        likes = (EditText)findViewById(R.id.likes);
        dislikes = (EditText)findViewById(R.id.dislikes);
        Firebase.setAndroidContext(this);
        Ref=new Firebase("https://zoo-app-821c1.firebaseio.com/");
    }

    // Method to get the text and send it to the firebase
    public void feedbackSent(View view){
        String usernameInput = username.getText().toString();
        String feedbackInput = feedback.getText().toString();
        String likesInput = likes.getText().toString();
        String dislikesInput = dislikes.getText().toString();
        Firebase Refusername = Ref.child("Username");
        Refusername.setValue(usernameInput);
        Firebase Reffeedback = Ref.child("Feedback");
        Reffeedback.setValue(feedbackInput);
        Firebase Reflikes = Ref.child("What they liked:");
        Reflikes.setValue(likesInput);
        Firebase Refdislikes = Ref.child("What they disliked:");
        Refdislikes.setValue(dislikesInput);
        Firebase Refrating = Ref.child("Rating");
        Refrating.setValue(rating);

        // Show dialog
        openDialog();
    }

    // Method to create a dialog
    public void openDialog(){
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "Dialog");
    }
}
