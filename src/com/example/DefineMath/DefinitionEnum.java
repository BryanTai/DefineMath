package com.example.DefineMath;

/**
 * Created by Bryan on 07/01/2015.
 */
public enum DefinitionEnum {
    //These are the POSSIBLE DEFINITIONS.
    // Can be possible definition depending on numbers.

    //Stores the index in the boolean[] that they'd be stored in.
    SIGN(0),    //True if Positive, False if Negative
    PARITY(1), //True if Even, False if Odd
    PRIME(2),   //True if Prime, False if Composite

    // These are the ALWAYS DEFINITIONS.
    // These will be possible definitions, no matter what numbers are chosen.

    EQUAL(3),
    INEQUAL(4),
    MORE(5),
    LESS(6);

    private final int INDEX;
    DefinitionEnum(int index){
        this.INDEX = index;
    }

    //Total number of POSSIBLE definitions
    public static final int POS = 3;

    /*Given a number, returns a boolean array that represents
     *all the Definitions the number contains
     *
     *
     *
    */
    public static boolean[] assignDefinitions(int x){
        //TODO
        boolean[] defs = new boolean[POS];
        defs[SIGN.INDEX]   = isPositive(x);
        defs[PARITY.INDEX] = isEven(x);
        defs[PRIME.INDEX]  = isPrime(x);

        return defs;
    }

    //Zero is neither positive nor negative.
    private static boolean isPositive(int x){
        return (x > 0) && (x != 0);
    }

    private static boolean isEven(int x){
        return (x % 2) == 0;
    }
    //Based on function written by Oscar_Sanchez
    //Note that negative numbers are composites.
    private static boolean isPrime(int x){
        //check if x is a multiple of 2
        //*but not actually 2
        if ((x > 2) && isEven(x)) return false;
        //if not, then just check the odds
        for(int i=3; i*i<=x; i+=2) {
            if(x%i==0)
                return false;
        }
        return true;
    }
}
