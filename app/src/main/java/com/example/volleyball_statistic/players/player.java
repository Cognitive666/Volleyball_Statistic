package com.example.volleyball_statistic.players;



public class player {
    public String id, name;

    public int U_p;
    public int All_p;
    public int N_p;
    public float Acc_p;
    public int U_n;
    public int All_n;
    public int N_n;
    public int Acc_n;
    public int U_pr;
    public int All_pr;
    public int N_pr;
    public int Acc_pr;
    public int U_sv;
    public int All_sv;
    public int N_sv;
    public int Acc_sv;
    public int rating;


    public player() {
    }

    public player(String id, String name, int u_p, int all_p, int n_p, float acc_p, int u_n, int all_n, int n_n, int acc_n, int u_pr, int all_pr, int n_pr, int acc_pr, int u_sv, int all_sv, int n_sv, int acc_sv, int rating) {
        this.id = id;
        this.name = name;
        this.U_p = u_p;
        this.All_p = all_p;
        this.N_p = n_p;
    this.Acc_p = acc_p;
    this.U_n = u_n;
    this.All_n = all_n;
    this.N_n = n_n;
    this.Acc_n = acc_n;
    this.U_pr = u_pr;
    this.All_pr = all_pr;
    this.N_pr = n_pr;
    this.Acc_pr = acc_pr;
    this.U_sv = u_sv;
    this.All_sv = all_sv;
    this.N_sv = n_sv;
    this.Acc_sv = acc_sv;
        this.rating = rating;
    }
}
