package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView t1,t2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        t1 = findViewById(R.id.textView);
        t2 = findViewById(R.id.textView2);
        b1 = findViewById(R.id.button2);
        Intent in = getIntent();
        String res = in.getStringExtra("result");
        String word = in.getStringExtra("value");
        t1.setText(res);
        t2.setText(word);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newI = new Intent(MainActivity2.this, GameActivity.class);
                startActivity(newI);
            }
        });

    }
}