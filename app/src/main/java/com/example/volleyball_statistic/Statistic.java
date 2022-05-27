package com.example.volleyball_statistic;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math.*;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.number.Precision;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Statistic extends AppCompatActivity {
    private SharedPreferences pref;
    int counter =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        pref = getSharedPreferences("Test", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        Spinner spn =(Spinner) findViewById(R.id.spinner);
        Button btn =(Button) findViewById(R.id.output_btn);
        Button exit_btn = (Button) findViewById(R.id.exit_btn);
        Button null_stat_btn =(Button) findViewById(R.id.null_btn);
        TextView Rating =(TextView) findViewById(R.id.rating);
        TextView Acc_p =(TextView) findViewById(R.id.Acc_p);
        TextView U_pr =(TextView) findViewById(R.id.U_pr);
        TextView  Acc_sv=(TextView) findViewById(R.id.Acc_sv);
        TextView Acc_u =(TextView) findViewById(R.id.Acc_u);
      String p1_name = pref.getString("Player1/name", "void");

      String p2_name = pref.getString("Player2/name", "void");

      String p3_name = pref.getString("Player3/name", "void");

      String p4_name = pref.getString("Player4/name", "void");

      String p5_name = pref.getString("Player5/name", "void");

      String p6_name = pref.getString("Player6/name", "void");

       String p7_name = pref.getString("Player7/name", "void");

       String p8_name = pref.getString("Player8/name", "void");

       String p9_name = pref.getString("Player9/name", "void");

       String p10_name = pref.getString("Player10/name", "void");

       String p11_name = pref.getString("Player11/name", "void");

       String p12_name = pref.getString("Player12/name", "void");
       String[] player_list = {p1_name, p2_name, p3_name, p4_name,p5_name, p6_name, p7_name, p8_name, p9_name, p10_name, p11_name, p12_name};
       ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, player_list);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spn.setAdapter(adapter);
      btn.setOnClickListener(new View.OnClickListener() {
         @Override
          public void onClick(View view) {
           func(p1_name,Rating,Acc_p,Acc_u,U_pr,Acc_sv,"Player1",spn);
           func(p2_name,Rating,Acc_p,Acc_u,U_pr,Acc_sv,"Player2",spn);
           func(p3_name,Rating,Acc_p,Acc_u,U_pr,Acc_sv,"Player3",spn);
           func(p4_name,Rating,Acc_p,Acc_u,U_pr,Acc_sv,"Player4",spn);
           func(p5_name,Rating,Acc_p,Acc_u,U_pr,Acc_sv,"Player5",spn);
           func(p6_name,Rating,Acc_p,Acc_u,U_pr,Acc_sv,"Player6",spn);
           func(p7_name,Rating,Acc_p,Acc_u,U_pr,Acc_sv,"Player7",spn);
           func(p8_name,Rating,Acc_p,Acc_u,U_pr,Acc_sv,"Player8",spn);
           func(p9_name,Rating,Acc_p,Acc_u,U_pr,Acc_sv,"Player9",spn);
           func(p10_name,Rating,Acc_p,Acc_u,U_pr,Acc_sv,"Player10",spn);
           func(p11_name,Rating,Acc_p,Acc_u,U_pr,Acc_sv,"Player11",spn);
           func(p12_name,Rating,Acc_p,Acc_u,U_pr,Acc_sv,"Player12",spn);
       }
   });

      exit_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(Statistic.this,Menu.class);
              startActivity(intent);
          }
      });

      null_stat_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              null_stat("Player1",spn,edit);
              null_stat("Player2",spn,edit);
              null_stat("Player3",spn,edit);
              null_stat("Player4",spn,edit);
              null_stat("Player5",spn,edit);
              null_stat("Player6",spn,edit);
              null_stat("Player7",spn,edit);
              null_stat("Player8",spn,edit);
              null_stat("Player9",spn,edit);
              null_stat("Player10",spn,edit);
              null_stat("Player11",spn,edit);
              null_stat("Player12",spn,edit);
              Rating.setText("Рейтинг:");
              Acc_sv.setText("Точность связок:");
              Acc_p.setText("Точность подач:");
              U_pr.setText("Точность приёмов:");
              Acc_u.setText("Точность ударов:");


          }
      });


    }

    public void func(String name,TextView rating,TextView Acc_p,TextView Acc_u,TextView U_pr,TextView Acc_sv,String code,Spinner spn){

        if(spn.getSelectedItem().toString().equals(name)){
            SharedPreferences.Editor edit = pref.edit();
            String text_buffer ="";
            double U_p =pref.getInt(code+"/U_p",0);



            double All_p = pref.getInt(code+"/All_p",0);

          if (All_p !=0){
            double acc_p =(U_p/All_p)*100;
            text_buffer = "Точность подач:" + Double.toString(Math.round(acc_p)) +"%";
            Acc_p.setText(text_buffer);
          }else{
              if (counter ==0) {
                  String buffer = Acc_p.getText().toString() + "0%";
                  Acc_p.setText(buffer);
                  counter += 1;
              }
          }
          int rate = pref.getInt(code+"/rating",0);
          text_buffer = Integer.toString(rate);
          rating.setText("Рейтинг:" + text_buffer);
          double U_u =pref.getInt(code+"/U_u",0);
          double All_u =pref.getInt(code+"/All_u",0);
          double acc_u= (U_u/All_u)*100;
          text_buffer="Точность ударов:"+Double.toString(Math.round(acc_u))+"%";
          Acc_u.setText(text_buffer);
          double U_sv =pref.getInt(code+"/U_sv",0);
          double All_sv =pref.getInt(code+"/All_sv",0);
          double acc_sv =(U_sv/All_sv)*100;
          text_buffer="Точность связок:"+Double.toString(Math.round(acc_sv))+"%";
          Acc_sv.setText(text_buffer);
          double u_pr =pref.getInt(code+"/U_pr",0);
          double All_pr =pref.getInt(code+"/All_pr",0);
          double acc_pr =(u_pr/All_pr)*100;
          text_buffer="Точность приёмов:"+Double.toString(Math.round(acc_pr))+"%";
          U_pr.setText(text_buffer);



        }
    }
    public void null_stat(String player_code,Spinner spn,SharedPreferences.Editor edit){
        String buffer = player_code+"/name";
        String player_name = pref.getString(buffer,"Null");
        if (player_name.equals(spn.getSelectedItem().toString())){
            buffer = player_code + "/rating";
            edit.putInt(buffer,0);
            buffer = player_code + "/U_u";
            edit.putInt(buffer,0);
            buffer = player_code + "/All_u";
            edit.putInt(buffer,0);
            buffer = player_code +"/U_p";
            edit.putInt(buffer,0);
            buffer = player_code + "/All_p";
            edit.putInt(buffer,0);
            buffer = player_code +"/U_pr";
            edit.putInt(buffer,0);
            buffer = player_code + "/All_pr";
            edit.putInt(buffer,0);
            buffer = player_code +"/U_sv";
            edit.putInt(buffer,0);
            buffer = player_code + "/All_sv";
            edit.putInt(buffer,0);
            edit.apply();
            counter = 0;

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Статистика игрока " + player_name + " аннулирована!", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

}