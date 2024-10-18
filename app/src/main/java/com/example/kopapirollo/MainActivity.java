package com.example.kopapirollo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView buttonRock ;
    private ImageView buttonPaper;
    private ImageView buttonScissors;
    private Random random;
    private int player;
    private int robot;
    private ImageView imageViewPlayer;
    private ImageView imageViewRobot;
    private TextView textViewPlayerCount;
    private TextView textViewComputerCount;
    private int playerNumber;
    private int robotNumber;
    private AlertDialog alertDialog;
    private AlertDialog alertDialog2;
    private TextView textViewDraw;
    private TextView textViewDrawCount;
    private int drawCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();


            buttonRock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    playerNumber = 0;
                    robotNumber = random.nextInt(3);
                    checkGame(playerNumber, robotNumber);


                }
            });
            buttonPaper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    playerNumber = 1;
                    robotNumber = random.nextInt(3);
                    checkGame(playerNumber, robotNumber);


                }
            });
            buttonScissors.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playerNumber = 2;
                    robotNumber = random.nextInt(3);
                    checkGame(playerNumber, robotNumber);

                }
            });





    }

    public void init(){
        buttonRock =findViewById(R.id.buttonRock);
        buttonPaper = findViewById(R.id.buttonPaper);
        buttonScissors = findViewById(R.id.buttonScissors);
        random = new Random();
        player = 0;
        robot = 0;
        playerNumber = 0;
        robotNumber = 0;
        imageViewPlayer = findViewById(R.id.imageViewPlayer);
        imageViewRobot = findViewById(R.id.imageViewRobot);
        textViewComputerCount = findViewById(R.id.textViewComputerCount);
        textViewPlayerCount = findViewById(R.id.textViewPlayerCount);
        textViewComputerCount.setText(String.valueOf(robot));
        textViewPlayerCount.setText(String.valueOf(player));
        textViewDraw = findViewById(R.id.textViewDraw);
        textViewDrawCount = findViewById(R.id.textViewDrawCount);
        drawCount = 0;
        textViewDrawCount.setText(String.valueOf(drawCount));


        alertDialog = new AlertDialog.Builder(MainActivity.this).setTitle("Győzelem").setMessage("Szeretne új játékot játszani?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newGame();
                    }
                }).setCancelable(false).create();

        alertDialog2 = new AlertDialog.Builder(MainActivity.this).setTitle("Vereség").setMessage("Szeretne új játékot játszani?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newGame();
                    }
                }).setCancelable(false).create();

    }


    public void checkGame(int playerNumber, int robotNumber){
            switch (playerNumber){
                case 0:
                    imageViewPlayer.setImageResource(R.drawable.rock);
                    if(robotNumber == 1){
                        robot ++;
                        textViewComputerCount.setText(String.valueOf(robot));
                    } else if (robotNumber == 0) {
                        drawCount++;
                        textViewDrawCount.setText(String.valueOf(drawCount));
                    }
                    break;
                case 1:
                    imageViewPlayer.setImageResource(R.drawable.paper);
                    if(robotNumber == 2){
                        robot++;
                        textViewComputerCount.setText(String.valueOf(robot));
                    } else if (robotNumber == 1) {
                        drawCount++;
                        textViewDrawCount.setText(String.valueOf(drawCount));
                    }
                    break;
                case 2:
                    imageViewPlayer.setImageResource(R.drawable.scissors);
                    if(robotNumber == 0){
                        robot++;
                        textViewComputerCount.setText(String.valueOf(robot));
                    } else if (robotNumber == 2) {
                        drawCount++;
                        textViewDrawCount.setText(String.valueOf(drawCount));
                    }
                    break;
                default:
                    break;
            }
            switch (robotNumber){
                case 0:
                    imageViewRobot.setImageResource(R.drawable.rock);
                    if(playerNumber == 1){
                        player++;
                        textViewPlayerCount.setText(String.valueOf(player));
                    }

                    break;
                case 1:
                    imageViewRobot.setImageResource(R.drawable.paper);
                    if(playerNumber == 2){
                        player++;
                        textViewPlayerCount.setText(String.valueOf(player));
                    }

                    break;
                case 2:
                    imageViewRobot.setImageResource(R.drawable.scissors);
                    if(playerNumber == 0){
                        player++;
                        textViewPlayerCount.setText(String.valueOf(player));
                    }
                    break;
                default:
                    break;
            }
            if( player == 3 ){
                alertDialog.show();
            } else if (robot == 3 ) {
                alertDialog2.show();
            }


    }

    public void newGame()
    {
        player = 0;
        robot = 0;
        playerNumber = 0;
        robotNumber = 0;
        drawCount = 0;
        textViewComputerCount.setText(String.valueOf(robot));
        textViewPlayerCount.setText(String.valueOf(player));
        textViewDrawCount.setText(String.valueOf(drawCount));
        imageViewPlayer.setImageResource(R.drawable.rock);
        imageViewRobot.setImageResource(R.drawable.rock);
    }

}