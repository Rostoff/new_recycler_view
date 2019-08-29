package com.hogsty.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class NewActivity extends AppCompatActivity {

    private TextView name;
    private TextView pname;
    private TextView pBirthDate;
    private TextView pPortablePhone;
    private ImageView pProfilImage;
    private String formatDate;
    Element element;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        this.configureToolbar();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Intent intent = getIntent();
        Element element = intent.getParcelableExtra("element");
        System.out.println("resultat prenom: "+element.getPname());

        name = findViewById(R.id.name);
        pname = findViewById(R.id.pname);
        pBirthDate = findViewById(R.id.birthdate);
        pPortablePhone = findViewById(R.id.portable_phone);
        pProfilImage = findViewById(R.id.profil_image);

        name.setText(element.getName());
        pname.setText(element.getPname());
        formatDate = element.getBirthDate().toString();
        pBirthDate.setText(element.getBirthDate().toString());
        pPortablePhone.setText(element.getPortablePhone());
    }





    private void configureToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
    }

}
