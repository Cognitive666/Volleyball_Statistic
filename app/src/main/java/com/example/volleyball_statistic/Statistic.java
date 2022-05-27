package com.example.volleyball_statistic;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math.*;
import android.content.SharedPreferences;
import android.icu.number.Precision;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Statistic extends AppCompatActivity {
    private SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        pref = getSharedPreferences("Test", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        Spinner spn =(Spinner) findViewById(R.id.spinner);
        Button btn =(Button) findViewById(R.id.output_btn);
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
    }

    public void func(String name,TextView rating,TextView Acc_p,TextView Acc_u,TextView U_pr,TextView Acc_sv,String code,Spinner spn){
        if(spn.getSelectedItem().toString().equals(name)){
            SharedPreferences.Editor edit = pref.edit();
            String text_buffer ="";
            double U_p =pref.getInt(code+"/U_p",1000);



            double All_p = pref.getInt(code+"/All_p",1000);


          if (All_p !=0){
            double acc_p =(U_p/All_p)*100;
            text_buffer = "Точность подач:" + Double.toString(Math.round(acc_p)) +"%";
            Acc_p.setText(text_buffer);
          }else{
              //Acc_p.setText(Acc_p.getText()+"-");
          }
          int rate = pref.getInt(code+"/rating",0);
          text_buffer = Integer.toString(rate);
          rating.setText("Рейтинг:" + text_buffer);
          double U_u =pref.getInt(code+"/U_u",1000);
          double All_u =pref.getInt(code+"/All_u",1000);
          double acc_u= (U_u/All_u)*100;
          text_buffer="Точность ударов:"+Double.toString(Math.round(acc_u))+"%";
          Acc_u.setText(text_buffer);
          double U_sv =pref.getInt(code+"/U_sv",1000);
          double All_sv =pref.getInt(code+"/All_sv",1000);
          double acc_sv =(U_sv/All_sv)*100;
          text_buffer="Точность связок:"+Double.toString(Math.round(acc_sv))+"%";
          Acc_sv.setText(text_buffer);
          double u_pr =pref.getInt(code+"/U_pr",1000);
          double All_pr =pref.getInt(code+"/All_pr",1000);
          double acc_pr =(u_pr/All_pr)*100;
          text_buffer="Точность приёмов:"+Double.toString(Math.round(acc_pr))+"%";
          U_pr.setText(text_buffer);



        }
    }

}