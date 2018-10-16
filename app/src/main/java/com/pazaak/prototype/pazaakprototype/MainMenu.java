package com.pazaak.prototype.pazaakprototype;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity
{
    public boolean cards[] = new boolean[18]; //KEVIN Testing
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        for(int i = 0; i < 18; i++){
            cards[i] = false;} //KEVIN testing
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final Button toGameMenu = findViewById(R.id.bStartGame);
        final Button toDeckBuilder = findViewById(R.id.bDeckBuilder);
        final Button toTutorial = findViewById(R.id.bStartTutorial);

        toGameMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent iGameMenu = new Intent(MainMenu.this, GameMenu.class);
                MainMenu.this.startActivity(iGameMenu);
            }
        });
        toTutorial.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent iTutorial = new Intent(MainMenu.this, TutorialMenu.class);
                MainMenu.this.startActivity(iTutorial);
            }
        });
        toDeckBuilder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent iDeckBuilder = new Intent(MainMenu.this, DeckBuilder.class);
                iDeckBuilder.putExtra("test", cards); //KEVIN testing
                MainMenu.this.startActivity(iDeckBuilder);
            }
        });

    }
}
