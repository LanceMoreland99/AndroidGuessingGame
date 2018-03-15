package com.example.lancemoreland.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView clueTextView;
    private Button guessButton;
    private EditText guess;
    private int generatedNumber;
    private int numberOfGuesses = 0;
    private int MAX_GUESS_COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        clueTextView = findViewById(R.id.clue_Textview);
        guessButton = findViewById(R.id.submitNumber_Button);
        guess = findViewById(R.id.editText);

        setListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        generatedNumber = (int) Math.ceil(Math.random() * 100);
    }

    private void setListener(){
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userGuess = Integer.parseInt(guess.getText().toString());
                if (userGuess > 100){
                    clueTextView.setText(R.string.invalid_number_message);
                    clueTextView.setVisibility(View.VISIBLE);
                    guess.setText("");
                }else {
                    checkGuess(userGuess);
                }
            }
        });
    }

    private void checkGuess(int userGuess) {
        if (userGuess < generatedNumber) {
            clueTextView.setText(R.string.number_low);
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;

        } else if (userGuess > generatedNumber) {
            clueTextView.setText(R.string.number_high);
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;

        } else if (userGuess == generatedNumber) {
            //TODO - create intent to go to winning activity - handle winning

        } else if (numberOfGuesses == MAX_GUESS_COUNT) {
            //TODO - create intent to go to wining activity - out of chances
        }
    }

    @Override
    public void onBackPressed() {

    }
}
