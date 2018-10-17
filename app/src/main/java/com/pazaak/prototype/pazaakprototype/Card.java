package com.pazaak.prototype.pazaakprototype;

public class Card {
    private int cardId;
    private int cardType;
    private int cardValue;
    public static int PLUS = -1;
    public static int MINUS = -2;
    public static int PM = -3;
    public Card(int type, int value){
        this.cardType = type;
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
}
