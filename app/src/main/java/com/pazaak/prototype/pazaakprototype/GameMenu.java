package com.pazaak.prototype.pazaakprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameMenu extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        final Button toSetDiff = (Button) findViewById(R.id.bEasy);

        toSetDiff.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent iSetDiff = new Intent(GameMenu.this, SetAIDifficulty.class);
                GameMenu.this.startActivity(iSetDiff);
            }
        });

        final Button toGame = (Button) findViewById(R.id.bMedium);

        toGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent goingTo = new Intent(GameMenu.this, Game.class);
                GameMenu.this.startActivity(goingTo);
            }
        });
    }
}
