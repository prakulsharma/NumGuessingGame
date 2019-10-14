package com.example.uno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    int guess=10;

    public void clickReset(View view) {

        EditText myText = findViewById(R.id.editText2);
        TextView myGuess = findViewById(R.id.textView4);
        guess=10;
        myGuess.setText(String.valueOf(guess));
        myText.getText().clear();

        Button button = findViewById(R.id.button);
        button.setVisibility(Button.INVISIBLE);
    }

    public void clickFunction(View view) {

        EditText myText = findViewById(R.id.editText2);
        TextView myGuess = findViewById(R.id.textView4);
        Button button = findViewById(R.id.button);

        int num = Integer.parseInt(myText.getText().toString());

        if(num > randomNumber){
            Toast.makeText(this, "Go lower!", Toast.LENGTH_SHORT).show();
            guess = guess - 1;
            myGuess.setText(String.valueOf(guess));
            myText.getText().clear();

        }
        else if(num < randomNumber){
            Toast.makeText(this, "Go higher!", Toast.LENGTH_SHORT).show();
            guess = guess - 1;
            myGuess.setText(String.valueOf(guess));
            myText.getText().clear();
        }
        else {
            Toast.makeText(this, "Congratulations, your score is " + guess + ".", Toast.LENGTH_LONG).show();
            myText.getText().clear();
            button.setEnabled(true);
            button.setVisibility(Button.VISIBLE);
        }
        if(guess==0) {
            Toast.makeText(this, "You lose. Replay!", Toast.LENGTH_SHORT).show();
            myText.getText().clear();
            button.setEnabled(true);
            button.setVisibility(Button.VISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;

        TextView myGuess = findViewById(R.id.textView4);     // create object
        myGuess.setText(String.valueOf(guess));                         // initialize score = 10 when start

        EditText myText = (EditText) findViewById(R.id.editText2);      // create object
        myText.getText().clear();                                       // empty input when start

        Button button = findViewById(R.id.button);
        button.setEnabled(false);
        button.setVisibility(Button.INVISIBLE);
    }
}
