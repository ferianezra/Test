package com.example.uts.fragment;

/**
 Tanggal : 20 Mei 2019
 NIM     : 10116184
 Nama    : Ferian Ezra Lisandro
 Kelas   : IF-4
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.uts.R;

public class Fragment_Profile extends Fragment {
    public Fragment_Profile() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
