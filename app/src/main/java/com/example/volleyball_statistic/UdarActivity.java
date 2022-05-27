package com.example.volleyball_statistic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class UdarActivity extends AppCompatActivity {

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
        String[] p_spn = {"Удачный", "Неудачный"};
        String[] player_list_pr = {"Никто", p1_name, p2_name, p3_name, p4_name, p5_name, p6_name, p7_name, p8_name, p9_name, p10_name, p11_name, p12_name, "Другой игрок"};
        String[] pr_spn = {"Удачная", "Неудачная"};

        ArrayAdapter<String> adapter_p_name = new ArrayAdapter(this, android.R.layout.simple_spinner_item, player_list);
        adapter_p_name.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter_p_udnd = new ArrayAdapter(this, android.R.layout.simple_spinner_item, p_spn);
        adapter_p_udnd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter_pr_name = new ArrayAdapter(this, android.R.layout.simple_spinner_item, player_list_pr);
        adapter_pr_name.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter_pr_udnd = new ArrayAdapter(this, android.R.layout.simple_spinner_item, pr_spn);
        adapter_pr_udnd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner u_names = (Spinner) findViewById(R.id.p_names_spnr);
        u_names.setAdapter(adapter_p_name);
        Spinner sv_names = (Spinner) findViewById(R.id.pr_names_spn);
        sv_names.setAdapter(adapter_pr_name);
        Spinner u_udnd = (Spinner) findViewById(R.id.p_udnd_spn);
        u_udnd.setAdapter(adapter_p_udnd);
        Spinner sv_udnd = (Spinner) findViewById(R.id.pr_udnd_spn);
        sv_udnd.setAdapter(adapter_pr_udnd);
        sv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(edit,p1_name,u_names,u_udnd,"Player1/U_u","Player1/N_u","Player1/All_u"  );
                check_pr(edit,p1_name,sv_names,sv_udnd,"Player1/U_sv","Player1/N_sv","Player1/All_sv");
                check(edit,p2_name,u_names,u_udnd,"Player2/U_u","Player2/N_u","Player2/All_u"  );
                check_pr(edit,p2_name,sv_names,sv_udnd,"Player2/U_sv","Player2/N_sv","Player2/All_sv");
                check(edit,p3_name,u_names,u_udnd,"Player3/U_u","Player3/N_u","Player3/All_u"  );
                check_pr(edit,p3_name,sv_names,sv_udnd,"Player3/U_sv","Player3/N_sv","Player3/All_sv");
                check(edit,p4_name,u_names,u_udnd,"Player4/U_u","Player4/N_u","Player4/All_u"  );
                check_pr(edit,p4_name,sv_names,sv_udnd,"Player4/U_sv","Player4/N_sv","Player4/All_sv");
                check(edit,p5_name,u_names,u_udnd,"Player5/U_u","Player5/N_u","Player5/All_u"  );
                check_pr(edit,p5_name,sv_names,sv_udnd,"Player5/U_sv","Player5/N_sv","Player5/All_sv");
                check(edit,p6_name,u_names,u_udnd,"Player6/U_u","Player6/N_u","Player6/All_u"  );
                check_pr(edit,p6_name,sv_names,sv_udnd,"Player6/U_sv","Player6/N_sv","Player6/All_sv");
                check(edit,p7_name,u_names,u_udnd,"Player7/U_u","Player7/N_u","Player7/All_u"  );
                check_pr(edit,p7_name,sv_names,sv_udnd,"Player7/U_sv","Player7/N_sv","Player7/All_sv");
                check(edit,p8_name,u_names,u_udnd,"Player8/U_u","Player8/N_u","Player8/All_u"  );
                check_pr(edit,p8_name,sv_names,sv_udnd,"Player8/U_sv","Player8/N_sv","Player8/All_sv");
                check(edit,p9_name,u_names,u_udnd,"Player9/U_u","Player9/N_u","Player9/All_u"  );
                check_pr(edit,p9_name,sv_names,sv_udnd,"Player9/U_sv","Player9/N_sv","Player9/All_sv");
                check(edit,p10_name,u_names,u_udnd,"Player10/U_u","Player10/N_u","Player10/All_u"  );
                check_pr(edit,p10_name,sv_names,sv_udnd,"Player10/U_sv","Player10/N_sv","Player10/All_sv");
                check(edit,p11_name,u_names,u_udnd,"Player11/U_u","Player11/N_u","Player11/All_u"  );
                check_pr(edit,p11_name,sv_names,sv_udnd,"Player11/U_sv","Player11/N_sv","Player11/All_sv");
                check(edit,p12_name,u_names,u_udnd,"Player12/U_u","Player12/N_u","Player12/All_u"  );
                check_pr(edit,p12_name,sv_names,sv_udnd,"Player12/U_sv","Player12/N_sv","Player12/All_sv");
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Статистика игрока записана!", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(UdarActivity.this,Game.class);
                startActivity(intent);
            }
        });
    }

    public void check(SharedPreferences.Editor edit, String p_name,  Spinner p_names,  Spinner u_udhd,  String up_code,   String np_code, String all_u) {

        if (p_names.getSelectedItem().toString().equals(p_name)) {
            edit.putInt(all_u, +1);
            if (u_udhd.getSelectedItem().toString().equals("Удачный")) {
                int buffer = pref.getInt(up_code,1000);
                buffer+=1;
                edit.putInt(up_code, buffer);
                buffer = pref.getInt(all_u,1000);
                buffer+=1;
                edit.putInt(up_code, buffer);
                edit.apply();
            }
            if (u_udhd.getSelectedItem().toString().equals("Неудачный")) {
                int buffer = pref.getInt(all_u,1000);
                buffer+=1;
                edit.putInt(all_u, buffer);
                edit.apply();
            }
        }


    }

    public void check_pr(SharedPreferences.Editor edit, String pr_name, Spinner pr_names, Spinner sv_udhd, String usv_code, String nsv_code, String all_sv) {
        if (pr_names.getSelectedItem().toString().equals(pr_name)) {
            edit.putInt(all_sv, +1);
            if (sv_udhd.getSelectedItem().toString().equals("Удачная")) {
                int buffer = pref.getInt(usv_code,1000);
                buffer+=1;
                edit.putInt(usv_code, buffer);
                buffer =pref.getInt(all_sv,1000);
                buffer+=1;
                edit.putInt(all_sv,buffer);
                edit.apply();
            }
            if (sv_udhd.getSelectedItem().toString().equals("Неудачная")) {
                int buffer = pref.getInt(all_sv,1000);
                buffer+=1;
                edit.putInt(all_sv, buffer);
                edit.apply();
            }
        }
    }
}

