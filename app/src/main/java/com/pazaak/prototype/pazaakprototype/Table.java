package com.pazaak.prototype.pazaakprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
        final int p1CardsPlayed = 0;

        Card defaultDeck [] = new Card[4];
        defaultDeck[0] = new Card (Card.MINUS, 3);
        defaultDeck[1] = new Card(Card.PM, 5);
        defaultDeck[2] = new Card(Card.MINUS, 6);
        defaultDeck[3] = new Card(Card.PLUS, 1);


        Random generator = new Random();
        final Card[] board1 = new Card[9];
        Card[] board2 = new Card[9];
        Card[] MainDeck = new Card[40];

        for (int i = 0; i < MainDeck.length; i++)
        {
            MainDeck[i] = new Card(4, (i + 1) % 11);
        }

        final Card myCard = new Card(4, 3);

        int val = myCard.getValue();

        for (int i = 0; i < board1.length; i++)
        {
            board1[i] = MainDeck[generator.nextInt(40)];
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

        final Button endTurn = (Button) (findViewById(R.id.bEndTurn));

        endTurn.setOnClickListener(new View.OnClickListener()
        {
            int myCards = p1CardsPlayed;
            @Override
            public void onClick(View view)
            {
                switch (myCards)
                {
                    case 0:
                        board1slot0.setImageResource(board1[0].getImage());
                        myCards++;
                        break;
                    case 1:
                        board1slot1.setImageResource(board1[1].getImage());
                        myCards++;
                        break;
                    case 2:
                        board1slot2.setImageResource(board1[2].getImage());
                        myCards++;
                        break;
                    case 3:
                        board1slot3.setImageResource(board1[3].getImage());
                        myCards++;
                        break;
                    case 4:
                        board1slot4.setImageResource(board1[4].getImage());
                        myCards++;
                        break;
                    case 5:
                        board1slot5.setImageResource(board1[5].getImage());
                        myCards++;
                        break;
                    case 6:
                        board1slot6.setImageResource(board1[6].getImage());
                        myCards++;
                        break;
                    case 7:
                        board1slot7.setImageResource(board1[7].getImage());
                        myCards++;
                        break;
                    case 8:
                        board1slot8.setImageResource(board1[8].getImage());
                        myCards++;
                        break;
                }
            }
        });



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

        board1hand1.setImageResource(board1[randomCardValue].getImage());
        randomCardValue = generator.nextInt(board1.length);
        board1hand2.setImageResource(board1[randomCardValue].getImage());
        randomCardValue = generator.nextInt(board1.length);
        board1hand3.setImageResource(board1[randomCardValue].getImage());
        randomCardValue = generator.nextInt(board1.length);
        board1hand4.setImageResource(board1[randomCardValue].getImage());



    }
}
