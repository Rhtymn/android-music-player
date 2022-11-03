package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String musicTitleData[], musicDurationData[];
    int musicFileData[];
    Context context;

    public MyAdapter(Context ct, String musicTitle[], String musicDuration[], int musicFile[]) {
        context = ct;
        musicTitleData = musicTitle;
        musicDurationData = musicDuration;
        musicFileData = musicFile;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.musicTitle.setText(musicTitleData[position]);
        holder.musicDuration.setText(musicDurationData[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MusicDetailActivity.class);
                intent.putExtra("musicTitle", musicTitleData[position]);
                intent.putExtra("musicDuration", musicDurationData[position]);
                intent.putExtra("musicFile", musicFileData[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return musicTitleData.length;
    }

    public class  MyViewHolder extends RecyclerView.ViewHolder {
        TextView musicTitle, musicDuration;
        ConstraintLayout mainLayout;

        public  MyViewHolder(@NonNull View itemView) {
            super(itemView);
            musicTitle = itemView.findViewById(R.id.musicTitle);
            musicDuration = itemView.findViewById(R.id.musicDuration);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }


}
