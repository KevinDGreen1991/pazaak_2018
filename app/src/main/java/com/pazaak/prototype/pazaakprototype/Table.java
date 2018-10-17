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

        Card defaultDeck [] = new Card[4];
        defaultDeck[0] = new Card (Card.MINUS, 3);
        defaultDeck[1] = new Card(Card.PM, 5);
        defaultDeck[2] = new Card(Card.MINUS, 6);
        defaultDeck[3] = new Card(Card.PLUS, 1);


        Random generator = new Random();
        Card[] board1 = new Card[9];
        Card[] board2 = new Card[9];
        Card[] MainDeck = new Card[40];

        for (int i = 0; i < MainDeck.length; i++)
        {
            MainDeck[i] = new Card(4, (i + 1) % 11);
        }

        Card myCard = new Card(4, 3);

        int val = myCard.getValue();

        for (int i = 0; i < board1.length; i++)
        {
            board1[i] = MainDeck[generator.nextInt(40)];
        }


        ImageView board1slot0 = (ImageView) findViewById(R.id.p1Slot0);
        ImageView board1slot1 = (ImageView) findViewById(R.id.p1Slot1);
        ImageView board1slot2 = (ImageView) findViewById(R.id.p1Slot2);
        ImageView board1slot3 = (ImageView) findViewById(R.id.p1Slot3);
        ImageView board1slot4 = (ImageView) findViewById(R.id.p1Slot4);
        ImageView board1slot5 = (ImageView) findViewById(R.id.p1Slot5);
        ImageView board1slot6 = (ImageView) findViewById(R.id.p1Slot6);
        ImageView board1slot7 = (ImageView) findViewById(R.id.p1Slot7);
        ImageView board1slot8 = (ImageView) findViewById(R.id.p1Slot8);

        board1slot0.setImageResource(board1[0].getImage());
        board1slot1.setImageResource(board1[1].getImage());
        board1slot2.setImageResource(board1[2].getImage());
        board1slot3.setImageResource(board1[3].getImage());
        board1slot4.setImageResource(board1[4].getImage());
        board1slot5.setImageResource(defaultDeck[0].getImage());
        board1slot6.setImageResource(defaultDeck[1].getImage());
        board1slot7.setImageResource(defaultDeck[2].getImage());
        board1slot8.setImageResource(defaultDeck[3].getImage());
    }
}
