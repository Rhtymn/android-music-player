package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MusicDetailActivity extends AppCompatActivity {

    TextView musicTitle, musicDuration;
    String musicTitleData, musicDurationData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);

        musicTitle = findViewById(R.id.detailMusicTitle);
        musicDuration = findViewById(R.id.detailMusicDuration);

        getData();
        setData();

    }

    private void getData(){
        if (getIntent().hasExtra("musicTitle") && getIntent().hasExtra("musicDuration")) {
            musicTitleData = getIntent().getStringExtra("musicTitle");
            musicDurationData = getIntent().getStringExtra("musicDuration");
        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private  void setData(){
        musicTitle.setText(musicTitleData);
        musicDuration.setText(musicDurationData);
    }
}