package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MusicDetailActivity extends AppCompatActivity {

    private TextView musicTitle, musicDuration;
    private String musicTitleData, musicDurationData;
    private Button playBtn, stopBtn;
    int musicFileData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);

        musicTitle = findViewById(R.id.detailMusicTitle);
        musicDuration = findViewById(R.id.detailMusicDuration);
        playBtn = findViewById(R.id.btn_play);
        stopBtn = findViewById(R.id.btn_stop);

        getData();
        setData();

    }

    private void getData(){
        if (getIntent().hasExtra("musicTitle") && getIntent().hasExtra("musicDuration")) {
            musicTitleData = getIntent().getStringExtra("musicTitle");
            musicDurationData = getIntent().getStringExtra("musicDuration");
            musicFileData = getIntent().getIntExtra("musicFile", 1);
        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private  void setData(){
        musicTitle.setText(musicTitleData);
        musicDuration.setText(musicDurationData);
    }
}