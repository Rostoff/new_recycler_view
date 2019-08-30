package com.hogsty.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements MyElementAdapter.OnNoteListener {

    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private List<Element> myElements;
    private MyElementAdapter myElementAdapter;
    private Element element;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        this.configureToolbar();

        // Je récupère la RecyclerView déclarée précédemment dans notre activity_mail.xml via la
        // méthode findViewById() et je l’affecte à ma variable recyclerView
        recyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);

        // On instancie la liste de jeux
        myElements = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            myElements.add(new Element("COUCHY", "Christophe", dateFormat.parse("23/06/1981"), "0674944590","0149360101","christophe.couchy@gmail.com","Ceci est ma fiche perso", R.drawable.duracell, R.drawable.arrow_right));
            myElements.add(new Element("LEMON", "Bob", dateFormat.parse("20/01/1985"), "0123456789","0149360101","christophe.couchy@gmail.com","Ceci est ma fiche perso2", R.drawable.laptop, R.drawable.arrow_right));
            myElements.add(new Element("HUDSON", "Paul", dateFormat.parse("13/07/1990"), "0666999500","0149360101","christophe.couchy@gmail.com","Ceci est ma fiche perso3", R.drawable.mouse, R.drawable.arrow_right));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        myElementAdapter = new MyElementAdapter(myElements, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //Ici on utilise la méthode setAdapter pour lier l'adapter à la liste
        recyclerView.setAdapter(myElementAdapter);

//        //Initialisationd e la base de données Realm.is
//        Realm.init(context);
//
//        //Creation d'une instance de Realm
//        Realm realm = Realm.getDefaultInstance();
//
//        //Requête Realm pour tout les éléments
//        final RealmResults<Element> elementQuery = realm.where(Element.class).equalTo("name", "COUCHY").findAll();
//        elementQuery.size();
//        System.out.println("Le nombre d'éléments correspondant est " + elementQuery.size());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    private void configureToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.parameters:
                Intent intent = new Intent(this, ParametersActivity.class);
                startActivity(intent);
            default:
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
        public void onNoteClick(int position) {

        this.element = myElements.get(position);

            Intent intent = new Intent(this, NewActivity.class);
            intent.putExtra("element", element);
            startActivity(intent);

            //Log.d(TAG, "onNoteClick: clicked." + myElements.get(position).getName() + " et " + myElements.get(position).getDescription());
        }
    }
