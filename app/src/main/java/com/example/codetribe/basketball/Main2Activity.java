package com.example.codetribe.basketball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.PersistableBundle;


public class Main2Activity extends AppCompatActivity {

    Button a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        a=(Button) findViewById(R.id.button4);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(z);
            }
        });
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.foul_a);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.foul_b);
        scoreView.setText(String.valueOf(score));
    }

    public void displayRedA(int red) {
        TextView redView = (TextView) findViewById(R.id.Red_a);
        redView.setText(String.valueOf(red));
    }
    public void displayRedB(int red) {
        TextView redView = (TextView) findViewById(R.id.Red_B);
        redView.setText(String.valueOf(red));
    }

    //Variables
    int TeamA = 0;
    int TeamB = 0;
    int RedA = 0;
    int RedB= 0;

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
    public void RedA(View view) {
        RedA = RedA + 1;
        displayRedA(RedA);

    }
    public void RedB(View view) {
        RedB = RedB + 1;
        displayRedB(RedB);

    }

    //click action for TeamB plus 2

    //Click action for Reset
    public void reset(View view) {
        TeamB = 0;
        TeamA = 0;
        RedB = 0;
        RedA = 0;
        displayForTeamA(TeamA);
        displayForTeamB(TeamB);
        displayRedB(RedB);
        displayRedA(RedA);
    }

}


