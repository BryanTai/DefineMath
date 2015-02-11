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
        choice = c;
        buttonWidget = b;
        definitions = new boolean[DefinitionEnum.POS];
    }

    //TODO
    //poopy placeholder constructor
    //so initializeButtons doesn't complain
    public ChoiceButton(){
        choice = Integer.MAX_VALUE;
        buttonWidget = null;
        definitions = new boolean[DefinitionEnum.POS];
    }

    //General getters and setters

    public int getChoice() {
        return choice;
    }

    //Update the Button text when we update the int
    public void setChoice(int choice) {
        this.choice = choice;
        buttonWidget.setText(Integer.toString(choice));
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
