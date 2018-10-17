package com.pazaak.prototype.pazaakprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Table extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        Card[] board1 = new Card[9];
        Card[] board2 = new Card[9];
        Card[] MainDeck = new Card[40];

        for (int i = 0; i < MainDeck.length; i++)
        {
            MainDeck[i] = new Card(4, (i + 1) % 11);
        }

        Card myCard = new Card(4, 3);

        int val = myCard.getValue();

        ImageView img = (ImageView) findViewById(R.id.p1Slot0);
        img.setImageResource(R.drawable.minus3);

    }
}
