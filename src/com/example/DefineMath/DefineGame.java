package com.example.DefineMath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Bryan on 07/01/2015.
 */
public class DefineGame extends Activity {
    final int MAX = 10;
    final int MIN = -MAX;

    //Holds the DefinitionEnums of the 4 current numbers
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

    private void InitializeApp() {
        allPossibleDefs = new int[4][];
        masterPossibleDefs = new DefinitionEnum[DefinitionEnum.POS];

    }
}
