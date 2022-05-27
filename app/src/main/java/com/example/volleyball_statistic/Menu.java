package com.example.volleyball_statistic;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button statistic = (Button) findViewById(R.id.stat_btn);
        Button game = (Button) findViewById(R.id.game_btn);
        Button team_create = (Button) findViewById(R.id.team_create_btn);





        View.OnClickListener gm_btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Game.class);
                startActivity(intent);
            }
        };
        game.setOnClickListener(gm_btn);

        View.OnClickListener st_btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Statistic.class);
                startActivity(intent);
            }
        };
        statistic.setOnClickListener(st_btn);

        View.OnClickListener tmcr_btn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this,TeamCreate.class);
                startActivity(intent);
            }
        };
        team_create.setOnClickListener(tmcr_btn);

    }








}