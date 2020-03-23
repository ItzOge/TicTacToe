//package com.example.android.tictactoe;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    private Button[][] buttons = new Button[3][3];
//    private TextView player1TextView;
//    private TextView player2TextView;
//
//    private boolean player1Turn = true;
//
//    private int player1Points;
//    private int player2Points;
//
//    private int roundCount = 0;
//
//    String p1, p2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        //gets reference to the two textViews
//        player1TextView = (TextView)findViewById(R.id.player1_textView);
//        player2TextView = (TextView)findViewById(R.id.player2_textView);
//
//
//        Intent intent = getIntent();
//        p1= intent.getStringExtra("player1");
//        p2= intent.getStringExtra("player2");
//
//        if (p1.trim().equals(""))
//            player1TextView.setText("Player's 1 :");
//        else
//            player1TextView.setText( p1 + "'s score: ");
//
//        if (p2.trim().equals(""))
//            player2TextView.setText("Player's 2 :");
//        else
//            player2TextView.setText( p2 + "'s score: ");
//
//        for (int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                String buttonID = "button_"+ i + j;
//                int resID = getResources().getIdentifier(buttonID,"id",getPackageName());
//                buttons[i][j] = findViewById(resID);
//                buttons[i][j].setOnClickListener(this);
//            }
//        }
//
//        Button buttonreset = findViewById(R.id.button_reset);
//        buttonreset.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                // ((Button)view).setText("hi");
//                resetGame();
//            }
//        });
//    }
//
//    @Override
//    public void onClick(View view) {
//
//
//        if(!((Button)view).getText().toString().equals("")){
//            return;
//        }
//
//        if(player1Turn){
//            ((Button)view).setText("X");
//        }else{
//            ((Button)view).setText("O");
//        }
//
//        roundCount++;
//
//        if(checkForWin()){
//            if (player1Turn) {
//                player1Wins();
//            }else{
//                player2Wins();
//            }
//        } else if (roundCount == 9){
//            draw();
//        } else {
//            //changesturns between the players for the next round
//            player1Turn = !player1Turn;
//        }
//    }
//
//    //loops through the butons to know if any player won
//    private boolean checkForWin(){
//        String[][] field = new String[3][3];
//        for(int i = 0; i < 3; i++){
//            for(int j = 0; j < 3; j++){
//                field[i][j] = buttons[i][j].getText().toString();
//            }
//        }
//        //checks for the rows
//        for(int i = 0; i < 3; i++){
//            if (field[i][0].equals(field[i][1])
//                    && field[i][0].equals(field[i][2])
//                    && !field[i][0].equals("")){
//                return true;
//            }
//        }
//
//        //checks for the columns
//        for(int i = 0; i < 3; i++){
//            if (field[0][i].equals(field[1][i])
//                    && field[0][i].equals(field[2][i])
//                    && !field[0][i].equals("")){
//                return true;
//            }
//        }
//
//        //checks for the positive diagonal
//        if (field[0][0].equals(field[1][1])
//                && field[0][0].equals(field[2][2])
//                && !field[0][0].equals("")) {
//            return true;
//        }
//
//        //checks for the negative diagonal
//        if (field[0][2].equals(field[1][1])
//                && field[0][2].equals(field[2][0])
//                && !field[0][2].equals("")){
//            return true;
//        }
//
//        //incase there is no winner it returns false
//        return false;
//    }
//
//    private void player1Wins(){
//        player1Points++;
//        Toast.makeText(this,"player 1 wins",Toast.LENGTH_SHORT).show();
//        updatePointsText();
//        resetBoard();
//    }
//
//    private void player2Wins(){
//        player2Points++;
//        Toast.makeText(this,"player 2 wins",Toast.LENGTH_SHORT).show();
//        updatePointsText();
//        resetBoard();
//    }
//
//    private void draw(){
//        Toast.makeText(this,"Draw!",Toast.LENGTH_SHORT).show();
//        resetBoard();
//    }
//
//    private void updatePointsText(){
//
//        if (p1.trim().equals(""))
//            player1TextView.setText("Player's 1: " + player1Points);
//        else
//            player1TextView.setText( p1 + "'s score: "+ player1Points);
//
//        if (p2.trim().equals(""))
//            player2TextView.setText("Player's 2: "+ player2Points);
//        else
//            player2TextView.setText( p2 + "'s score: "+ player2Points);
//
//    }
//
//    private void resetBoard(){
//        for(int i = 0; i < 3; i++){
//            for (int j = 0; j < 3; j++){
//                buttons[i][j].setText("");
//            }
//        }
//        roundCount = 0;
//        player1Turn = true;
//    }
//
//    private void resetGame(){
//        player1Points = 0;
//        player2Points = 0;
//        updatePointsText();
//        resetBoard();
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("roundCount",roundCount);
//        outState.putInt("player1Points",player1Points);
//        outState.putInt("player2Points",player2Points);
//        outState.putBoolean("player1Turn",player1Turn);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        roundCount =  savedInstanceState.getInt("roundCount");
//        player1Points =   savedInstanceState.getInt("player1Points");
//        player2Points =   savedInstanceState.getInt("player2Points");
//        player1Turn = savedInstanceState.getBoolean("player1Turn");
//    }
//}
//
