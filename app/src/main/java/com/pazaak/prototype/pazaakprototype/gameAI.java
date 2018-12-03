package com.pazaak.prototype.pazaakprototype;
import java.util.List;
public class gameAI
{
    private int difficulty;
    public static final int EASY = 0;
    public static final int MEDIUM = 1;
    public static final int HARD = 2;
    private List<Card> aiDeck;
    public gameAI(int aiDifficulty)
    {
        this.difficulty = aiDifficulty;
        setAiDeck();
    }
    public boolean shouldStand(int aiScore, List<Card> mainDeck)
    {
        ///mainDeck.remove(0);
        float average = getDeckAverage(mainDeck);
        //if(average + aiScore <= 20)
            //return true;

        return average + aiScore > 20;
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

    }


}
