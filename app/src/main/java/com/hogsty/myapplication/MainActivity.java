package com.hogsty.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Element> myElements;
    private MyElementAdapter myElementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);

        myElements = new ArrayList<>();

        myElements.add(new Element("Element cool", "Cet élement est très cool parce que", R.drawable.keyboard, R.drawable.arrow_right));
        myElements.add(new Element("Element nul", "Cet élement est complètement naze et voilà", R.drawable.laptop, R.drawable.arrow_right));
        myElements.add(new Element("Element standard", "Cet élement est très standard", R.drawable.mouse, R.drawable.arrow_right));

        myElementAdapter = new MyElementAdapter(myElements);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(myElementAdapter);
    }
}
