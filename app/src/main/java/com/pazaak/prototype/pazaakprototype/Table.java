package com.pazaak.prototype.pazaakprototype;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Table extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        final int[] p1CardsPlayed = {0};
        final int[] p2CardsPlayed = {0};

        Card defaultDeck [] = new Card[4];
        defaultDeck[0] = new Card (Card.MINUS, 3);
        defaultDeck[1] = new Card(Card.PM, 5);
        defaultDeck[2] = new Card(Card.MINUS, 6);
        defaultDeck[3] = new Card(Card.PLUS, 1);


        Random generator = new Random();
        final Card[] board1 = new Card[9];
        final Card[] board2 = new Card[9];
        Card[] MainDeck = new Card[40];

        final int[] p1Value = {0};
        final int[]  p2Value = {0};
        final boolean[] yourTurn = {true};
        final boolean[] stand = {false};
        final boolean[] p2Stand = {false};

        for (int i = 0; i < MainDeck.length; i++)
        {
            MainDeck[i] = new Card(4, (i + 1) % 11);
        }

        for (int i = 0; i < board1.length; i++)
        {
            board1[i] = MainDeck[generator.nextInt(40)];
        }

        for (int i = 0; i < board2.length; i++)
        {
            board2[i] = MainDeck[generator.nextInt(40)];
        }

        final ImageView board1slot0 = (ImageView) findViewById(R.id.p1Slot0);
        final ImageView board1slot1 = (ImageView) findViewById(R.id.p1Slot1);
        final ImageView board1slot2 = (ImageView) findViewById(R.id.p1Slot2);
        final ImageView board1slot3 = (ImageView) findViewById(R.id.p1Slot3);
        final ImageView board1slot4 = (ImageView) findViewById(R.id.p1Slot4);
        final ImageView board1slot5 = (ImageView) findViewById(R.id.p1Slot5);
        final ImageView board1slot6 = (ImageView) findViewById(R.id.p1Slot6);
        final ImageView board1slot7 = (ImageView) findViewById(R.id.p1Slot7);
        final ImageView board1slot8 = (ImageView) findViewById(R.id.p1Slot8);

        final ImageView board2slot0 = (ImageView) findViewById(R.id.p2Slot0);
        final ImageView board2slot1 = (ImageView) findViewById(R.id.p2Slot1);
        final ImageView board2slot2 = (ImageView) findViewById(R.id.p2Slot2);
        final ImageView board2slot3 = (ImageView) findViewById(R.id.p2Slot3);
        final ImageView board2slot4 = (ImageView) findViewById(R.id.p2Slot4);
        final ImageView board2slot5 = (ImageView) findViewById(R.id.p2Slot5);
        final ImageView board2slot6 = (ImageView) findViewById(R.id.p2Slot6);
        final ImageView board2slot7 = (ImageView) findViewById(R.id.p2Slot7);
        final ImageView board2slot8 = (ImageView) findViewById(R.id.p2Slot8);

        final Button endTurn = (Button) (findViewById(R.id.bEndTurn));

        final int finalP2CardsPlayed = p2CardsPlayed[0];
        final int finalP2Value = p2Value[0];
        final boolean finalP2Stand = p2Stand[0];
        final boolean finalP2Stand1 = p2Stand[0];
        endTurn.setOnClickListener(new View.OnClickListener()
        {
            int myCards = p1CardsPlayed[0];
            int meh[] = {0, 0};

            @Override
            public void onClick(View view)
            {
                if (stand[0] == true && p2Stand[0] == false)
                {
                    meh = p2Turn(p2Value[0], board2[p2CardsPlayed[0]], p2Stand[0]);
                    p2Value[0] = meh[0];
                }
                if (yourTurn[0] == true && stand[0] == false)
                {
                    switch (myCards)
                    {
                        case 0:
                            board1slot0.setImageResource(board1[0].getImage());
                            p1Value[0] += board1[0].getValue();
                            myCards++;
                            break;
                        case 1:
                            board1slot1.setImageResource(board1[1].getImage());
                            p1Value[0] += board1[1].getValue();
                            myCards++;
                            break;
                        case 2:
                            board1slot2.setImageResource(board1[2].getImage());
                            p1Value[0] += board1[2].getValue();
                            myCards++;
                            break;
                        case 3:
                            board1slot3.setImageResource(board1[3].getImage());
                            p1Value[0] += board1[3].getValue();
                            myCards++;
                            break;
                        case 4:
                            board1slot4.setImageResource(board1[4].getImage());
                            p1Value[0] += board1[4].getValue();
                            myCards++;
                            break;
                        case 5:
                            board1slot5.setImageResource(board1[5].getImage());
                            p1Value[0] += board1[5].getValue();
                            myCards++;
                            break;
                        case 6:
                            board1slot6.setImageResource(board1[6].getImage());
                            p1Value[0] += board1[6].getValue();
                            myCards++;
                            break;
                        case 7:
                            board1slot7.setImageResource(board1[7].getImage());
                            p1Value[0] += board1[7].getValue();
                            myCards++;
                            break;
                        case 8:
                            board1slot8.setImageResource(board1[8].getImage());
                            p1Value[0] += board1[8].getValue();
                            myCards++;
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
                                board2slot0.setImageResource(board2[0].getImage());
                                break;
                            case 1:
                                board2slot1.setImageResource(board2[1].getImage());
                                break;
                            case 2:
                                board2slot2.setImageResource(board2[2].getImage());
                                break;
                            case 3:
                                board2slot3.setImageResource(board2[3].getImage());
                                break;
                            case 4:
                                board2slot4.setImageResource(board2[4].getImage());
                                break;
                            case 5:
                                board2slot5.setImageResource(board2[5].getImage());
                                break;
                            case 6:
                                board2slot6.setImageResource(board2[6].getImage());
                                break;
                            case 7:
                                board2slot7.setImageResource(board2[7].getImage());
                                break;
                            case 8:
                                board2slot8.setImageResource(board2[8].getImage());
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
                stand[0] = true;
                checkifEnd(stand[0], p2Stand[0], p1Value[0], p2Value[0]);
            }

        });

//            if (yourTurn[0] == false)
//            {
//                try
//                {
//                    wait(1500);
//                } catch (InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
//
//                if (p2Value >= 16)
//                {
//                    p2Stand = true;
//                }
//
//                if (p2Stand == false)
//                {
//                    switch (p2CardsPlayed)
//                    {
//                        case 0:
//                            board2slot0.setImageResource(board2[0].getImage());
//                            p2Value += board2[0].getValue();
//                            p2CardsPlayed++;
//                            break;
//                        case 1:
//                            board2slot1.setImageResource(board2[1].getImage());
//                            p2Value += board2[1].getValue();
//                            p2CardsPlayed++;
//                            break;
//                        case 2:
//                            board2slot2.setImageResource(board2[2].getImage());
//                            p2Value += board2[2].getValue();
//                            p2CardsPlayed++;
//                            break;
//                        case 3:
//                            board2slot3.setImageResource(board2[3].getImage());
//                            p2Value += board2[3].getValue();
//                            p2CardsPlayed++;
//                            break;
//                        case 4:
//                            board2slot4.setImageResource(board2[4].getImage());
//                            p2Value += board2[4].getValue();
//                            p2CardsPlayed++;
//                            break;
//                        case 5:
//                            board2slot5.setImageResource(board2[5].getImage());
//                            p2Value += board2[5].getValue();
//                            p2CardsPlayed++;
//                            break;
//                        case 6:
//                            board2slot6.setImageResource(board2[6].getImage());
//                            p2Value += board2[6].getValue();
//                            p2CardsPlayed++;
//                            break;
//                        case 7:
//                            board2slot7.setImageResource(board2[7].getImage());
//                            p2Value += board2[7].getValue();
//                            p2CardsPlayed++;
//                            break;
//                        case 8:
//                            board2slot8.setImageResource(board2[8].getImage());
//                            p2Value += board2[8].getValue();
//                            p2CardsPlayed++;
//                            break;
//
//                    }
//
//                }
//
//                yourTurn[0] = true;
//
//            }

//            if (p1Value[0] > 20)
//            {
//                Context context = getApplicationContext();
//                CharSequence text = "YouLose";
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
//                while (true)
//                    ;
//            }
//            if (p2Value > 20)
//            {
//                Context context = getApplicationContext();
//                CharSequence text = "YouWin";
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
//                while (true)
//                    ;
//            }
//            if (stand[0] == true && p2Stand == true)
//            {
//                if (p1Value[0] > p2Value)
//                {
//                    Context context = getApplicationContext();
//                    CharSequence text = "YouWin";
//                    int duration = Toast.LENGTH_SHORT;
//
//                    Toast toast = Toast.makeText(context, text, duration);
//                    toast.show();
//                } else if (p2Value > p1Value[0])
//                {
//                    Context context = getApplicationContext();
//                    CharSequence text = "YouLose";
//                    int duration = Toast.LENGTH_SHORT;
//
//                    Toast toast = Toast.makeText(context, text, duration);
//                    toast.show();
//                } else
//                {
//                    Context context = getApplicationContext();
//                    CharSequence text = "Tie";
//                    int duration = Toast.LENGTH_SHORT;
//
//                    Toast toast = Toast.makeText(context, text, duration);
//                    toast.show();
//                }
//            }


        /*
         * Decided to help out here a bit :) wanted to get familiar with the java file
         * Created/Displayed a temporary hand for player 1
         * Feel free to modify/expand/delete
         */

        /* generates random values for card retrieval in board1 slots from 0 - (board1.length - 1)*/
        int randomCardValue = generator.nextInt(board1.length);

        final ImageView board1hand1 = (ImageView) findViewById(R.id.p1Hand1);
        final ImageView board1hand2 = (ImageView) findViewById(R.id.p1Hand2);
        final ImageView board1hand3 = (ImageView) findViewById(R.id.p1Hand3);
        final ImageView board1hand4 = (ImageView) findViewById(R.id.p1Hand4);

        /* Sets images of random card obtained into empty hand slots */

        board1hand1.setImageResource(defaultDeck[0].getImage());
        //randomCardValue = generator.nextInt(board1.length);
        board1hand2.setImageResource(defaultDeck[1].getImage());
        //randomCardValue = generator.nextInt(board1.length);
        board1hand3.setImageResource(defaultDeck[2].getImage());
        //randomCardValue = generator.nextInt(board1.length);
        board1hand4.setImageResource(defaultDeck[3].getImage());



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
}
