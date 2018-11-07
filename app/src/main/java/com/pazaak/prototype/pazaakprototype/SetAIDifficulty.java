package com.pazaak.prototype.pazaakprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetAIDifficulty extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final Bundle extras = getIntent().getExtras();
        setContentView(R.layout.activity_set_aidifficulty);

        final Button toGame = (Button) findViewById(R.id.bMedium);

        toGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent goingTo = new Intent(SetAIDifficulty.this, Table.class);
                goingTo.putExtra("cards", extras.getBooleanArray("cards"));
                SetAIDifficulty.this.startActivity(goingTo);
            }
        });

        final Button toGameH = (Button) findViewById(R.id.bHard);

        toGameH.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent goingTo = new Intent(SetAIDifficulty.this, Table.class);
                goingTo.putExtra("cards", extras.getBooleanArray("cards"));
                SetAIDifficulty.this.startActivity(goingTo);
            }
        });

        final Button toGameE = (Button) findViewById(R.id.bEasy);

        toGameE.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent goingTo = new Intent(SetAIDifficulty.this, Table.class);
                goingTo.putExtra("cards", extras.getBooleanArray("cards"));
                SetAIDifficulty.this.startActivity(goingTo);
            }
        });
    }
}
