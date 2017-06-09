package com.example.codetribe.basketball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView next;
    private int seconds=0;
    private  boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next =(TextView) findViewById(R.id.textView6);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });

        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }

        runTimer();



    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_a);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_b);
        scoreView.setText(String.valueOf(score));
    }



    //Variables
    int TeamA = 0;
    int TeamB = 0;


    //Click action for TeamA plus 1

    public void TeamA(View view) {
        TeamA = TeamA + 1;
        displayForTeamA(TeamA);

    }




    //Click action for TeamB plus 3

    public void TeamB(View view) {
        TeamB = TeamB + 1;
        displayForTeamB(TeamB);

    }

    //click action for TeamB plus 2

    //Click action for Reset
    public void reset(View view) {
        TeamB = 0;
        TeamA = 0;
        displayForTeamA(TeamA);
        displayForTeamB(TeamB);
        running=false;
        seconds=0;
    }




    public void onClickStart(View view){
        running = true;
    }

    public void onClickStop(View view){
        running = false;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstantState) {
        savedInstantState.putInt("seconds",seconds);
        savedInstantState.putBoolean("running", running);
        savedInstantState.putBoolean("wasRunning",wasRunning);
    }


    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(wasRunning){
            running = true;
        }
    }

    private void runTimer(){
        final TextView timeView = (TextView)findViewById(R.id.time_view);

        final android.os.Handler handler = new android.os.Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minute = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format("%d:%02d:%02d", hours,minute,secs);

                timeView.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }

        });
    }

}

