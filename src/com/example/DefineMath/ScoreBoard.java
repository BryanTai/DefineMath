package com.example.DefineMath;

import android.widget.TextView;

/**
 * Created by Bryan on 13/02/2015.
 */
public class ScoreBoard {

    //The score that will increase each time player picks a correct number.
    int score;
    TextView scoreText;

    public ScoreBoard(TextView textView){
        scoreText = textView;
        setScore(0);
    }

    /*Increases the score and scoreText by 1.
     */
    public void increaseScore(){
        score++;
        scoreText.setText(Integer.toString(score));
    }

    /* Sets score and updates scoreText.
     */
    public void setScore(int s){
        score = s;
        scoreText.setText(Integer.toString(score));
    }
}
