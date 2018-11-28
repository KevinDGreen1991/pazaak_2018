package com.pazaak.prototype.pazaakprototype;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Table extends AppCompatActivity
{
    final int END_TURN = 0;
    final int STAND = 1;
    final int PLAY_CARD = 2;
    Card[] MainDeck = new Card[40];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_table);
        final int[] p1CardsPlayed = {0};
        final int[] p2CardsPlayed = {0};

        final Card player1Hand[] = assignCards();


        Random generator = new Random();
        final Card[] board1 = new Card[9];
        final Card[] board2 = new Card[9];


        final int[] p1Value = {0};
        p1Value[0] = 0;
        final int[] p2Value = {0};
        p2Value[0] = 0;
        final boolean[] yourTurn = {true};
        final boolean[] p1Stand = {false};
        final boolean[] p2Stand = {false};

        final boolean[] p1PlayedACardThisTurn = {false};

        for (int i = 0; i < MainDeck.length; i++)
        {
            MainDeck[i] = new Card(Card.MAIN, (i + 1) % 11);
        }

        for (int i = 0; i < board1.length; i++)
        {
            board1[i] = MainDeck[generator.nextInt(40)];
        }

        for (int i = 0; i < board2.length; i++)
        {
            board2[i] = MainDeck[generator.nextInt(40)];
        }

        final ImageView board1Slots[] = {findViewById(R.id.p1Slot0), (findViewById(R.id.p1Slot1)), findViewById(R.id.p1Slot2), findViewById(R.id.p1Slot3), findViewById(R.id.p1Slot4),
                findViewById(R.id.p1Slot5), findViewById(R.id.p1Slot6), findViewById(R.id.p1Slot7), findViewById(R.id.p1Slot8)};


        final ImageView board2Slots[] = {findViewById(R.id.p2Slot0), findViewById(R.id.p2Slot1), findViewById(R.id.p2Slot2), findViewById(R.id.p2Slot3), findViewById(R.id.p2Slot4),
                findViewById(R.id.p2Slot5), findViewById(R.id.p2Slot6), findViewById(R.id.p2Slot7), findViewById(R.id.p2Slot8)};


        final int finalP2CardsPlayed = p2CardsPlayed[0];
        final int finalP2Value = p2Value[0];
        final boolean finalP2Stand = p2Stand[0];
        final boolean finalP2Stand1 = p2Stand[0];

        //Initial Start for player 1's board
        Card firstCard = (MainDeck[generator.nextInt(40)]);
        board1[0] = firstCard;
        board1Slots[0].setImageResource(firstCard.getImage());
        p1Value[0] = firstCard.getValue();
        p1CardsPlayed[0]++;

        final Button endTurn = (Button) (findViewById(R.id.bEndTurn));

        endTurn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                if (p2Value[0] < 16)
                {
                    p2Value[0] = p2EndTurn(p2Value[0], p2CardsPlayed[0], board2Slots);
                    p2CardsPlayed[0]++;
                    yourTurn[0] = true;
                }
                else
                {
                    p2Stand[0] = true;
                    yourTurn[0] = true;
                }

                if (yourTurn[0] == true && p1Stand[0] == false)
                {
                    p1Value[0] = p1Turn(p1Value[0], p1CardsPlayed[0], board1Slots);
                    p1CardsPlayed[0]++;
                    yourTurn[0] = false;


                }
                p1PlayedACardThisTurn[0] = false;
            }
        });

        final Button bStand1 = (Button) (findViewById(R.id.bStand));

        bStand1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                p1Stand[0] = true;
                while (p1Stand[0] == true && p2Stand[0] == false)
                {
                    if (p2Value[0] < 16)
                    {
                        p2Value[0] = p2EndTurn(p2Value[0], p2CardsPlayed[0], board2Slots);
                        p2CardsPlayed[0]++;
                    }
                    else
                    {
                        p2Stand[0] = true;
                    }
                }
                checkifEnd(p1Stand[0], p2Stand[0], p1Value[0], p2Value[0]);
            }


        });



        /*
         * Decided to help out here a bit :) wanted to get familiar with the java file
         * Created/Displayed a temporary hand for player 1
         * Feel free to modify/expand/delete
         */

        /* generates random values for card retrieval in board1 slots from 0 - (board1.length - 1)*/
        //int randomCardValue = generator.nextInt(board1.length);

        final ImageButton board1hand1 = findViewById(R.id.p1Hand1);
        final ImageButton board1hand2 = findViewById(R.id.p1Hand2);
        final ImageButton board1hand3 = findViewById(R.id.p1Hand3);
        final ImageButton board1hand4 = findViewById(R.id.p1Hand4);

        /* Sets images of random card obtained into empty hand slots */

        board1hand1.setImageResource(player1Hand[0].getImage());
        //randomCardValue = generator.nextInt(board1.length);
        board1hand2.setImageResource(player1Hand[1].getImage());
        //randomCardValue = generator.nextInt(board1.length);
        board1hand3.setImageResource(player1Hand[2].getImage());
        //randomCardValue = generator.nextInt(board1.length);
        board1hand4.setImageResource(player1Hand[3].getImage());





        //Added as of Nov. 4th

        //TODO fix hand card 1
        board1hand1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (p1PlayedACardThisTurn[0] == false)
                {


                    p1Value[0] = p1PlayCard(p1Value[0], p1CardsPlayed[0], player1Hand[0], board1Slots);
                    board1hand1.setImageResource(R.drawable.empty_dark);
                    p1CardsPlayed[0]++;

//                    if (p2Value[0] < 16)
//                    {
//                        p2Value[0] = p2EndTurn(p2Value[0], p2CardsPlayed[0], board2Slots);
//                        p2CardsPlayed[0]++;
//                    }
//                    else
//                    {
//                        p2Stand[0] = true;
//                    }
//                    yourTurn[0] = true;

                    p1PlayedACardThisTurn[0] = true;
                    board1hand1.setEnabled(false);
                }


            }
        });

        //TODO fix hand card 2
        board1hand2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (p1PlayedACardThisTurn[0] == false)
                {
                    p1Value[0] = p1PlayCard(p1Value[0], p1CardsPlayed[0], player1Hand[1], board1Slots);
                    board1hand2.setImageResource(R.drawable.empty_dark);
                    p1CardsPlayed[0]++;

//                    if (p2Value[0] < 16)
//                    {
//                        p2Value[0] = p2EndTurn(p2Value[0], p2CardsPlayed[0], board2Slots);
//                        p2CardsPlayed[0]++;
//                    }
//                    else
//                    {
//                        p2Stand[0] = true;
//                    }
//                    yourTurn[0] = true;

                    p1PlayedACardThisTurn[0] = true;
                    board1hand2.setEnabled(false);
                }

            }
        });

        //TODO fix hand card 3
        board1hand3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                if (p1PlayedACardThisTurn[0] == false)
                {
                    p1Value[0] = p1PlayCard(p1Value[0], p1CardsPlayed[0], player1Hand[2], board1Slots);
                    board1hand3.setImageResource(R.drawable.empty_dark);
                    p1CardsPlayed[0]++;

//                    if (p2Value[0] < 16)
//                    {
//                        p2Value[0] = p2EndTurn(p2Value[0], p2CardsPlayed[0], board2Slots);
//                        p2CardsPlayed[0]++;
//                    }
//                    else
//                    {
//                        p2Stand[0] = true;
//                    }
//                    yourTurn[0] = true;

                    p1PlayedACardThisTurn[0] = true;

                    board1hand3.setEnabled(false);
                }

            }
        });

        //TODO fix hand card 4
        board1hand4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (p1PlayedACardThisTurn[0] == false)
                {
                    p1Value[0] = p1PlayCard(p1Value[0], p1CardsPlayed[0], player1Hand[3], board1Slots);
                    board1hand4.setImageResource(R.drawable.empty_dark);
                    p1CardsPlayed[0]++;

//                    if (p2Value[0] < 16)
//                    {
//                        p2Value[0] = p2EndTurn(p2Value[0], p2CardsPlayed[0], board2Slots);
//                        p2CardsPlayed[0]++;
//                    }
//                    else
//                    {
//                        p2Stand[0] = true;
//                    }
//                    yourTurn[0] = true;

                    p1PlayedACardThisTurn[0] = true;

                    board1hand4.setEnabled(false);
                }

            }
        });

    }

    protected int p1PlayCard(int currentValue, int cardsPlayed, Card cardToPlay, ImageView board[])
    {
        board[cardsPlayed].setImageResource(cardToPlay.getImage());
        int val = 0;

        if (cardToPlay.getType() == Card.PM)
        {
            //Bundle newBundy = new Bundle();
            //PlusMinusPrompt myPrompt = new PlusMinusPrompt();
            //myPrompt.shower();
            //val = myPrompt.returnType();
            //System.out.println(val);
            if (val == Card.PLUS)
            {
                val = cardToPlay.getValue();
            }
            else
            {
                val = cardToPlay.getValue() * -1;
            }
        }
        else
        {
            val = cardToPlay.getValue();
        }

        return currentValue + val;
    }

    //Returns the new value of the board
    protected int p1Turn(int currentValue, int cardsPlayed, ImageView board[])
    {
        int returnedValue = 0;
        returnedValue = p1EndTurn(currentValue, cardsPlayed, board);

        return returnedValue;
    }

    protected int p1EndTurn(int currentValue, int cardsPlayed, ImageView board[])
    {
        Random getMainDeckCard = new Random();
        Card cardToDraw = MainDeck[(getMainDeckCard.nextInt(40) + 1) % 11];
        board[cardsPlayed].setImageResource(cardToDraw.getImage());
        return currentValue + cardToDraw.getValue();


    }

    protected int p2EndTurn(int curVal, int cardsPlayed, ImageView board[])
    {
        
        Random getMainDeckCard = new Random();
        Card cardToDraw = MainDeck[(getMainDeckCard.nextInt(40) + 1) % 11];
        board[cardsPlayed].setImageResource(cardToDraw.getImage());
        return cardToDraw.getValue() + curVal;
    }

    public void checkifEnd(boolean stand1, boolean stand2, int val1, int val2)
    {
        if (stand1 && stand2)
        {
            if ((val1 <= 20 && val1 > val2) || (val1 <= 20 && val2 > 20))
            {
                Context context = getApplicationContext();
                CharSequence text = "YouWin";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            else if ((val2 > val1 && val2 <= 20) || (val1 > 20 & val2 <= 20))
            {
                Context context = getApplicationContext();
                CharSequence text = "YouLose";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            else
            {
                Context context = getApplicationContext();
                CharSequence text = "Tie";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }
    }

    public Card[] assignCards()
    {
        Bundle extra = getIntent().getExtras();
        List<Card> playerDeck = new ArrayList<Card>();
        if (extra.containsKey("cards") && (extra.getBooleanArray("cards")) != null)
        {
            playerDeck.addAll(Arrays.asList(Card.getSideDeck(extra.getBooleanArray("cards"))));
        }

        Random getRandomHandGen = new Random();
        Card handToReturn[] = new Card[4];
        int cardsInHand = 0;
        while (cardsInHand < 4)
        {
            handToReturn[cardsInHand] = playerDeck.remove(getRandomHandGen.nextInt(playerDeck.size()));
            cardsInHand++;
        }

        return handToReturn;
    }
}
