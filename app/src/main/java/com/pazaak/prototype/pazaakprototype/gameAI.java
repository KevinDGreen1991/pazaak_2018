package com.pazaak.prototype.pazaakprototype;
import java.util.List;
import java.util.Random;
public class gameAI
{
    private int difficulty;
    public static final int EASY = 2;
    public static final int MEDIUM = 1;
    public static final int HARD = 0;
    public static boolean PLUS = false;
    public static boolean MINUS = true;
    private List<Card> aiDeck;
    private boolean plusOrMinus;
    public gameAI(int aiDifficulty)
    {
        this.difficulty = aiDifficulty;
        setAiDeck();
        trimDeck();
        this.plusOrMinus = MINUS;
    }
    public boolean shouldStand(int aiScore, List<Card> mainDeck)
    {
        ///mainDeck.remove(0);
        float average = getDeckAverage(mainDeck);
        //if(average + aiScore <= 20)
            //return true;

        return (average + aiScore - difficulty) > 20;
    }
    private float getDeckAverage(List<Card> deck)
    {
        int totalCards = deck.size();
        float cardAverage = 0;
        while(!deck.isEmpty())
        {
            cardAverage += deck.remove(0).getValue();
        }
        cardAverage /= totalCards;
        return cardAverage;
    }
    private void setAiDeck()
    {
        switch(difficulty)
        {
            case EASY: setEasyDeck();break;
            //case MEDIUM: setMediumDeck();break;
            case HARD: setHardDeck();break;
            default: setMediumDeck();break;
        }
    }
    private void setEasyDeck()
    {
        setMediumDeck();
    }
    private void setMediumDeck()
    {
        this.aiDeck.add(new Card(Card.MINUS, 1));
        this.aiDeck.add(new Card(Card.MINUS, 2));
        this.aiDeck.add(new Card(Card.MINUS, 4));
        this.aiDeck.add(new Card(Card.MINUS, 5));
        this.aiDeck.add(new Card(Card.MINUS, 6));
        this.aiDeck.add(new Card(Card.PM, 1));
        this.aiDeck.add(new Card(Card.PM, 4));
        this.aiDeck.add(new Card(Card.PM, 3));
        this.aiDeck.add(new Card(Card.PM, 6));
        this.aiDeck.add(new Card(Card.PLUS, 4));
    }
    private void setHardDeck()
    {
        setMediumDeck();
    }
    private void trimDeck()
    {
        Random handSelector = new Random(difficulty);
        while(aiDeck.size() >= 5)
        {
            aiDeck.remove(handSelector.nextInt() % aiDeck.size());
        }
    }
    public Card getCard(int aiScore, List<Card> mainDeck)
    {
        if(aiDeck.size() == 0)
            return null;
        Card cardToPlay = null;
        int cardToPlayID = hitTwenty(aiScore);
        if(cardToPlayID >= 0)
        {
            cardToPlay = aiDeck.remove(cardToPlayID);
            return cardToPlay;
        }
        cardToPlayID = getBestCard(aiScore, getDeckAverage(mainDeck));
        if(cardToPlayID >= 0)
        {
            cardToPlay = aiDeck.remove(cardToPlayID);
            return cardToPlay;
        }
        return cardToPlay;
    }
    private int hitTwenty(int score)
    {
        for(int i = 0; i < aiDeck.size(); i++)
        {
            if(aiDeck.get(i).getType() == Card.PM)
            {
                if(aiDeck.get(i).getValue() + score == 20) {
                plusOrMinus = PLUS;
                return i;
                }
                else if(aiDeck.get(i).getValue() - score == 20)
                {
                    plusOrMinus = MINUS;
                    return i;
                }
            }
            else if(aiDeck.get(i).getValue() + score == 20)
            {
                return i;
            }
        }
        return -1;
    }
    private int getBestCard(int score, float deckAverage)
    {
        //int cardID = -1;
        for(int cardID = 0; cardID < aiDeck.size(); cardID++)
        {
            if(aiDeck.get(cardID).getType() == Card.MINUS)
            {
                if((score > 20) && (aiDeck.get(cardID).getValue() + score <= 20))
                    return cardID;
                else if(score + (int)deckAverage + aiDeck.get(cardID).getValue() == 20)
                    return cardID;
            }
            else if(aiDeck.get(cardID).getType() == Card.PM)
            {
                if((score > 20) && (-aiDeck.get(cardID).getValue() + score <= 20))
                {
                    this.plusOrMinus = MINUS;
                    return cardID;
                }
                else if(score + (int)deckAverage + aiDeck.get(cardID).getValue() == 20)
                {
                    this.plusOrMinus = PLUS;
                    return cardID;
                }
                else if(score + (int)deckAverage + -aiDeck.get(cardID).getValue() == 20)
                {
                    this.plusOrMinus = MINUS;
                    return cardID;
                }
            }
            else
            {
                int scorePlusAverage = score + (int)deckAverage;
                int scorePlusCard = score + aiDeck.get(cardID).getValue();
                if(scorePlusAverage < scorePlusCard && scorePlusCard <= 20)
                    return cardID;
                else if(scorePlusCard + (int)deckAverage == 20)
                    return cardID;
            }
        }
        return -1;
    }

    public boolean choosePlusOrMinus(int aiScore, Card plusMinusCard)
    {
        return this.plusOrMinus;
    }

}
