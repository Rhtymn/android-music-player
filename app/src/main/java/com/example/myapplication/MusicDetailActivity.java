package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MusicDetailActivity extends AppCompatActivity {
    MediaPlayer player;
    private TextView musicTitle, musicDuration;
    private String musicTitleData, musicDurationData;
    int musicFileData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);

        musicTitle = findViewById(R.id.detailMusicTitle);
        musicDuration = findViewById(R.id.detailMusicDuration);
        player = MediaPlayer.create(this, R.raw.ts_daylight);

        Button playBtn = findViewById(R.id.btn_play);
        Button stopBtn = findViewById(R.id.btn_stop);
        Button pauseBtn = findViewById(R.id.btn_pause);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(view);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop(view);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause(view);
            }
        });
        getData();
        setData();
    }

    private void getData(){
        if (getIntent().hasExtra("musicTitle") && getIntent().hasExtra("musicDuration") && getIntent().hasExtra("musicFile")) {
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

    public void play(View view) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.ts_daylight);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View view) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View view) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}