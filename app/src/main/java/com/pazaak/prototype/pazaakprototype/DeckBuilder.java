package com.pazaak.prototype.pazaakprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.w3c.dom.Text;

import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class DeckBuilder extends AppCompatActivity {
    public int count = 0;
    public String test = count+"/10";
    public boolean checked[] = new boolean[18];
    //TextView deckCount = findViewById(R.id.deckCount);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_builder);
        final TextView deckCount = findViewById(R.id.deckCount);
        final CheckBox plus1 = findViewById(R.id.check_plus1);
        final CheckBox plus2 = findViewById(R.id.check_plus2);
        final CheckBox plus3 = findViewById(R.id.check_plus3);
        final CheckBox plus4 = findViewById(R.id.check_plus4);
        final CheckBox plus5 = findViewById(R.id.check_plus5);
        final CheckBox plus6 = findViewById(R.id.check_plus6);
        final CheckBox minus1 = findViewById(R.id.check_minus1);
        final CheckBox minus2 = findViewById(R.id.check_minus2);
        final CheckBox minus3 = findViewById(R.id.check_minus3);
        final CheckBox minus4 = findViewById(R.id.check_minus4);
        final CheckBox minus5 = findViewById(R.id.check_minus5);
        final CheckBox minus6 = findViewById(R.id.check_minus6);
        final CheckBox pm1 = findViewById(R.id.check_pm1);
        final CheckBox pm2 = findViewById(R.id.check_pm2);
        final CheckBox pm3 = findViewById(R.id.check_pm3);
        final CheckBox pm4 = findViewById(R.id.check_pm4);
        final CheckBox pm5 = findViewById(R.id.check_pm5);
        final CheckBox pm6 = findViewById(R.id.check_pm6);
        //public int count = 0;
        //String test = count+"/10";
        deckCount.setText(test);

        plus1.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(plus1.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";
                }
                deckCount.setText(test);
            }
        });

        plus2.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(plus2.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";
                }
                deckCount.setText(test);
            }
        });

        plus3.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(plus3.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        plus4.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(plus4.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        plus5.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(plus5.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        plus6.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(plus6.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        minus1.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(minus1.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        minus2.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(minus2.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        minus3.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(minus3.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });
        minus4.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(minus4.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        minus5.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(minus5.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        minus6.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(minus6.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        pm1.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pm1.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        pm2.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pm2.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        pm3.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pm3.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        pm4.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pm4.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        pm5.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pm5.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";

                }
                deckCount.setText(test);
            }
        });

        pm6.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pm6.isChecked())
                {
                    count++;
                    test = count+"/10";
                }
                else {
                    count--;
                    test = count+"/10";
                }
                deckCount.setText(test);
            }
        });
}
    protected void TEST(){
        //FOR TESTING PURPOSES ONLY

    }

}
