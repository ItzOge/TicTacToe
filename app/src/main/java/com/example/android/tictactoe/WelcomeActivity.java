package com.example.android.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    EditText mPlayer1, mPlayer2;
    Button mStartButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mPlayer1 = (EditText)findViewById(R.id.player1);
        mPlayer2 = (EditText)findViewById(R.id.player2);
        mStartButton = (Button)findViewById(R.id.startButton);


        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nPlayer1 = mPlayer1.getText().toString();
                String nPlayer2 = mPlayer2.getText().toString();
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                intent.putExtra("player1",nPlayer1);
                intent.putExtra("player2",nPlayer2);
                startActivity(intent);
                if (nPlayer1.trim().equals("") && nPlayer2.trim().equals(""))
                    Toast.makeText(WelcomeActivity.this,"Welcome players 1 and 2",Toast.LENGTH_SHORT).show();
                else if(!nPlayer1.trim().equals(""))
                    Toast.makeText(WelcomeActivity.this, " Welcome players " + nPlayer1+ " and player2" ,Toast.LENGTH_SHORT).show();
                else if(!nPlayer2.trim().equals(""))
                    Toast.makeText(WelcomeActivity.this, " Welcome players1 and " + nPlayer2 ,Toast.LENGTH_SHORT).show();
                else
                Toast.makeText(WelcomeActivity.this,"Welcome Players: "+ nPlayer1 + " and "+ nPlayer2, Toast.LENGTH_SHORT).show();

                finish();

            }
        });
    }
}
