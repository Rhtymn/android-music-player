package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SoundService extends Service {
    MediaPlayer musicPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public static int currentMusic = 0;

    public int onStartCommand(Intent intent, int flags, int startId) {
        int musicFile = intent.getIntExtra("musicFile", 1);
        if (musicPlayer == null) {
            setPlayingSong(musicFile);
            currentMusic = musicFile;
            Toast.makeText(this, "Music Service started", Toast.LENGTH_LONG).show();
        } else if (musicPlayer.isPlaying() && currentMusic != musicFile) {
            stopPlayer();
            setPlayingSong(musicFile);
            currentMusic = musicFile;
            Toast.makeText(this, "Music Service started", Toast.LENGTH_LONG).show();
        }
        musicPlayer.start();
        return START_STICKY;
    }

    public void onDestroy() {
        super.onDestroy();
        stopPlayer();
        currentMusic = 0;
        Toast.makeText(this, "Music service destroyed", Toast.LENGTH_LONG).show();
    }

    private void stopPlayer() {
        if (musicPlayer != null) {
            musicPlayer.release();
            musicPlayer = null;
        }
    }

    private void setPlayingSong(int musicFile){
        musicPlayer = MediaPlayer.create(this, musicFile);
        musicPlayer.setLooping(false);
        musicPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopPlayer();
                stopSelf();
            }
        });
    }
}
