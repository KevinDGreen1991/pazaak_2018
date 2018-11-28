package com.pazaak.prototype.pazaakprototype;
import java.util.List;
public class gameAI
{

    public boolean shouldStand(int aiDifficulty, int aiScore, List<Card> mainDeck)
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
}
