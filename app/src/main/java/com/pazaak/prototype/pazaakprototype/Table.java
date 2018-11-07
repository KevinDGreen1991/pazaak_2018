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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_table);
        final int[] p1CardsPlayed = {0};
        final int[] p2CardsPlayed = {0};

        final Card player1Hand [] = assignCards();


        Random generator = new Random();
        final Card[] board1 = new Card[9];
        final Card[] board2 = new Card[9];
        Card[] MainDeck = new Card[40];

        final int[] p1Value = {0};
        final int[]  p2Value = {0};
        final boolean[] yourTurn = {true};
        final boolean[] p1Stand = {false};
        final boolean[] p2Stand = {false};

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

        final Button endTurn = (Button) (findViewById(R.id.bEndTurn));

        endTurn.setOnClickListener(new View.OnClickListener()
        {
            //int myCards = p1CardsPlayed[0];
            int meh[] = {0, 0};

            @Override
            public void onClick(View view)
            {
                if (p1Stand[0] == true && p2Stand[0] == false)
                {
                    meh = p2Turn(p2Value[0], board2[p2CardsPlayed[0]], p2Stand[0]);
                    p2Value[0] = meh[0];
                }
                if (yourTurn[0] == true && p1Stand[0] == false)
                {
                    switch (p1CardsPlayed[0])
                    {
                        case 0:
                            board1Slots[0].setImageResource(board1[0].getImage());
                            p1Value[0] += board1[0].getValue();
                            p1CardsPlayed[0]++;
                            break;
                        case 1:
                            board1Slots[1].setImageResource(board1[1].getImage());
                            p1Value[0] += board1[1].getValue();
                            p1CardsPlayed[0]++;
                            break;
                        case 2:
                            board1Slots[2].setImageResource(board1[2].getImage());
                            p1Value[0] += board1[2].getValue();
                            p1CardsPlayed[0]++;
                            break;
                        case 3:
                            board1Slots[3].setImageResource(board1[3].getImage());
                            p1Value[0] += board1[3].getValue();
                            p1CardsPlayed[0]++;
                            break;
                        case 4:
                            board1Slots[4].setImageResource(board1[4].getImage());
                            p1Value[0] += board1[4].getValue();
                            p1CardsPlayed[0]++;
                            break;
                        case 5:
                            board1Slots[5].setImageResource(board1[5].getImage());
                            p1Value[0] += board1[5].getValue();
                            p1CardsPlayed[0]++;
                            break;
                        case 6:
                            board1Slots[6].setImageResource(board1[6].getImage());
                            p1Value[0] += board1[6].getValue();
                            p1CardsPlayed[0]++;
                            break;
                        case 7:
                            board1Slots[7].setImageResource(board1[7].getImage());
                            p1Value[0] += board1[7].getValue();
                            p1CardsPlayed[0]++;
                            break;
                        case 8:
                            board1Slots[8].setImageResource(board1[8].getImage());
                            p1Value[0] += board1[8].getValue();
                            p1CardsPlayed[0]++;
                            break;
                    }
                    yourTurn[0] = false;
                    meh = p2Turn(p2Value[0], board2[p2CardsPlayed[0]], p2Stand[0]);
                    p2Value[0] = meh[0];
                    if (p2Stand[0] == false)
                    {
                        switch (p2CardsPlayed[0])
                        {
                            case 0:
                                board2Slots[0].setImageResource(board2[0].getImage());
                                break;
                            case 1:
                                board2Slots[1].setImageResource(board2[1].getImage());
                                break;
                            case 2:
                                board2Slots[2].setImageResource(board2[2].getImage());
                                break;
                            case 3:
                                board2Slots[3].setImageResource(board2[3].getImage());
                                break;
                            case 4:
                                board2Slots[4].setImageResource(board2[4].getImage());
                                break;
                            case 5:
                                board2Slots[5].setImageResource(board2[5].getImage());
                                break;
                            case 6:
                                board2Slots[6].setImageResource(board2[6].getImage());
                                break;
                            case 7:
                                board2Slots[7].setImageResource(board2[7].getImage());
                                break;
                            case 8:
                                board2Slots[8].setImageResource(board2[8].getImage());
                                break;
                        }
                        p2CardsPlayed[0]++;
                    }
                    yourTurn[0] = true;


                }
            }
        });

        final Button bStand1 = (Button) (findViewById(R.id.bStand));

        bStand1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                p1Stand[0] = true;
                checkifEnd(p1Stand[0], p2Stand[0], p1Value[0], p2Value[0]);
            }

        });



        /*
         * Decided to help out here a bit :) wanted to get familiar with the java file
         * Created/Displayed a temporary hand for player 1
         * Feel free to modify/expand/delete
         */

        /* generates random values for card retrieval in board1 slots from 0 - (board1.length - 1)*/
        int randomCardValue = generator.nextInt(board1.length);

        final ImageButton board1hand1 = (ImageButton) findViewById(R.id.p1Hand1);
        final ImageView board1hand2 = (ImageView) findViewById(R.id.p1Hand2);
        final ImageView board1hand3 = (ImageView) findViewById(R.id.p1Hand3);
        final ImageView board1hand4 = (ImageView) findViewById(R.id.p1Hand4);

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

                switch (p1CardsPlayed[0])
                {
                    case 0:
                        board1Slots[0].setImageResource(player1Hand[0].getImage());
                        break;
                    case 1:
                        board1Slots[1].setImageResource(player1Hand[0].getImage());
                        break;
                    case 2:
                        board1Slots[2].setImageResource(player1Hand[0].getImage());
                        break;
                    case 3:
                        board1Slots[3].setImageResource(player1Hand[0].getImage());
                        break;
                    case 4:
                        board1Slots[4].setImageResource(player1Hand[0].getImage());
                        break;
                    case 5:
                        board1Slots[5].setImageResource(player1Hand[0].getImage());
                        break;
                    case 6:
                        board1Slots[6].setImageResource(player1Hand[0].getImage());
                        break;
                    case 7:
                        board1Slots[7].setImageResource(player1Hand[0].getImage());
                        break;
                    case 8:
                        board1Slots[8].setImageResource(player1Hand[0].getImage());
                        break;

                }
                p1CardsPlayed[0]++;
                p1Value[0] = p1Value[0] + player1Hand[0].getValue();

            }
        });

        //TODO fix hand card 2
        board1hand2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                switch (p1CardsPlayed[0])
                {
                    case 0:
                        board1Slots[0].setImageResource(player1Hand[1].getImage());
                        break;
                    case 1:
                        board1Slots[1].setImageResource(player1Hand[1].getImage());
                        break;
                    case 2:
                        board1Slots[2].setImageResource(player1Hand[1].getImage());
                        break;
                    case 3:
                        board1Slots[3].setImageResource(player1Hand[1].getImage());
                        break;
                    case 4:
                        board1Slots[4].setImageResource(player1Hand[1].getImage());
                        break;
                    case 5:
                        board1Slots[5].setImageResource(player1Hand[1].getImage());
                        break;
                    case 6:
                        board1Slots[6].setImageResource(player1Hand[1].getImage());
                        break;
                    case 7:
                        board1Slots[7].setImageResource(player1Hand[1].getImage());
                        break;
                    case 8:
                        board1Slots[8].setImageResource(player1Hand[1].getImage());
                        break;

                }
                p1CardsPlayed[0]++;
                p1Value[0] = p1Value[0] + player1Hand[1].getValue();

            }
        });

        //TODO fix hand card 3
        board1hand3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                switch (p1CardsPlayed[0])
                {
                    case 0:
                        board1Slots[0].setImageResource(player1Hand[2].getImage());
                        break;
                    case 1:
                        board1Slots[1].setImageResource(player1Hand[2].getImage());
                        break;
                    case 2:
                        board1Slots[2].setImageResource(player1Hand[2].getImage());
                        break;
                    case 3:
                        board1Slots[3].setImageResource(player1Hand[2].getImage());
                        break;
                    case 4:
                        board1Slots[4].setImageResource(player1Hand[2].getImage());
                        break;
                    case 5:
                        board1Slots[5].setImageResource(player1Hand[2].getImage());
                        break;
                    case 6:
                        board1Slots[6].setImageResource(player1Hand[2].getImage());
                        break;
                    case 7:
                        board1Slots[7].setImageResource(player1Hand[2].getImage());
                        break;
                    case 8:
                        board1Slots[8].setImageResource(player1Hand[2].getImage());
                        break;

                }
                p1CardsPlayed[0]++;
                p1Value[0] = p1Value[0] + player1Hand[2].getValue();

            }
        });

        //TODO fix hand card 4
        board1hand4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                switch (p1CardsPlayed[0])
                {
                    case 0:
                        board1Slots[0].setImageResource(player1Hand[3].getImage());
                        break;
                    case 1:
                        board1Slots[1].setImageResource(player1Hand[3].getImage());
                        break;
                    case 2:
                        board1Slots[2].setImageResource(player1Hand[3].getImage());
                        break;
                    case 3:
                        board1Slots[3].setImageResource(player1Hand[3].getImage());
                        break;
                    case 4:
                        board1Slots[4].setImageResource(player1Hand[3].getImage());
                        break;
                    case 5:
                        board1Slots[5].setImageResource(player1Hand[3].getImage());
                        break;
                    case 6:
                        board1Slots[6].setImageResource(player1Hand[3].getImage());
                        break;
                    case 7:
                        board1Slots[7].setImageResource(player1Hand[3].getImage());
                        break;
                    case 8:
                        board1Slots[8].setImageResource(player1Hand[3].getImage());
                        break;

                }
                p1CardsPlayed[0]++;
                p1Value[0] = p1Value[0] + player1Hand[3].getValue();

            }
        });

    }

    //Returns the new value of the board
    protected int p1Turn(int action, int currentValue, int cardsPlayed)
    {

        return 0;
    }

    public int[] p2Turn(int curVal, Card cardToPlay, boolean stand)
    {
//        try
//        {
//            wait(1500);
//        } catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }

        if (curVal >= 16)
        {
            stand = true;
            int[] returned = {curVal, 1};
            return returned;
        }
        else
        {
            curVal += cardToPlay.getValue();
        }
        int[] returned = {curVal, 0};
        return returned;
    }

    public void checkifEnd(boolean stand1, boolean stand2, int val1, int val2)
    {
        //if (stand1 && stand2)
        //{
            if (val1 > val2)
            {
                Context context = getApplicationContext();
                CharSequence text = "YouWin";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            else if (val2 > val1)
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
        //}
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
