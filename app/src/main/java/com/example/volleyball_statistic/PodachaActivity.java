package com.example.volleyball_statistic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class PodachaActivity extends AppCompatActivity {
    public SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podacha);
        pref = getSharedPreferences("Test", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
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

        Button sv_btn = (Button) findViewById(R.id.save_btn);
        String[] player_list = {p1_name, p2_name, p3_name, p4_name, p5_name, p6_name, p7_name, p8_name, p9_name, p10_name, p11_name, p12_name, "Другой игрок"};
        String[] p_spn = {"Удачная", "Неудачная"};
        String[] player_list_pr = {"Никто", p1_name, p2_name, p3_name, p4_name, p5_name, p6_name, p7_name, p8_name, p9_name, p10_name, p11_name, p12_name, "Другой игрок"};
        String[] pr_spn = {"Удачный", "Неудачный"};

        ArrayAdapter<String> adapter_p_name = new ArrayAdapter(this, android.R.layout.simple_spinner_item, player_list);
        adapter_p_name.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter_p_udnd = new ArrayAdapter(this, android.R.layout.simple_spinner_item, p_spn);
        adapter_p_udnd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter_pr_name = new ArrayAdapter(this, android.R.layout.simple_spinner_item, player_list_pr);
        adapter_pr_name.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter_pr_udnd = new ArrayAdapter(this, android.R.layout.simple_spinner_item, pr_spn);
        adapter_pr_udnd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner p_names = (Spinner) findViewById(R.id.p_names_spnr);
        p_names.setAdapter(adapter_p_name);
        Spinner pr_names = (Spinner) findViewById(R.id.pr_names_spn);
        pr_names.setAdapter(adapter_pr_name);
        Spinner p_udnd = (Spinner) findViewById(R.id.p_udnd_spn);
        p_udnd.setAdapter(adapter_p_udnd);
        Spinner pr_udnd = (Spinner) findViewById(R.id.pr_udnd_spn);
        pr_udnd.setAdapter(adapter_pr_udnd);
        sv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(edit,p1_name,p_names,p_udnd,"Player1/U_p","Player1/N_p","Player1/All_p"  );
                check_pr(edit,p1_name,pr_names,pr_udnd,"Player1/U_pr","Player1/N_pr","Player1/All_pr");
                check(edit,p2_name,p_names,p_udnd,"Player2/U_p","Player2/N_p","Player2/All_p"  );
                check_pr(edit,p2_name,pr_names,pr_udnd,"Player2/U_pr","Player2/N_pr","Player2/All_pr");
                check(edit,p3_name,p_names,p_udnd,"Player3/U_p","Player3/N_p","Player3/All_p"  );
                check_pr(edit,p3_name,pr_names,pr_udnd,"Player3/U_pr","Player3/N_pr","Player3/All_pr");
                check(edit,p4_name,p_names,p_udnd,"Player4/U_p","Player4/N_p","Player4/All_p"  );
                check_pr(edit,p4_name,pr_names,pr_udnd,"Player4/U_pr","Player4/N_pr","Player4/All_pr");
                check(edit,p5_name,p_names,p_udnd,"Player5/U_p","Player5/N_p","Player5/All_p"  );
                check_pr(edit,p5_name,pr_names,pr_udnd,"Player5/U_pr","Player5/N_pr","Player5/All_pr");
                check(edit,p6_name,p_names,p_udnd,"Player6/U_p","Player6/N_p","Player6/All_p"  );
                check_pr(edit,p6_name,pr_names,pr_udnd,"Player6/U_pr","Player6/N_pr","Player6/All_pr");
                check(edit,p7_name,p_names,p_udnd,"Player7/U_p","Player7/N_p","Player7/All_p"  );
                check_pr(edit,p7_name,pr_names,pr_udnd,"Player7/U_pr","Player7/N_pr","Player7/All_pr");
                check(edit,p8_name,p_names,p_udnd,"Player8/U_p","Player8/N_p","Player8/All_p"  );
                check_pr(edit,p8_name,pr_names,pr_udnd,"Player8/U_pr","Player8/N_pr","Player8/All_pr");
                check(edit,p9_name,p_names,p_udnd,"Player9/U_p","Player9/N_p","Player9/All_p"  );
                check_pr(edit,p9_name,pr_names,pr_udnd,"Player9/U_pr","Player9/N_pr","Player9/All_pr");
                check(edit,p10_name,p_names,p_udnd,"Player10/U_p","Player10/N_p","Player10/All_p"  );
                check_pr(edit,p10_name,pr_names,pr_udnd,"Player10/U_pr","Player10/N_pr","Player10/All_pr");
                check(edit,p11_name,p_names,p_udnd,"Player11/U_p","Player11/N_p","Player11/All_p"  );
                check_pr(edit,p11_name,pr_names,pr_udnd,"Player11/U_pr","Player11/N_pr","Player11/All_pr");
                check(edit,p12_name,p_names,p_udnd,"Player12/U_p","Player12/N_p","Player12/All_p"  );
                check_pr(edit,p12_name,pr_names,pr_udnd,"Player12/U_pr","Player12/N_pr","Player12/All_pr");
                Intent intent = new Intent(PodachaActivity.this,Game.class);
                startActivity(intent);
            }
        });
    }

    public void check(SharedPreferences.Editor edit, String p_name,  Spinner p_names,  Spinner p_udhd,  String up_code,   String np_code, String all_p) {

        if (p_names.getSelectedItem().toString().equals(p_name)) {
            int p =pref.getInt(all_p,1);
            p+=1;
            edit.putInt(all_p, p);
            edit.apply();
            if (p_udhd.getSelectedItem().toString().equals("Удачная")) {
                p =pref.getInt(up_code,0);
                p+=1;
                edit.putInt(up_code, p);
                edit.apply();
            }
            if (p_udhd.getSelectedItem().toString().equals("Неудачная")) {
                p =pref.getInt(np_code,0);
                p+=1;
                edit.putInt(np_code, p);
                edit.apply();
            }
        }


    }

    public void check_pr(SharedPreferences.Editor edit, String pr_name, Spinner pr_names, Spinner pr_udhd, String upr_code, String npr_code, String all_pr) {
        if (pr_names.getSelectedItem().toString().equals(pr_name)) {
            edit.putInt(all_pr, +1);
            edit.apply();
            if (pr_udhd.getSelectedItem().toString().equals("Удачный")) {
                int buffer = pref.getInt(upr_code,10000);
                buffer+=1;
                edit.putInt(upr_code, buffer);
                buffer = pref.getInt(all_pr,1000);
                buffer+=1;
                edit.putInt(all_pr,buffer);
                edit.apply();
            }
            if (pr_udhd.getSelectedItem().toString().equals("Неудачный")) {
                int buffer = pref.getInt(all_pr,1000);
                buffer+=1;
                edit.putInt(all_pr,buffer);
                edit.apply();
            }
        }
    }
}
