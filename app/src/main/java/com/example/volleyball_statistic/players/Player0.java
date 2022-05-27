package com.example.volleyball_statistic.players;

public class Player0 {
    public String name;
    public int number=1;
    public int U_p=1;
    public int All_p=1;
    public int N_p=All_p-U_p;
    public float Acc_p=(U_p/All_p)*100;
    public int U_n=1;
    public int All_n=1;
    public int N_n=All_n-U_n;
    public int Acc_n = (U_n/All_n)*100;
    public int U_pr=1;
    public int All_pr=1;
    public int N_pr = All_pr-U_pr;
    public int Acc_pr =(U_pr/All_pr)*100;
    public int U_sv=1;
    public int All_sv=1;
    public int N_sv=All_sv-U_sv;
    public int Acc_sv=(U_sv/All_sv)*100;
    public int rating=1;

    public Player0(String name, int number, int u_p, int all_p, int n_p, float acc_p, int u_n, int all_n, int n_n, int acc_n, int u_pr, int all_pr, int n_pr, int acc_pr, int u_sv, int all_sv, int n_sv, int acc_sv, int rating) {
        this.name = name;
        this.number = number;
        U_p = u_p;
        All_p = all_p;
        N_p = n_p;
        Acc_p = acc_p;
        U_n = u_n;
        All_n = all_n;
        N_n = n_n;
        Acc_n = acc_n;
        U_pr = u_pr;
        All_pr = all_pr;
        N_pr = n_pr;
        Acc_pr = acc_pr;
        U_sv = u_sv;
        All_sv = all_sv;
        N_sv = n_sv;
        Acc_sv = acc_sv;
        this.rating = rating;
    }


}
