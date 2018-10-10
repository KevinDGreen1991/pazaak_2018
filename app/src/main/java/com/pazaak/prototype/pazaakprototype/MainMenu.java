package com.pazaak.prototype.pazaakprototype;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final Button toGameMenu = findViewById(R.id.bStartGame);
        final Button toDeckBuilder = findViewById(R.id.bDeckBuilder);
        final Button toTutorial = findViewById(R.id.bStartTutorial);

        toGameMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGameMenu = new Intent(MainMenu.this, GameMenu.class);
                MainMenu.this.startActivity(iGameMenu);
            }
        });
        toTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iTutorial = new Intent(MainMenu.this, TutorialMenu.class);
                MainMenu.this.startActivity(iTutorial);
            }
        });
        toDeckBuilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDeckBuilder = new Intent(MainMenu.this, DeckBuilder.class);
                MainMenu.this.startActivity(iDeckBuilder);
            }
        });

    }
}
