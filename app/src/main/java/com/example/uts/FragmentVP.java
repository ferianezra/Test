package com.example.uts;

/**
 Tanggal : 20 Mei 2019
 NIM     : 10116184
 Nama    : Ferian Ezra Lisandro
 Kelas   : IF-4
 */

public interface FragmentVP {
    interface View{
        void setText(String str);
    }
    interface Presenter{
        void getText();
    }
}

