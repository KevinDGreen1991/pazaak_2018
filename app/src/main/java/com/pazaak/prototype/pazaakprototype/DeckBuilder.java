package com.pazaak.prototype.pazaakprototype;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.w3c.dom.Text;

import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class DeckBuilder extends AppCompatActivity
{
    //private static final int THIS_RESULT_CODE = 2;
    static int arraySize= 18;
    public int count = 0;
    public String countText = "deckCount";
    public boolean checked[] = new boolean[arraySize];
    //Card test = new Card(Card.PLUS, 6);
    //public int i = 0;
    //TextView deckCount = findViewById(R.id.deckCount);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_builder);
        Bundle extras = getIntent().getExtras();
        //boolean temp[] = getIntent().getBooleanArrayExtra("test");
        boolean temp[];
        if(extras != null) {
            if (extras.containsKey("cards")) {
                temp = extras.getBooleanArray("cards");
                for (int i = 0; i < arraySize; i++) {
                    checked[i] = temp[i];
                    if (checked[i]) {
                        count++;
                    }
                }
            }
            else
                {
                for (int i = 0; i < arraySize; i++)
                    checked[i] = false;
                }
        }
        checkDone();
        //checked = getIntent().getBooleanArrayExtra("test");
        //getIntent().getBooleanArrayExtra();
        //final TextView countTextText = findViewById(R.id.testText);
        //countTextText.setText(test+"");

        final TextView deckCount = findViewById(R.id.deckCount);
        //NOTE: checkbox position can be read from top left going left to right
        /*final CheckBox checkBoxes[] = new CheckBox[arraySize];
        checkBoxes[0] = findViewById(R.id.check_plus1);
        checkBoxes[1]= findViewById(R.id.check_plus2);
        checkBoxes[2]= findViewById(R.id.check_plus3);
        checkBoxes[3] = findViewById(R.id.check_plus4);
        checkBoxes[4]= findViewById(R.id.check_plus5);
        checkBoxes[5]= findViewById(R.id.check_plus6);
        checkBoxes[6]= findViewById(R.id.check_minus1);
        checkBoxes[7]= findViewById(R.id.check_minus2);
        checkBoxes[8]= findViewById(R.id.check_minus3);
        checkBoxes[9]= findViewById(R.id.check_minus4);
        checkBoxes[10] = findViewById(R.id.check_minus5);
        checkBoxes[11] = findViewById(R.id.check_minus6);
        checkBoxes[12] = findViewById(R.id.check_pm1);
        checkBoxes[13] = findViewById(R.id.check_pm2);
        checkBoxes[14]= findViewById(R.id.check_pm3);
        checkBoxes[15] = findViewById(R.id.check_pm4);
        checkBoxes[16]= findViewById(R.id.check_pm5);
        checkBoxes[17]= findViewById(R.id.check_pm6);*/
        //final ImageView test = findViewById(R.id.plus1);
        //test.setImageResource(new Card(Card.PLUS, 6).getImage());
        final CheckBox plus1 = findViewById(R.id.check_plus1);
        plus1.setChecked(checked[0]);
        final CheckBox plus2 = findViewById(R.id.check_plus2);
        plus2.setChecked(checked[1]);
        final CheckBox plus3 = findViewById(R.id.check_plus3);
        plus3.setChecked(checked[2]);
        final CheckBox plus4 = findViewById(R.id.check_plus4);
        plus4.setChecked(checked[3]);
        final CheckBox plus5 = findViewById(R.id.check_plus5);
        plus5.setChecked(checked[4]);
        final CheckBox plus6 = findViewById(R.id.check_plus6);
        plus6.setChecked(checked[5]);
        final CheckBox minus1 = findViewById(R.id.check_minus1);
        minus1.setChecked(checked[6]);
        final CheckBox minus2 = findViewById(R.id.check_minus2);
        minus2.setChecked(checked[7]);
        final CheckBox minus3 = findViewById(R.id.check_minus3);
        minus3.setChecked(checked[8]);
        final CheckBox minus4 = findViewById(R.id.check_minus4);
        minus4.setChecked(checked[9]);
        final CheckBox minus5 = findViewById(R.id.check_minus5);
        minus5.setChecked(checked[10]);
        final CheckBox minus6 = findViewById(R.id.check_minus6);
        minus6.setChecked(checked[11]);
        final CheckBox pm1 = findViewById(R.id.check_pm1);
        pm1.setChecked(checked[12]);
        final CheckBox pm2 = findViewById(R.id.check_pm2);
        pm2.setChecked(checked[13]);
        final CheckBox pm3 = findViewById(R.id.check_pm3);
        pm3.setChecked(checked[14]);
        final CheckBox pm4 = findViewById(R.id.check_pm4);
        pm4.setChecked(checked[15]);
        final CheckBox pm5 = findViewById(R.id.check_pm5);
        pm5.setChecked(checked[16]);
        final CheckBox pm6 = findViewById(R.id.check_pm6);
        pm6.setChecked(checked[17]);
        //public int count = 0;
        countText = count+"/10";
        deckCount.setText(countText);

        /*for(i = 0; i < arraySize; i++)
        {
            checkBoxes[i].setOnClickListener(new CheckBox.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if (checkBoxes[i].isChecked())
                    {
                        count++;
                        countText = count + "/10";
                    } else
                    {
                        count--;
                        countText = count + "/10";
                    }
                    deckCount.setText(countText);
                }
            });
        }*/

        plus1.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (plus1.isChecked())
                {
                    count++;
                } else
                {
                    count--;
                }
                checked[0] = !checked[0];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        plus2.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (plus2.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";
                }
                checked[1] = !checked[1];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();            }
        });

        plus3.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (plus3.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[2] = !checked[2];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        plus4.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (plus4.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[3] = !checked[3];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        plus5.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (plus5.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[4] = !checked[4];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        plus6.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (plus6.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[5] = !checked[5];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        minus1.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (minus1.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[6] = !checked[6];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        minus2.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (minus2.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[7] = !checked[7];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        minus3.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (minus3.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[8] = !checked[8];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });
        minus4.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (minus4.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[9] = !checked[9];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        minus5.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (minus5.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[10] = !checked[10];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        minus6.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (minus6.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[11] = !checked[11];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        pm1.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (pm1.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[12] = !checked[12];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        pm2.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (pm2.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[13] = !checked[13];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        pm3.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (pm3.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[14] = !checked[14];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        pm4.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (pm4.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[15] = !checked[15];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        pm5.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (pm5.isChecked())
                {
                    count++;
                    //countText = count + "/10";
                } else
                {
                    count--;
                    //countText = count + "/10";

                }
                checked[16] = !checked[16];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

        pm6.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (pm6.isChecked())
                {
                    count++;
                    countText = count + "/10";
                } else
                {
                    count--;
                    countText = count + "/10";
                }
                checked[17] = !checked[17];
                countText = count + "/10";
                deckCount.setText(countText);
                checkDone();
            }
        });

    }

    protected void checkDone()
    {
        //FOR TESTING PURPOSES ONLY
        final Button done = findViewById(R.id.deckBuilderDone);
        if(count == 10)
        {
            done.setVisibility(View.VISIBLE);
            done.setOnClickListener(new Button.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    //getIntent().putExtra("cards", checked);
                    setResult(Activity.RESULT_OK, new Intent().putExtra("cards", checked));
                    finish();
                }
            });
        }
        else
        {
            done.setVisibility(View.GONE);
            done.setOnClickListener(null);
        }


    };

}
