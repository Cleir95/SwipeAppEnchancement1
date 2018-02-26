package com.example.cleirmk.swipeappenchancement1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * Created by CleirMk on 2/26/2018.
 */

public class CountDownTimer {





    public CountDownTimer(float seconds) {

      CountDownTimer timer = new android.os.CountDownTimer(seconds, 1000) {

            @Override
            public void onTick(long timeleft) {}

            @Override
            public void onFinish() {
                Log.v("stupid timer", "I am so stupid");
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);



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

    }
}


