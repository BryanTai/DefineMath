package com.example.DefineMath;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by Bryan on 13/02/2015.
 */
public class DefineText {

    //The master list of how many ChoiceButtons fall under each of the POSSIBLE DEFINITIONS this turn.
    //There are 6 as of now. In order: Pos, Neg, Even, Odd, Prime, Comp
    int[] allPossibleDefs;
    int[] definitionStrings =
            {R.string.positive,R.string.negative,R.string.even,R.string.odd,R.string.prime,R.string.composite};

    TextView definitionText;
    Context context;

    public DefineText(TextView definitionText, Context context){
        this.context = context;
        this.definitionText = definitionText;
        allPossibleDefs = new int[2 * ChoiceEnum.POS];
    }

    /* pre: The ChoiceButtons in choiceButtons have already been initialized.
     * Goes through each button and tallys up how many of each definition are present
     * Saves the tallys in allPossibleDefs.
     */
    public void initializeAllPossibleDefs(ChoiceButton[] choiceButtons){
        for(ChoiceButton cb : choiceButtons){
            addButtonDefinitions(cb);
        }
        //Update the textView
        pickDefinition();
    }

    //TODO
    //Perhaps use Command Pattern in order to not repeat so much code?

    /*
     * Called to update allPossibleDefinitions when a button is removed from game
     */
    public void removeButtonDefinitions(ChoiceButton choiceButton){
        boolean[] definitions = choiceButton.getDefinitions();
        for(int i = 0; i < definitions.length; i++) {
            //allPossibleDefs array definitions are set up in pairs
            //ex. Pos is 0, Neg is 1
            int allIndex = definitions[i] ? 2*i : 2*i + 1;
            allPossibleDefs[allIndex]--;
        }
    }

    /*
     * Called to update allPossibleDefinitions when a button is added to the game
     */
    public void addButtonDefinitions(ChoiceButton choiceButton){
        boolean[] definitions = choiceButton.getDefinitions();
        for(int i = 0; i < definitions.length; i++) {
            //allPossibleDefs array definitions are set up in pairs
            //ex. Pos is 0, Neg is 1
            int allIndex = definitions[i] ? 2*i : 2*i + 1;
            allPossibleDefs[allIndex]++;
        }
    }

    /*
     * Randomly picks a definition to display, either POSSIBLE or ALWAYS
     * as long as at least 1 choice button has that definition.
     */

    public void pickDefinition(){
        //TODO
        //For now, just use the least common definition from POSSIBLE...
        //We'll add randomization later.

        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < allPossibleDefs.length; i++){
            int x = allPossibleDefs[i];
            //looking for the definition with the least buttons associated
            //but at least one button has that definition.
            if(x > 0 && x < minValue){
                minIndex = i;
                minValue = x;
            }
        }

        updateTextView(minIndex);
    }

    /*
     * Changes the TextView to be the definition at definitionStrings at the given index
     */
    private void updateTextView(int index){
        definitionText.setText(context.getString(definitionStrings[index]));
    }

}
