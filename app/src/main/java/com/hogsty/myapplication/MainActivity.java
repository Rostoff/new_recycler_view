package com.hogsty.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyElementAdapter.OnNoteListener {

    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private List<Element> myElements;
    private MyElementAdapter myElementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Je récupère la RecyclerView déclarée précédemment dans notre activity_mail.xml via la
        // méthode findViewById() et je l’affecte à ma variable recyclerView
        recyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);

        // On instancie la liste de jeux
        myElements = new ArrayList<>();
        myElements.add(new Element("Element cool", "Cet élement est très cool parce que", R.drawable.keyboard, R.drawable.arrow_right));
        myElements.add(new Element("Element nul", "Cet élement est complètement naze et voilà", R.drawable.laptop, R.drawable.arrow_right));
        myElements.add(new Element("Element standard", "Cet élement est très standard", R.drawable.mouse, R.drawable.arrow_right));

        myElementAdapter = new MyElementAdapter(myElements, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //Ici on utilise la méthode setAdapter pour lier l'adapter à la liste
        recyclerView.setAdapter(myElementAdapter);
    }

        @Override
        public void onNoteClick(int position) {
            //myElements.get(position);

//            Intent intent = new Intent(this, NewActivity.class);
//            intent.putExtra("some_object", "something_else");
//            startActivity(intent);

            Log.d(TAG, "onNoteClick: clicked." + position);
        }
    }
