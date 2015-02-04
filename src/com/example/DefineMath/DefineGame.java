package com.example.DefineMath;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Bryan on 07/01/2015.
 */
public class DefineGame extends Activity {
    //The range of possible numbers
    //Increases by 10 every 10 levels
    int maxChoice = 10;
    int minChoice = -maxChoice;

    //The # of possible choices
    //NOTE: IF THIS EVER GETS UPDATED, ALL THE UI BUTTONS NEED TO BE UPDATED AS WELL
    final int CHOICES = 4;

    //The possible number choices
    //and the Buttons that contain them
    int[] currentNumbers;
    Button[] choiceButtons;

    //Represents the POSSIBLE Definitions of each Button as boolean matrix
    //CHOICES by DefinitionEnums.POS/2 matrix. 4 x 6 as of now.
    // Row is Button. Column is Definition Pos, Neg, Even, Odd, Prime, Comp
    boolean[][] allPossibleDefs;

    //The master list of all the POSSIBLE DEFINITIONS this turn.
    //There are 6 as of now. Pos, Neg, Even, Odd, Prime, Comp
    int[] masterPossibleDefs;

    //The score that will increase each time player picks a correct number.
    int score;
    TextView scoreText;


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

        initializeButtons();


        // Row is Button. Column is Definition Pos, Neg, Even, Odd, Prime, Comp
        allPossibleDefs = new boolean[CHOICES][DefinitionEnum.POS];
        masterPossibleDefs = new int[DefinitionEnum.POS];

        // Reset score to zero.
        scoreText = (TextView) findViewById(R.id.scoreNumber);
        setScore(0);

        //Determine the Possible Definitions for each Button
        updateAllPossibleDefs();

    }

    /*
     * Gets references to the Button Widgets
     * and creates a random number for each.
     */
    private void initializeButtons() {
        //TODO
        //There's gotta be a better way to do this...
        choiceButtons[0] = (Button)findViewById(R.id.button0);
        choiceButtons[1] = (Button)findViewById(R.id.button1);
        choiceButtons[2] = (Button)findViewById(R.id.button2);
        choiceButtons[3] = (Button)findViewById(R.id.button3);

        //Initialize 4 random numbers
        for (int x = 0; x < CHOICES; x++) {
            int choice = generateChoice();
            currentNumbers[x] = choice;
            setButtonText(x, choice);

            //Set listeners to each Button
            final int thisButtonIndex = x;
            choiceButtons[x].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //On Button press, check if number matches description
                    //and a whole bunch of other stuff...
                    choiceMadeHandler(thisButtonIndex);
                }
            });
        }
    }

    /* pre: 0 <= index < CHOICES
     * Handler for when a choice is made.
     * Checks whether chosen number matches description,
     * Generates new description,
     * Recalculates new Number
     * (and a whole lot of other stuff...)
     */
    private void choiceMadeHandler(int index){
        //TODO
        //just changes number for now
        changeChoiceButton(index);
        increaseScore();
    }

    /* Randomly generates a number in between maxChoice and minChoice
     * that does not already exist inside currentNumbers[]
     */
    private int generateChoice() {
        int choice;
        do {
            int range = (maxChoice - minChoice) + 1;
            choice = (int) (range * Math.random()) + minChoice;
        } while (currentlyContains(choice));
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

    /* Updates entire matrix of allPossibleDefs
    */
    private void updateAllPossibleDefs(){
        for(int b=0; b < CHOICES; b++){
            updatePossibleDefs(b);
        }
    }

    /* pre: 0 <= button < CHOICES
     * Updates the boolean matrix of allPossibleDefinitions
     * with the correct boolean values.
     */
    private void updatePossibleDefs(int button){
        //TODO
    }

    /*Increases the score and scoreText by 1.
     */
    private void increaseScore(){
        score++;
        scoreText.setText(Integer.toString(score));
    }

    /* Sets score and updates scoreText.
     */
    private void setScore(int s){
        score = s;
        scoreText.setText(Integer.toString(score));
    }

    /* True if and only if num is in currentNumbers
     * (and thus is currently displayed in choiceButtons)
     */
    private boolean currentlyContains(int num){
        for(int i : currentNumbers){
            if(i == num) return true;
        }
        return false;
    }


}


