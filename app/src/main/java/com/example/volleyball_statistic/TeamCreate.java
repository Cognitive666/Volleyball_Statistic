package com.example.volleyball_statistic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TeamCreate extends AppCompatActivity {
    public SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_create);
        pref = getSharedPreferences("Test",MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();

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
        Button create_btn = (Button) findViewById(R.id.create_btn);
        Spinner sp_tm1 = findViewById(R.id.spinner_tm1);
        Spinner sp_tm2= findViewById(R.id.spinner_tm2);
        Spinner sp_tm3= findViewById(R.id.spinner_tm3);
        Spinner sp_tm4= findViewById(R.id.spinner_tm4);
        Spinner sp_tm5= findViewById(R.id.spinner_tm5);
        Spinner sp_tm6= findViewById(R.id.spinner_tm6);

        EditText team_name = findViewById(R.id.team_name);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, player_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_tm1.setAdapter(adapter);
        sp_tm2.setAdapter(adapter);
        sp_tm3.setAdapter(adapter);
        sp_tm4.setAdapter(adapter);
        sp_tm5.setAdapter(adapter);
        sp_tm6.setAdapter(adapter);



        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            int teams_num = pref.getInt("TeamsNum",0) + 1;
            edit.putInt("TeamsNum",teams_num);
            String buffer = Integer.toString(teams_num);
            edit.putInt("Team"+buffer+"/number",teams_num);
            edit.putString("Team"+buffer+"/name",team_name.getText().toString());
            edit.apply();

            for (int i =1;i < 13; i++){
                String name_buffer = pref.getString("Player"+i+"/name","Null");
                if(name_buffer ==sp_tm1.getSelectedItem()){
                    edit.putInt("Player"+i+"/teams_num",teams_num);
                    edit.putInt("Player"+i+"/num_in_team",1);
                }
                if(name_buffer ==sp_tm2.getSelectedItem()){
                    edit.putInt("Player"+i+"/teams_num",teams_num);
                    edit.putInt("Player"+i+"/num_in_team",2);
                }
                if(name_buffer ==sp_tm3.getSelectedItem()){
                    edit.putInt("Player"+i+"/teams_num",teams_num);
                    edit.putInt("Player"+i+"/num_in_team",3);
                }
                if(name_buffer ==sp_tm4.getSelectedItem()){
                    edit.putInt("Player"+i+"/teams_num",teams_num);
                    edit.putInt("Player"+i+"/num_in_team",4);
                }
                if(name_buffer ==sp_tm5.getSelectedItem()){
                    edit.putInt("Player"+i+"/teams_num",teams_num);
                    edit.putInt("Player"+i+"/num_in_team",5);
                }
                if(name_buffer ==sp_tm6.getSelectedItem()){
                    edit.putInt("Player"+i+"/teams_num",teams_num);
                    edit.putInt("Player"+i+"/num_in_team",6);
                }
            }
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Команда создана!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });



    }
}