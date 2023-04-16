package com.example.growknowledge;

import static com.example.growknowledge.R.color.blue;
import static com.example.growknowledge.R.drawable.background;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ContentClass> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#5E40E6"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        arrayList.add(new ContentClass(R.drawable.history,"History"));
        arrayList.add(new ContentClass(R.drawable.georaphy,"Geography"));
        arrayList.add(new ContentClass(R.drawable.science,"Science"));
        arrayList.add(new ContentClass(R.drawable.art,"Literature"));
        arrayList.add(new ContentClass(R.drawable.health,"Health"));
        arrayList.add(new ContentClass(R.drawable.sports,"Sports"));
        arrayList.add(new ContentClass(R.drawable.india,"India"));
        arrayList.add(new ContentClass(R.drawable.world,"World"));
        AdapterClass adapterClass=new AdapterClass(this,arrayList);
        recyclerView.setAdapter(adapterClass);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}