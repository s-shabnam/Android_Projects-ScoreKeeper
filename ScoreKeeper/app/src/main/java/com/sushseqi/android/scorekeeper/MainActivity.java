package com.sushseqi.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {


    // Player A
    PlayerImpl playerA = new PlayerImpl("playerA");

    // Player B
    PlayerImpl playerB = new PlayerImpl("playerB");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // common methods for both players

    /* Initialise all the parameters of the game*/
    public void resetScore(View v) {
        playerA.init();
        playerB.init();

        refreshScreen();

    }

    /* Refresh screen display */
    public void refreshScreen() {
        refreshScoreA();
        refreshScoreB();

        refreshAttactNbA();
        refreshAttactNbB();
    }

    /* Mark a draw game */
    public void markDrawGame(View view) {

        playerA.markDrawGame();
        playerB.markDrawGame();

        playerA.setAttackNumber(0);
        playerB.setAttackNumber(0);

        refreshScreen();
    }

 ///////////////// Player A ///////////////////////
    /**
     * Increase by score unit the score of Player A.
     */
    public void addScoreForPlayerA(View v) {
        playerA.addScoreUnit();
        refreshScoreA();
    }

    /**
     * Displays the score of player A.
     */
    public void refreshScoreA() {
        //refresh score
        TextView txtView = (TextView) findViewById(R.id.player_a_score);
        txtView.setText(String.valueOf(playerA.getScore()));
    }

    public void attactA(View v){
        playerA.attack();
        refreshAttactNbA();
    }

    /**
     * Displays the chrono of player A.
     */
    public void refreshAttactNbA(){
        //refresh consumed time
        TextView txtView = (TextView) findViewById(R.id.player_a_atactN);
        txtView.setText(String.valueOf("Attacts done : "+ playerA.getAttackNumber()));
    }

////////////// Player B////////////////////////
    /**
     * Increase by score unit the score of  B.
     */
    public void addScoreForPlayerB(View v) {
        playerB.addScoreUnit();
        refreshScoreB();
    }


    /**
     * Displays the datas of player B.
     */
    public void refreshScoreB() {
        //refresh score
        TextView txtView = (TextView) findViewById(R.id.player_b_score);
        txtView.setText(String.valueOf(playerB.getScore()));
    }

    public void attactB(View v){
        playerB.attack();
        refreshAttactNbB();
    }

    /**
     * Displays the nb attacts done by player B.
     */
    public void refreshAttactNbB(){
        //refresh consumed time
        TextView txtView = (TextView) findViewById(R.id.player_b_attactN);
        txtView.setText(String.valueOf("Attacts done : "+ playerB.getAttackNumber()));

    }



}

