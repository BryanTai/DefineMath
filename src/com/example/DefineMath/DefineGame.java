package com.example.DefineMath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import java.util.Arrays;

/**
 * Created by Bryan on 07/01/2015.
 */
public class DefineGame extends Activity {
    //The range of possible numbers
    final int MAX = 10;
    final int MIN = -MAX;

    //The # of possible choices
    //IF THIS GETS UPDATED, UI BUTTONS NEED TO BE UPDATED AS WELL
    final int CHOICES = 4;

    //The possible number choices
    int[] currentNumbers;
    Button[] choiceButtons;

    //Holds the all the DefinitionEnums of each number in each choiceButton
    int[][] allPossibleDefs;

    //The master list of all the possible definitions this turn.
    DefinitionEnum[] masterPossibleDefs;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.game);

        InitializeApp();
    }

    /* Initializes a new game
     */
    private void InitializeApp() {
        currentNumbers = new int[CHOICES];
        choiceButtons = new Button[CHOICES];

        //TODO
        //There's gotta be a better way to do this...
        choiceButtons[0] = (Button)findViewById(R.id.button0);
        choiceButtons[1] = (Button)findViewById(R.id.button1);
        choiceButtons[2] = (Button)findViewById(R.id.button2);
        choiceButtons[3] = (Button)findViewById(R.id.button3);

        //Choose 4 random numbers
        for (int x = 0; x < CHOICES; x++) {
            int choice = generateChoice();
            currentNumbers[x] = choice;
            setButtonText(x, choice);
        }

        allPossibleDefs = new int[CHOICES][];
        masterPossibleDefs = new DefinitionEnum[DefinitionEnum.POS];

    }



    /* Randomly generates a number in between MAX and MIN
     * that does not already exist inside currentNumbers[]
     */
    private int generateChoice() {
        int choice;
        do {
            int range = (MAX - MIN) + 1;
            choice = (int) (range * Math.random()) + MIN;
        } while (Arrays.asList(currentNumbers).contains(choice));
        return choice;
    }

    /* pre: 0 <= index < CHOICES
     * Changes the number of the Button at given index
     * Updates currentNumbers and choiceButtons at given index
     */
    private void changeChoiceButton(int index){
        int newChoice = generateChoice();
        currentNumbers[index] = newChoice;
        setButtonText(index,newChoice);
    }

    /* pre: 0 <= index < CHOICES, newChoice is valid choice.
     * Sets the text of Button at index
     */
    private void setButtonText(int index, int newChoice) {
        choiceButtons[index].setText(Integer.toString(newChoice));
    }


}


