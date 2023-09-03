package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class GameActivity extends AppCompatActivity {
    String words[] = {"word", "look", "nice", "good", "girl", "king", "bait", "kill", "trap", "oven", "over", "jack"};

    ImageView h1,h2,h3,h4,h5,h6;

    TextView c1, c2, c3, c4, str;
    Button check;
    EditText text;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random rr = new Random();
        String mainWord = words[rr.nextInt(12)];
        final int[] mainCount = {0};
        boolean pos[] = {false, false, false, false, false, false};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        h1 = findViewById(R.id.imageView);
        h2 = findViewById(R.id.imageView2);
        h3 = findViewById(R.id.imageView3);
        h4 = findViewById(R.id.imageView4);
        h5 = findViewById(R.id.imageView5);
        h6 = findViewById(R.id.imageView6);
        c1 = findViewById(R.id.char3);
        c2 = findViewById(R.id.char1);
        c3 = findViewById(R.id.char4);
        c4 = findViewById(R.id.char2);
        check = findViewById(R.id.button);
        text = findViewById(R.id.letter);
        str = findViewById(R.id.striked);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String letter = text.getText().toString();
                boolean found = false, actualFound = false;
//                Toast.makeText(getApplicationContext(), String.valueOf(mainWord.charAt(0)), Toast.LENGTH_LONG).show();
                for (int i = 0; i < 4; i++) {
                    if(letter.equals(String.valueOf(mainWord.charAt(i)))) {
                        found = true;
                        actualFound = true;
                        mainCount[0]++;
                        if(i == 0) c1.setText(letter);
                        else if(i == 1) c2.setText(letter);
                        else if(i == 2)c3.setText(letter);
                        else
                            c4.setText(letter);
                        if(mainCount[0]>3){
                            Intent intent = new Intent(GameActivity.this, MainActivity2.class);
                            intent.putExtra("result", "Won!");
                            intent.putExtra("value", "The word was: "+mainWord);
                            startActivity(intent);
                        }
                        text.setText("");
                    }
                    else found = false;
                }
                System.out.println(found);
                if(!found && !actualFound){
                    int count = 0;
                    for (boolean i : pos){
                        if(!i){
                            str.setText(str.getText() + letter);
                            pos[count] = true;
                            if(count == 0) {
                                h1.setVisibility(View.VISIBLE);break;
                            }
                            else if(count == 1) {
                                h2.setVisibility(View.VISIBLE);break;
                            }
                            else if(count == 2) {
                                h3.setVisibility(View.VISIBLE);break;
                            }
                            else if(count == 3) {
                                h4.setVisibility(View.VISIBLE);break;
                            }
                            else if(count == 4) {
                                h5.setVisibility(View.VISIBLE);break;
                            }
                            else {
//                                Need to end game
                                h6.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(GameActivity.this, MainActivity2.class);
                                intent.putExtra("result", "Lost!");
                                intent.putExtra("value", "The word was: "+mainWord);
                                startActivity(intent);
                                break;
                            }
                        }
                        count++;
                    }
                }
            }
        });
    }
}