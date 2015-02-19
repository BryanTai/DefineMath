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
    ChoiceButton[] choiceButtons;

    //Represents the POSSIBLE Definitions of each Button as boolean matrix
    //CHOICES by ChoiceEnums.POS/2 matrix. 4 x 6 as of now.
    // Row is Button. Column is Definition Pos, Neg, Even, Odd, Prime, Comp
   // boolean[][] allPossibleDefs;



    //Keeps track of score
    ScoreBoard scoreBoard;

    //Keeps track of Definition display and the possible definitions for each turn.
    DefineText defineText;

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

        initializeButtons();

        // Row is Button. Column is Definition Pos, Neg, Even, Odd, Prime, Comp
        //allPossibleDefs = new boolean[CHOICES][ChoiceEnum.POS];

        // Reset score to zero.
        scoreBoard = new ScoreBoard((TextView) findViewById(R.id.scoreNumber));
        // Set initial definitions
        defineText = new DefineText((TextView) findViewById(R.id.currentDefinition), this);

        //Determine and store the Possible Definitions from all buttons
       defineText.initializeAllPossibleDefs(choiceButtons);

    }

    /*
     * Gets references to the Button Widgets
     * and creates a random number for each.
     */
    private void initializeButtons() {
        choiceButtons = new ChoiceButton[CHOICES];
        int[] buttonArray = {R.id.button0,R.id.button1,R.id.button2,R.id.button3};

        //Initialize ChoiceButtons
        for(int x = 0; x < CHOICES; x++){
            int c = generateChoice();
            Button b = (Button)findViewById(buttonArray[x]);
            choiceButtons[x] = new ChoiceButton(c,b);

            //Set listeners to each Button
            final int thisButtonIndex = x;
            choiceButtons[x].getButtonWidget().setOnClickListener(new View.OnClickListener() {

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
        scoreBoard.increaseScore();
        defineText.pickDefinition();
    }

    /* Randomly generates a number in between maxChoice and minChoice
     * that does not already exist inside a choiceButton
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
     * Updates the definitions stored by defineText
     */
    private void changeChoiceButton(int index){
        defineText.removeButtonDefinitions(choiceButtons[index]);
        int newChoice = generateChoice();
        choiceButtons[index].setChoice(newChoice);
        defineText.addButtonDefinitions(choiceButtons[index]);
    }

    /*
     * True if and only if a choiceButton contains num
     * (and thus is currently displayed in choiceButtons)
     * If cb is null, return false
     */
    private boolean currentlyContains(int num){

        for(ChoiceButton cb : choiceButtons){
            if(cb == null) return false;
            if(cb.getChoice() == num) return true;
        }
        return false;
    }


    public ChoiceButton[] getChoiceButtons() {
        return choiceButtons;
    }

    public void setChoiceButtons(ChoiceButton[] choiceButtons) {
        this.choiceButtons = choiceButtons;
    }

}


