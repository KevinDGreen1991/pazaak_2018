package com.pazaak.prototype.pazaakprototype;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DeckBuilderV2 extends AppCompatActivity
{
    private static final int plus1ID = 0;
    private static final int plus2ID = 1;
    private static final int plus3ID = 2;
    private static final int plus4ID = 3;
    private static final int plus5ID = 4;
    private static final int plus6ID = 5;
    private static final int minus1ID = 6;
    private static final int minus2ID = 7;
    private static final int minus3ID = 8;
    private static final int minus4ID = 9;
    private static final int minus5ID = 10;
    private static final int minus6ID = 11;
    private static final int pm1ID = 12;
    private static final int pm2ID = 13;
    private static final int pm3ID = 14;
    private static final int pm4ID = 15;
    private static final int pm5ID = 16;
    private static final int pm6ID = 17;
    static int arraySize= 18;
    public int count = 0;
    public String countText = "deckCount";
    public boolean checked[] = new boolean[arraySize];
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_builder_v2);
        setChecked();
        count = checkCount();
        setDeckCountField();
        checkDone();
        setButtonToggles();
    }
    protected void setChecked()
    {
        Bundle extras = getIntent().getExtras();
        boolean temp[];
        if(extras != null) {
            if (extras.containsKey("cards") && (temp = extras.getBooleanArray("cards")) != null) {
                System.arraycopy(temp, 0, checked, 0, arraySize);
                //for (int i = 0; i < arraySize; i++)
                    //checked[i] = temp[i];

            }
            else
            {
                for (int i = 0; i < arraySize; i++)
                    checked[i] = false;
            }
        }
    }
    protected int checkCount()
    {
        int temp_count = 0;
        for(int i = 0; i < arraySize; i++)
            if(checked[i])
                temp_count++;
        return temp_count;
    }
    protected void setToggle(int buttonId, boolean turnOn)
    {
        ImageButton toggle = findViewById(buttonId);
        if(turnOn)
            toggle.setBackgroundColor(getResources().getColor(R.color.brightGreen, null));
        else
            toggle.setBackgroundColor(getResources().getColor(R.color.brightRed, null));

    }
    protected void checkDone()
    {
        final Button done = findViewById(R.id.deckBuilderDone);
        if(count == 10)
        {
            done.setAlpha(1);
            done.setOnClickListener(new Button.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    setResult(Activity.RESULT_OK, new Intent().putExtra("cards", checked));
                    finish();
                }
            });
        }
        else
        {
            done.setAlpha((float)0.25);
            done.setOnClickListener(null);
        }


    }
    protected void clearButtons()
    {
        count = 0;
        for(int i = 0; i < arraySize; i++)
            checked[i] = false;
        setButtonToggles();
        setDeckCountField();
    }
    protected void setButtonToggles()
    {
        /*ImageButton plus1 = findViewById(R.id.plus1_db);
        ImageButton plus2 = findViewById(R.id.plus2_db);
        ImageButton plus3 = findViewById(R.id.plus3_db);
        ImageButton plus4 = findViewById(R.id.plus4_db);
        ImageButton plus5 = findViewById(R.id.plus5_db);
        ImageButton plus6 = findViewById(R.id.plus6_db);
        ImageButton minus1 = findViewById(R.id.minus1_db);
        ImageButton minus2 = findViewById(R.id.minus2_db);
        ImageButton minus3 = findViewById(R.id.minus3_db);
        ImageButton minus4 = findViewById(R.id.minus4_db);
        ImageButton minus5 = findViewById(R.id.minus5_db);
        ImageButton minus6 = findViewById(R.id.minus6_db);
        ImageButton pm1 = findViewById(R.id.pm1_db);
        ImageButton pm2 = findViewById(R.id.pm2_db);
        ImageButton pm3 = findViewById(R.id.pm3_db);
        ImageButton pm4 = findViewById(R.id.pm4_db);
        ImageButton pm5 = findViewById(R.id.pm5_db);
        ImageButton pm6 = findViewById(R.id.pm6_db);*/
        //ImageButton toggle = findViewById(R.id.plus1_db);
        setToggle(R.id.plus1_db, checked[plus1ID]);
        setToggle(R.id.plus2_db, checked[plus2ID]);
        setToggle(R.id.plus3_db, checked[plus3ID]);
        setToggle(R.id.plus4_db, checked[plus4ID]);
        setToggle(R.id.plus5_db, checked[plus5ID]);
        setToggle(R.id.plus6_db, checked[plus6ID]);
        setToggle(R.id.minus1_db, checked[minus1ID]);
        setToggle(R.id.minus2_db, checked[minus2ID]);
        setToggle(R.id.minus3_db, checked[minus3ID]);
        setToggle(R.id.minus4_db, checked[minus4ID]);
        setToggle(R.id.minus5_db, checked[minus5ID]);
        setToggle(R.id.minus6_db, checked[minus6ID]);
        setToggle(R.id.pm1_db, checked[pm1ID]);
        setToggle(R.id.pm2_db, checked[pm2ID]);
        setToggle(R.id.pm3_db, checked[pm3ID]);
        setToggle(R.id.pm4_db, checked[pm4ID]);
        setToggle(R.id.pm5_db, checked[pm5ID]);
        setToggle(R.id.pm6_db, checked[pm6ID]);


    }
    protected void addRemoveCard(int cardId)
    {
        checked[cardId] = !checked[cardId];
        if(checked[cardId])
            count++;
        else
            count--;
        checkDone();
        setDeckCountField();
    }
    protected void setButtonFunctions()
    {
        final Button clear = findViewById(R.id.clear_db);
        final Button revert = findViewById(R.id.revert_db);

        final ImageButton plus1 = findViewById(R.id.plus1_db);
        final ImageButton plus2 = findViewById(R.id.plus2_db);
        final ImageButton plus3 = findViewById(R.id.plus3_db);
        final ImageButton plus4 = findViewById(R.id.plus4_db);
        final ImageButton plus5 = findViewById(R.id.plus5_db);
        final ImageButton plus6 = findViewById(R.id.plus6_db);
        final ImageButton minus1 = findViewById(R.id.minus1_db);
        final ImageButton minus2 = findViewById(R.id.minus2_db);
        final ImageButton minus3 = findViewById(R.id.minus3_db);
        final ImageButton minus4 = findViewById(R.id.minus4_db);
        final ImageButton minus5 = findViewById(R.id.minus5_db);
        final ImageButton minus6 = findViewById(R.id.minus6_db);
        final ImageButton pm1 = findViewById(R.id.pm1_db);
        final ImageButton pm2 = findViewById(R.id.pm2_db);
        final ImageButton pm3 = findViewById(R.id.pm3_db);
        final ImageButton pm4 = findViewById(R.id.pm4_db);
        final ImageButton pm5 = findViewById(R.id.pm5_db);
        final ImageButton pm6 = findViewById(R.id.pm6_db);

        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                clearButtons();
                checkDone();
            }
        });
        revert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setChecked();
                count = checkCount();
                setButtonToggles();
                checkDone();
            }
        });
        plus1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addRemoveCard(plus1ID);
                setToggle(plus1.getId(), checked[plus1ID]);
            }
        });
    }
    protected void setDeckCountField()
    {
        TextView currentCount = findViewById(R.id.deckCount);
        countText = count +"10";
        currentCount.setText(countText);
    }
}
