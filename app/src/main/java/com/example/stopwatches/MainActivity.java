package com.example.stopwatches;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private boolean running;

    private boolean wasRunning;
    private int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        if (savedInstanceState != null) {

            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();

    }

    private void runTimer() {
        final TextView timeView = findViewById(R.id.time_view);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours = seconds/3600;
                int minutes = (seconds % 3600)/60;
                int sec = seconds % 60;

                String time = String.format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, sec);

                // Set the text view text.
                timeView.setText(time);

                // If running is true, increment the
                // seconds variable.
                if (running) {
                    seconds++;
                }

                // Post the code again
                // with a delay of 1 second.
                handler.postDelayed(this, 1000);



            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        wasRunning = running;
        running = false;
    }

    // If the activity is resumed,
    // start the stopwatch
    // again if it was running previously.
    @Override
    protected void onResume()
    {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }


    public  void onClickStart(View view){

        running = true;
    }
    public  void onClickStop(View view){
        running = false;
    }
    public  void onClickStopReset(View view){

        running = false;
        seconds = 0;
    }
}