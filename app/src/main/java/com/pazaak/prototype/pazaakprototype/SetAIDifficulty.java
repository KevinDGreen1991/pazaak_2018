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
        setContentView(R.layout.activity_set_aidifficulty);

        final Button toGame = (Button) findViewById(R.id.bMedium);

        toGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent goingTo = new Intent(SetAIDifficulty.this, Table.class);
                SetAIDifficulty.this.startActivity(goingTo);
            }
        });
    }
}
