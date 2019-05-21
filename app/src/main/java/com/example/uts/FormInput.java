package com.example.uts;

/**
 Tanggal : 21 Mei 2019
 NIM     : 10116184
 Nama    : Ferian Ezra Lisandro
 Kelas   : IF-4
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.uts.fragment.Fragment_Teman;
import com.example.uts.model.DbHelper;


public class FormInput extends AppCompatActivity {
    EditText txt_id, txt_nim, txt_nama, txt_kelas, txt_telp, txt_email, txt_instagram;
    Button btn_submit;
    DbHelper SQLite = new DbHelper(this);
    String id, nim, nama, kelas, telp, email, instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input);

        txt_id = (EditText) findViewById(R.id.id);
        txt_nim = (EditText) findViewById(R.id.nim);
        txt_nama = (EditText) findViewById(R.id.nama);
        txt_kelas = (EditText) findViewById(R.id.kelas);
        txt_telp = (EditText) findViewById(R.id.telp);
        txt_email = (EditText) findViewById(R.id.email);
        txt_instagram = (EditText) findViewById(R.id.instagram);
        btn_submit = (Button) findViewById(R.id.btn_save);

        id = getIntent().getStringExtra(Fragment_Teman.TAG_ID);
        nim = getIntent().getStringExtra(Fragment_Teman.TAG_NIM);
        nama = getIntent().getStringExtra(Fragment_Teman.TAG_NAMA);
        kelas = getIntent().getStringExtra(Fragment_Teman.TAG_KELAS);
        telp = getIntent().getStringExtra(Fragment_Teman.TAG_TELP);
        email = getIntent().getStringExtra(Fragment_Teman.TAG_EMAIL);
        instagram = getIntent().getStringExtra(Fragment_Teman.TAG_INSTAGRAM);


        if (id == null || id == "") {
            setTitle("Add Data");
        } else {
            setTitle("Edit Data");
            txt_id.setText(id);
            txt_nim.setText(nim);
            txt_nama.setText(nama);
            txt_kelas.setText(kelas);
            txt_telp.setText(telp);
            txt_email.setText(email);
            txt_instagram.setText(instagram);
        }

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (txt_id.getText().toString().equals("")) {
                        save();
                    } else {
                        edit();
                    }
                } catch (Exception e){
                    Log.e("Submit", e.toString());
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                blank();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void blank() {
        txt_nama.requestFocus();
        txt_id.setText(null);
        txt_nim.setText(null);
        txt_nama.setText(null);
        txt_kelas.setText(null);
        txt_telp.setText(null);
        txt_email.setText(null);
        txt_instagram.setText(null);

    }

    //SIMPAN DATA
    private void save() {
        if (String.valueOf(txt_nim.getText()).equals(null) || String.valueOf(txt_nim.getText()).equals("") ||
                String.valueOf(txt_nama.getText()).equals(null) || String.valueOf(txt_nama.getText()).equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Silahakan masukan Nim dan Nama ...", Toast.LENGTH_SHORT).show();
        } else {
            SQLite.insert(txt_nim.getText().toString().trim(), txt_nama.getText().toString().trim(),
                    txt_kelas.getText().toString().trim(), txt_telp.getText().toString().trim(),
                    txt_email.getText().toString().trim(), txt_instagram.getText().toString().trim());
            blank();
            finish();
        }
    }

    //EDIT DATA
    private void edit() {
        if (String.valueOf(txt_nim.getText()).equals(null) || String.valueOf(txt_nim.getText()).equals("") ||
                String.valueOf(txt_nama.getText()).equals(null) || String.valueOf(txt_nama.getText()).equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please input name or address ...", Toast.LENGTH_SHORT).show();
        } else {
            SQLite.update(Integer.parseInt(txt_id.getText().toString().trim()), txt_nim.getText().toString().trim(),
                    txt_nama.getText().toString().trim(), txt_kelas.getText().toString().trim(), txt_telp.getText().toString().trim(),
                    txt_email.getText().toString().trim(), txt_instagram.getText().toString().trim());
            blank();
            finish();
        }
    }
}