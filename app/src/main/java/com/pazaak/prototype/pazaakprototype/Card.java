package com.pazaak.prototype.pazaakprototype;

import android.graphics.drawable.Drawable;

public class Card {
    private int cardId;
    private int cardType;
    private int cardValue;
    public static final int PLUS = -1;
    public static final int MINUS = -2;
    public static final int PM = -3;
    public static final int MAIN = -4;
    public Card(int type, int value){
        this.cardType = type;
        if((this.cardType == MAIN && (value < 1 || value > 10)) || ((this.cardType == PLUS || this.cardType == MINUS || this.cardType == PM) && (value < 1 || value > 6)))
            this.cardValue = 1;
        else
            this.cardValue = value;

    }
    public int getType()
    {
        return this.cardType;
    }
    public int getValue()
    {
        return this.cardValue;
    }
    public int getImage()
    {
        switch (this.cardType){
            case PLUS: switch(this.cardValue){
                case 1: return R.drawable.plus1;
                case 2: return R.drawable.plus2;
                case 3: return R.drawable.plus3;
                case 4: return R.drawable.plus4;
                case 5: return R.drawable.plus1;
            }


            default: return 0;
        }
    }
}
