package com.example.volleyball_statistic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Game extends AppCompatActivity {
    public SharedPreferences pref;
    public int score1 = 0;
    public int score2 = 0;
    String score1_str;
    String score2_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Button clear = (Button) findViewById(R.id.clear_btn);
        Button plus1 = (Button) findViewById(R.id.plus_btn1);
        Button plus2 = (Button) findViewById(R.id.plus_btn2);
        Button minus1 = (Button) findViewById(R.id.minus_btn1);
        Button minus2 = (Button) findViewById(R.id.minus_btn2);
        Button back = (Button) findViewById(R.id.back_btn);
        TextView score_panel1 = (TextView) findViewById(R.id.score1);
        TextView score_panel2 = (TextView) findViewById(R.id.score2);
        Button win1 = (Button) findViewById(R.id.win1_btn);
        Button win2 = (Button) findViewById(R.id.win2_btn);
        Button accept_btn = (Button) findViewById(R.id.accept_btn);
        pref = getSharedPreferences("Test",MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        score1 = pref.getInt("Score1",123);
        score2 = pref.getInt("Score2",123);
        score1_str = Integer.toString(score1);
        score_panel1.setText(score1_str);
        score2_str = Integer.toString(score2);
        score_panel2.setText(score2_str);
        int teams_num = pref.getInt("TeamsNum",1);

        String p1_name = pref.getString("Player1/name","void");
        int p1_rate = pref.getInt("Player1/rating",0);
        String p1_rt_svcode ="Player1/rating";
        String p2_name = pref.getString("Player2/name","void");
        int p2_rate = pref.getInt("Player2/rating",0);
        String p2_rt_svcode ="Player2/rating";
        String p3_name = pref.getString("Player3/name","void");
        int p3_rate = pref.getInt("Player3/rating",0);
        String p3_rt_svcode ="Player3/rating";
        String p4_name = pref.getString("Player4/name","void");
        int p4_rate = pref.getInt("Player4/rating",0);
        String p4_rt_svcode ="Player4/rating";
        String p5_name = pref.getString("Player5/name","void");
        int p5_rate = pref.getInt("Player5/rating",0);
        String p5_rt_svcode ="Player5/rating";
        String p6_name = pref.getString("Player6/name","void");
        int p6_rate = pref.getInt("Player6/rating",0);
        String p6_rt_svcode ="Player6/rating";
        String p7_name = pref.getString("Player7/name","void");
        int p7_rate = pref.getInt("Player7/rating",0);
        String p7_rt_svcode ="Player7/rating";
        String p8_name = pref.getString("Player8/name","void");
        int p8_rate = pref.getInt("Player8/rating",0);
        String p8_rt_svcode ="Player8/rating";
        String p9_name = pref.getString("Player9/name","void");
        int p9_rate = pref.getInt("Player9/rating",0);
        String p9_rt_svcode ="Player9/rating";
        String p10_name = pref.getString("Player10/name","void");
        int p10_rate = pref.getInt("Player10/rating",0);
        String p10_rt_svcode ="Player10/rating";
        String p11_name = pref.getString("Player11/name","void");
        int p11_rate = pref.getInt("Player11/rating",0);
        String p11_rt_svcode ="Player11/rating";
        String p12_name = pref.getString("Player12/name","void");
        int p12_rate = pref.getInt("Player12/rating",0);
        String p12_rt_svcode ="Player12/rating";


        String[] player_list = {p1_name, p2_name, p3_name, p4_name,p5_name, p6_name, p7_name, p8_name, p9_name, p10_name, p11_name, p12_name,"Другой игрок"};


        Spinner sp_1_tm1 = findViewById(R.id.spinner1_tm1);
        Spinner sp_2_tm1= findViewById(R.id.spinner_tm1);
        Spinner sp_3_tm1= findViewById(R.id.spinner3_tm1);
        Spinner sp_4_tm1= findViewById(R.id.spinner4_tm1);
        Spinner sp_5_tm1= findViewById(R.id.spinner5_tm1);
        Spinner sp_6_tm1= findViewById(R.id.spinner6_tm1);
        Spinner sp_1_tm2= findViewById(R.id.spinner1_tm2);
        Spinner sp_2_tm2= findViewById(R.id.spinner_tm2);
        Spinner sp_3_tm2= findViewById(R.id.spinner_tm3);
        Spinner sp_4_tm2 = findViewById(R.id.spinner_tm4);
        Spinner sp_5_tm2 = findViewById(R.id.spinner_tm5);
        Spinner sp_6_tm2 = findViewById(R.id.spinner_tm6);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, player_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_1_tm1.setAdapter(adapter);
        sp_2_tm1.setAdapter(adapter);
        sp_3_tm1.setAdapter(adapter);
        sp_4_tm1.setAdapter(adapter);
        sp_5_tm1.setAdapter(adapter);
        sp_6_tm1.setAdapter(adapter);
        sp_1_tm2.setAdapter(adapter);
        sp_2_tm2.setAdapter(adapter);
        sp_3_tm2.setAdapter(adapter);
        sp_4_tm2.setAdapter(adapter);
        sp_5_tm2.setAdapter(adapter);
        sp_6_tm2.setAdapter(adapter);



        Spinner team_spinner1 = findViewById(R.id.team_spinner1);
        Spinner team_spinner2 = findViewById(R.id.team_spinner2);
        String team_list[];
        team_list =new String[teams_num+1];
        team_list[0] ="Произвольная команда";
        for(int i = 0; i<(teams_num+1); i++){
            if (i!=0){
                String buffer = Integer.toString(i);
                team_list[i] = pref.getString("Team"+buffer +"/name","Null");
            }
        }
        ArrayAdapter<String> team_adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, team_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        team_spinner1.setAdapter(team_adapter);
        team_spinner2.setAdapter(team_adapter);

        pos_arranger(sp_1_tm1,"sp_1_tm1");
        pos_arranger(sp_2_tm1,"sp_2_tm1");
        pos_arranger(sp_3_tm1,"sp_3_tm1");
        pos_arranger(sp_4_tm1,"sp_4_tm1");
        pos_arranger(sp_5_tm1,"sp_5_tm1");
        pos_arranger(sp_6_tm1,"sp_6_tm1");
        pos_arranger(sp_1_tm2,"sp_1_tm2");
        pos_arranger(sp_2_tm2,"sp_2_tm2");
        pos_arranger(sp_3_tm2,"sp_3_tm2");
        pos_arranger(sp_4_tm2,"sp_4_tm2");
        pos_arranger(sp_5_tm2,"sp_5_tm2");
        pos_arranger(sp_6_tm2,"sp_6_tm2");


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.putInt("sp_1_tm1",0);
                edit.putInt("sp_2_tm1",0);
                edit.putInt("sp_3_tm1",0);
                edit.putInt("sp_4_tm1",0);
                edit.putInt("sp_5_tm1",0);
                edit.putInt("sp_6_tm1",0);
                edit.putInt("sp_1_tm2",0);
                edit.putInt("sp_2_tm2",0);
                edit.putInt("sp_3_tm2",0);
                edit.putInt("sp_4_tm2",0);
                edit.putInt("sp_5_tm2",0);
                edit.putInt("sp_6_tm2",0);
                edit.putInt("Score1",0);
                edit.putInt("Score2",0);
                edit.apply();
                pos_arranger(sp_1_tm1,"sp_1_tm1");
                pos_arranger(sp_2_tm1,"sp_2_tm1");
                pos_arranger(sp_3_tm1,"sp_3_tm1");
                pos_arranger(sp_4_tm1,"sp_4_tm1");
                pos_arranger(sp_5_tm1,"sp_5_tm1");
                pos_arranger(sp_6_tm1,"sp_6_tm1");
                pos_arranger(sp_1_tm2,"sp_1_tm2");
                pos_arranger(sp_2_tm2,"sp_2_tm2");
                pos_arranger(sp_3_tm2,"sp_3_tm2");
                pos_arranger(sp_4_tm2,"sp_4_tm2");
                pos_arranger(sp_5_tm2,"sp_5_tm2");
                pos_arranger(sp_6_tm2,"sp_6_tm2");
                score1 = pref.getInt("Score1",0);
                score2 = pref.getInt("Score2",0);
                score_panel1.setText("0");
                score_panel2.setText("0");

            }
        });
        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score1 +=1;
                score1_str = Integer.toString(score1);

                score_panel1.setText(score1_str);
                edit.putInt("Score1",score1);
                edit.apply();
                pos_checker(sp_1_tm1,"sp_1_tm1",edit);
                pos_checker(sp_2_tm1,"sp_2_tm1",edit);
                pos_checker(sp_3_tm1,"sp_3_tm1",edit);
                pos_checker(sp_4_tm1,"sp_4_tm1",edit);
                pos_checker(sp_5_tm1,"sp_5_tm1",edit);
                pos_checker(sp_6_tm1,"sp_6_tm1",edit);
                pos_checker(sp_1_tm2,"sp_1_tm2",edit);
                pos_checker(sp_2_tm2,"sp_2_tm2",edit);
                pos_checker(sp_3_tm2,"sp_3_tm2",edit);
                pos_checker(sp_4_tm2,"sp_4_tm2",edit);
                pos_checker(sp_5_tm2,"sp_5_tm2",edit);
                pos_checker(sp_6_tm2,"sp_6_tm2",edit);

                Intent intent = new Intent(Game.this,GameMenu.class);
                startActivity(intent);

            }
        });


        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (score1 != 0) {
                    score1 -= 1;

                }

                score1_str = Integer.toString(score1);

                score_panel1.setText(score1_str);
                edit.putInt("Score1",score1);
                edit.apply();
            }
        });

        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score2 +=1;


                score2_str = Integer.toString(score2);

                score_panel2.setText(score2_str);
                edit.putInt("Score2",score2);
                pos_checker(sp_1_tm1,"sp_1_tm1",edit);
                pos_checker(sp_2_tm1,"sp_2_tm1",edit);
                pos_checker(sp_3_tm1,"sp_3_tm1",edit);
                pos_checker(sp_4_tm1,"sp_4_tm1",edit);
                pos_checker(sp_5_tm1,"sp_5_tm1",edit);
                pos_checker(sp_6_tm1,"sp_6_tm1",edit);
                pos_checker(sp_1_tm2,"sp_1_tm2",edit);
                pos_checker(sp_2_tm2,"sp_2_tm2",edit);
                pos_checker(sp_3_tm2,"sp_3_tm2",edit);
                pos_checker(sp_4_tm2,"sp_4_tm2",edit);
                pos_checker(sp_5_tm2,"sp_5_tm2",edit);
                pos_checker(sp_6_tm2,"sp_6_tm2",edit);
                edit.apply();

                Intent intent = new Intent(Game.this,GameMenu.class);
                startActivity(intent);
            }
        });


        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (score2 != 0) {

                    score2 -=1;

                }

                score2_str = Integer.toString(score2);

                score_panel2.setText(score2_str);
                edit.putInt("Score2",score2);
                edit.apply();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Game.this, Menu.class);
                edit.putInt("sp_1_tm1",0);
                edit.putInt("sp_2_tm1",0);
                edit.putInt("sp_3_tm1",0);
                edit.putInt("sp_4_tm1",0);
                edit.putInt("sp_5_tm1",0);
                edit.putInt("sp_6_tm1",0);
                edit.putInt("sp_1_tm2",0);
                edit.putInt("sp_2_tm2",0);
                edit.putInt("sp_3_tm2",0);
                edit.putInt("sp_4_tm2",0);
                edit.putInt("sp_5_tm2",0);
                edit.putInt("sp_6_tm2",0);



                edit.apply();
                startActivity(intent);
            }
        });


        win1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                win_checker1(p1_name,p1_rate,p1_rt_svcode,sp_1_tm1,sp_2_tm1,sp_3_tm1,sp_4_tm1,sp_5_tm1,
                    sp_6_tm1,edit);
                win_checker1(p2_name,p2_rate,p2_rt_svcode,sp_1_tm1,sp_2_tm1,sp_3_tm1,sp_4_tm1,sp_5_tm1,
                        sp_6_tm1,edit);
                win_checker1(p3_name,p3_rate,p3_rt_svcode,sp_1_tm1,sp_2_tm1,sp_3_tm1,sp_4_tm1,sp_5_tm1,
                        sp_6_tm1,edit);
                win_checker1(p4_name,p4_rate,p4_rt_svcode,sp_1_tm1,sp_2_tm1,sp_3_tm1,sp_4_tm1,sp_5_tm1,
                        sp_6_tm1,edit);
                win_checker1(p5_name,p5_rate,p5_rt_svcode,sp_1_tm1,sp_2_tm1,sp_3_tm1,sp_4_tm1,sp_5_tm1,
                        sp_6_tm1,edit);
                win_checker1(p6_name,p6_rate,p6_rt_svcode,sp_1_tm1,sp_2_tm1,sp_3_tm1,sp_4_tm1,sp_5_tm1,
                        sp_6_tm1,edit);
                win_checker1(p7_name,p7_rate,p7_rt_svcode,sp_1_tm1,sp_2_tm1,sp_3_tm1,sp_4_tm1,sp_5_tm1,
                        sp_6_tm1,edit);
                win_checker1(p8_name,p8_rate,p8_rt_svcode,sp_1_tm1,sp_2_tm1,sp_3_tm1,sp_4_tm1,sp_5_tm1,
                        sp_6_tm1,edit);
                win_checker1(p9_name,p9_rate,p9_rt_svcode,sp_1_tm1,sp_2_tm1,sp_3_tm1,sp_4_tm1,sp_5_tm1,
                        sp_6_tm1,edit);
                win_checker1(p10_name,p10_rate,p10_rt_svcode,sp_1_tm1,sp_2_tm1,sp_3_tm1,sp_4_tm1,sp_5_tm1,
                        sp_6_tm1,edit);
                win_checker1(p11_name,p11_rate,p11_rt_svcode,sp_1_tm1,sp_2_tm1,sp_3_tm1,sp_4_tm1,sp_5_tm1,
                        sp_6_tm1,edit);
                win_checker1(p12_name,p12_rate,p12_rt_svcode,sp_1_tm1,sp_2_tm1,sp_3_tm1,sp_4_tm1,sp_5_tm1,
                        sp_6_tm1,edit);

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Победа команды " + team_spinner1.getSelectedItem().toString(), Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        win2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                win_checker2(p1_name,p1_rate,p1_rt_svcode,sp_1_tm2,sp_2_tm2,sp_3_tm2,sp_4_tm2,sp_5_tm2,
                        sp_6_tm2,edit);
                win_checker2(p2_name,p2_rate,p2_rt_svcode,sp_1_tm2,sp_2_tm2,sp_3_tm2,sp_4_tm2,sp_5_tm2,
                        sp_6_tm2,edit);
                win_checker2(p3_name,p3_rate,p3_rt_svcode,sp_1_tm2,sp_2_tm2,sp_3_tm2,sp_4_tm2,sp_5_tm2,
                        sp_6_tm2,edit);
                win_checker2(p4_name,p4_rate,p4_rt_svcode,sp_1_tm2,sp_2_tm2,sp_3_tm2,sp_4_tm2,sp_5_tm2,
                        sp_6_tm2,edit);
                win_checker2(p5_name,p5_rate,p5_rt_svcode,sp_1_tm2,sp_2_tm2,sp_3_tm2,sp_4_tm2,sp_5_tm2,
                        sp_6_tm2,edit);
                win_checker2(p6_name,p6_rate,p6_rt_svcode,sp_1_tm2,sp_2_tm2,sp_3_tm2,sp_4_tm2,sp_5_tm2,
                        sp_6_tm2,edit);
                win_checker2(p7_name,p7_rate,p7_rt_svcode,sp_1_tm2,sp_2_tm2,sp_3_tm2,sp_4_tm2,sp_5_tm2,
                        sp_6_tm2,edit);
                win_checker2(p8_name,p8_rate,p8_rt_svcode,sp_1_tm2,sp_2_tm2,sp_3_tm2,sp_4_tm2,sp_5_tm2,
                        sp_6_tm2,edit);
                win_checker2(p9_name,p9_rate,p9_rt_svcode,sp_1_tm2,sp_2_tm2,sp_3_tm2,sp_4_tm2,sp_5_tm2,
                        sp_6_tm2,edit);
                win_checker2(p10_name,p10_rate,p10_rt_svcode,sp_1_tm2,sp_2_tm2,sp_3_tm2,sp_4_tm2,sp_5_tm2,
                        sp_6_tm2,edit);
                win_checker2(p11_name,p11_rate,p11_rt_svcode,sp_1_tm2,sp_2_tm2,sp_3_tm2,sp_4_tm2,sp_5_tm2,
                        sp_6_tm2,edit);
                win_checker2(p12_name,p12_rate,p12_rt_svcode,sp_1_tm2,sp_2_tm2,sp_3_tm2,sp_4_tm2,sp_5_tm2,
                        sp_6_tm2,edit);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Победа команды " + team_spinner2.getSelectedItem().toString(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });



        accept_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teams_number = pref.getInt("TeamsNum",0);
                for(int i=1;i<teams_number+1; i++){
                    String team_buffer = "Team" +i+"/name";
                    String buffer = pref.getString(team_buffer,"Null");
                    if (buffer.equals(team_spinner1.getSelectedItem().toString())){
                        for(int j = 1;j<13;j++){
                            String player_code_teams_num ="Player" + j +"/teams_num";
                            int team_num_buffer = pref.getInt(player_code_teams_num,0);
                            if(team_num_buffer == i){
                                String player_code_num_in_team = "Player" + j + "/num_in_team";
                                int num_in_team_buffer = pref.getInt(player_code_num_in_team, 0);
                                String player_code_name = "Player"+j+"/name";
                                String pos_buffer = pref.getString(player_code_name,"Другой игрок");
                                int position = adapter.getPosition(pos_buffer);
                                if(num_in_team_buffer == 1){
                                    sp_1_tm1.setSelection(position);
                                }
                                if(num_in_team_buffer == 2){
                                    sp_2_tm1.setSelection(position);
                                }
                                if(num_in_team_buffer == 3){
                                    sp_3_tm1.setSelection(position);
                                }
                                if(num_in_team_buffer == 4){
                                    sp_4_tm1.setSelection(position);
                                }
                                if(num_in_team_buffer == 5){
                                    sp_5_tm1.setSelection(position);
                                }
                                if(num_in_team_buffer == 6){
                                    sp_6_tm1.setSelection(position);
                                }
                            }

                        }
                    }


                }


                for(int i=1;i<teams_number+1; i++){
                    String team_buffer = "Team" +i+"/name";
                    String buffer = pref.getString(team_buffer,"Null");
                    if (buffer.equals(team_spinner2.getSelectedItem().toString())){
                        for(int j = 1;j<13;j++){
                            String player_code_teams_num ="Player" + j +"/teams_num";
                            int team_num_buffer = pref.getInt(player_code_teams_num,0);
                            if(team_num_buffer == i){
                                String player_code_num_in_team = "Player" + j + "/num_in_team";
                                int num_in_team_buffer = pref.getInt(player_code_num_in_team, 0);
                                String player_code_name = "Player"+j+"/name";
                                String pos_buffer = pref.getString(player_code_name,"Другой игрок");
                                int position = adapter.getPosition(pos_buffer);
                                if(num_in_team_buffer == 1){
                                    sp_1_tm2.setSelection(position);
                                }
                                if(num_in_team_buffer == 2){
                                    sp_2_tm2.setSelection(position);
                                }
                                if(num_in_team_buffer == 3){
                                    sp_3_tm2.setSelection(position);
                                }
                                if(num_in_team_buffer == 4){
                                    sp_4_tm2.setSelection(position);
                                }
                                if(num_in_team_buffer == 5){
                                    sp_5_tm2.setSelection(position);
                                }
                                if(num_in_team_buffer == 6){
                                    sp_6_tm2.setSelection(position);
                                }
                            }

                        }
                    }


                }

            }






        });
    }



 public void win_checker1(String name,int rate,String p_rt_svcode,Spinner sp_1_tm1,Spinner sp_2_tm1,Spinner sp_3_tm1,
 Spinner sp_4_tm1,Spinner sp_5_tm1,Spinner sp_6_tm1,SharedPreferences.Editor edit){
     if (name.equals(sp_1_tm1.getSelectedItem().toString()) || name.equals(sp_2_tm1.getSelectedItem().toString()) || name.equals(sp_3_tm1.getSelectedItem().toString())
             ||name.equals(sp_4_tm1.getSelectedItem().toString())||name.equals(sp_5_tm1.getSelectedItem().toString())||name.equals(sp_6_tm1.getSelectedItem().toString())){
         edit.putInt(p_rt_svcode,rate+30);
     }else{edit.putInt(p_rt_svcode,rate-30 );
     }
     edit.putInt("sp_1_tm1",0);
     edit.putInt("sp_2_tm1",0);
     edit.putInt("sp_3_tm1",0);
     edit.putInt("sp_4_tm1",0);
     edit.putInt("sp_5_tm1",0);
     edit.putInt("sp_6_tm1",0);
     edit.putInt("sp_1_tm2",0);
     edit.putInt("sp_2_tm2",0);
     edit.putInt("sp_3_tm2",0);
     edit.putInt("sp_4_tm2",0);
     edit.putInt("sp_5_tm2",0);
     edit.putInt("sp_6_tm2",0);

     edit.apply();




 }

    public void win_checker2(String name,int rate,String p_rt_svcode,Spinner sp_1_tm2,Spinner sp_2_tm2,Spinner sp_3_tm2,
                             Spinner sp_4_tm2, Spinner sp_5_tm2,Spinner sp_6_tm2,SharedPreferences.Editor edit){

        if (name.equals(sp_1_tm2.getSelectedItem().toString()) || name.equals(sp_2_tm2.getSelectedItem().toString()) || name.equals(sp_3_tm2.getSelectedItem().toString())
                ||name.equals(sp_4_tm2.getSelectedItem().toString())||name.equals(sp_5_tm2.getSelectedItem().toString())||name.equals(sp_6_tm2.getSelectedItem().toString())){
            edit.putInt(p_rt_svcode,rate+30);
        }else{edit.putInt(p_rt_svcode,rate-30 );
        }
        edit.putInt("sp_1_tm1",0);
        edit.putInt("sp_2_tm1",0);
        edit.putInt("sp_3_tm1",0);
        edit.putInt("sp_4_tm1",0);
        edit.putInt("sp_5_tm1",0);
        edit.putInt("sp_6_tm1",0);
        edit.putInt("sp_1_tm2",0);
        edit.putInt("sp_2_tm2",0);
        edit.putInt("sp_3_tm2",0);
        edit.putInt("sp_4_tm2",0);
        edit.putInt("sp_5_tm2",0);
        edit.putInt("sp_6_tm2",0);

        edit.apply();



    }

    public void pos_checker(Spinner spn,String spn_code,SharedPreferences.Editor edit){
       for(int i=1; i<13; i++){
           String num_buffer = Integer.toString(i);
           String player_code ="Player" + i +"/name";
           String name_buffer = pref.getString(player_code,"Другой игрок");

           if(name_buffer.equals(spn.getSelectedItem().toString())){
               int buffer = i -1;
               edit.putInt(spn_code,buffer);
               edit.apply();

           }
       }
    }

    public void pos_arranger(Spinner spn,String spn_code){
        int pos_buffer = pref.getInt(spn_code,12);
        spn.setSelection(pos_buffer);


    }

}

