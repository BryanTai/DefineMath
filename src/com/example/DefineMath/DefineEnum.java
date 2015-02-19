package com.example.DefineMath;

import android.content.Context;
/**
 * Created by Bryan on 13/02/2015.
 */
public enum DefineEnum {
    //definitions for printing onto DefineText
    //TODO
    //These are the POSSIBLE DEFINITIONS.
    // Can be possible definition depending on numbers.

    POSITIVE(0),    //True if Positive, False if Negative
    PARITY(1), //True if Even, False if Odd
    PRIME(2),   //True if Prime, False if Composite

    // These are the ALWAYS DEFINITIONS.
    // These will be possible definitions, no matter what numbers are chosen.

    EQUAL(3),
    INEQUAL(4),
    MORE(5),
    LESS(6);

    private final int INDEX;
    DefineEnum(int index){
        this.INDEX = index;

    }

    //Total number of POSSIBLE definitions
    public static final int POS = 3;

    public int getIndex(){
        return INDEX;
    }
}
