package com.example.DefineMath;

import android.widget.Button;

/**
 * Created by Bryan on 06/02/2015.
 *
 * Represents the Buttons that the user presses to make their choice.
 */
public class ChoiceButton {
    private int choice;
    private Button buttonWidget;
    private boolean[] definitions;

    public ChoiceButton(int c, Button b){
        definitions = new boolean[ChoiceEnum.POS];
        buttonWidget = b;
        setChoice(c);

    }

    /*Given a number, returns a boolean array that represents
     *all the Definitions the number contains
     *
     *
     *
    */
    private void assignDefinitions(int x){
        definitions[ChoiceEnum.SIGN.getIndex()]   = isPositive(x);
        definitions[ChoiceEnum.PARITY.getIndex()] = isEven(x);
        definitions[ChoiceEnum.PRIME.getIndex()]  = isPrime(x);
    }

    //Zero is neither positive nor negative.
    private boolean isPositive(int x){
        return (x > 0) && (x != 0);
    }

    private boolean isEven(int x){
        return (x % 2) == 0;
    }
    //Based on function written by Oscar_Sanchez
    //Note that negative numbers are composites.
    private boolean isPrime(int x){
        if (x < 0) return false; //Negative numbers are not prime
        //check if x is a multiple of 2
        //but not actually 2 because 2 is prime
        if (x > 2 && isEven(x)) return false;
        //if not, then just check the odds
        for(int i=3; i*i<=x; i+=2) {
            if(x%i==0)
                return false;
        }
        return true;
    }


    //General getters and setters

    public int getChoice() {
        return choice;
    }

    //Update the Button text and definitions[] when we update the int
    public void setChoice(int choice) {
        this.choice = choice;
        buttonWidget.setText(Integer.toString(choice));
        assignDefinitions(choice);
    }

    public Button getButtonWidget() {
        return buttonWidget;
    }

    public void setButtonWidget(Button buttonWidget) {
        this.buttonWidget = buttonWidget;
    }

    public boolean[] getDefinitions() {
        return definitions;
    }

    public void setDefinitions(boolean[] definitions) {
        this.definitions = definitions;
    }
}
