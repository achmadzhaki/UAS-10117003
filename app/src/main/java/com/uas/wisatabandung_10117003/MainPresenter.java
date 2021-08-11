package com.uas.wisatabandung_10117003;
/*
 * Nama : Achmad Zaki
 * Kelas : IF 8
 * NIM : 10117003
 * pengerjaan : 11 Agustus 2021
 * */
public class MainPresenter {
    private MainView view;
    private User user;

    public MainPresenter(MainView view) {
        this.view = view;
    }
    public void tampildata(String nim, String nama, String kelas) {
        String data = tampilandata(nim, nama, kelas);
        user = new User();
        view.tampilkandata(user);
    }
    private String tampilandata(String nim, String nama, String kelas) {
        return nim;
    }
}
