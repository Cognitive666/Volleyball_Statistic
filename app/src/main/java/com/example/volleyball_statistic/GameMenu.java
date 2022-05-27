package com.example.volleyball_statistic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
        Button p_btn = (Button) findViewById(R.id.p_btn);
        Button ud_btn = (Button) findViewById(R.id.n_btn);
        Button dr_btn =(Button) findViewById(R.id.dr_btn);


        p_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameMenu.this,PodachaActivity.class);
                startActivity(intent);
            }
        });

        ud_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameMenu.this,UdarActivity.class);
                startActivity(intent);
            }
        });
        dr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameMenu.this,Game.class);
                startActivity(intent);
            }
        });
    }
}