package com.example.cleirmk.swipeappenchancement1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by CleirMk on 2/26/2018.
 */

class Main3Activity extends AppCompatActivity{

    int score = 0;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        View myView = (View) findViewById(R.id.myView);


        final CountDownTimer timer;
        {
            timer = new CountDownTimer(1000, 1000) {

                @Override
                public void onTick(long timeleft) {}

                @Override
                public void onFinish() {
                    Log.v("stupid timer", "I am so stupid");
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            Main3Activity.this);



                    // set title
                    alertDialogBuilder.setTitle("GAME OVER");

                    alertDialogBuilder
                            .setMessage("Score  " + score + "\n Play again");
                    alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, close
                            // current activity
                            Main3Activity.this.finish();
                        }
                    });


                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();


                }
            };
        }


        myView.setOnTouchListener(new OnSlidingListener(this) {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    timer.start();
                }
                return super.onTouch(v, event);
            }


            @Override
            public boolean onSwipeRight() {
                Log.d("right", "" + score + "");
                return true;
            }

            @Override
            public boolean onSwipeLeft() {
                Log.v("swipe", "left");
                return true;
            }

            @Override
            public boolean onSwipeTop() {
                Log.v("swipe", "top");
                score++;
                displayScore(score);
                Log.d("top", "" + score + "");
                return true;
            }

            @Override
            public boolean onSwipeBottom() {
                Log.v("swipe", "down");
                score++;
                displayScore(score);
                return true;
            }
        });
    }


    public void displayScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(String.valueOf(score));
    }


}


