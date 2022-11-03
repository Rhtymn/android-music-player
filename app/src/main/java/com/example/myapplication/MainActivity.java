package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String musicTitle[], musicDuration[];
    int musicFile[] = {R.raw.ts_daylight, R.raw.ts_gorgeous, R.raw.ts_love_story, R.raw.ts_style};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        musicTitle = getResources().getStringArray(R.array.music_title);
        musicDuration = getResources().getStringArray(R.array.music_duration);

        MyAdapter myAdapter = new MyAdapter(this, musicTitle, musicDuration, musicFile);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}