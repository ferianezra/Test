package com.example.uts.fragment;

/**
 Tanggal : 20-21 Mei 2019
 NIM     : 10116184
 Nama    : Ferian Ezra Lisandro
 Kelas   : IF-4
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.uts.FragmentVP;
import com.example.uts.R;

public class Fragment_Kontak extends Fragment {

    private FragmentVP.Presenter presenter;
    TextView textViewInstagram, textViewLine, textViewGmail;

    public Fragment_Kontak() {}

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragement_kontak = inflater.inflate(R.layout.fragment_kontak, container, false);
        textViewInstagram = fragement_kontak.findViewById(R.id.instagram);
        textViewLine = fragement_kontak.findViewById(R.id.line);
        textViewGmail = fragement_kontak.findViewById(R.id.gmail);

        textViewInstagram.setMovementMethod(LinkMovementMethod.getInstance());
        textViewLine.setMovementMethod(LinkMovementMethod.getInstance());
        textViewGmail.setMovementMethod(LinkMovementMethod.getInstance());

        return fragement_kontak;
    }
}