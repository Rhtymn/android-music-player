package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String musicTitleData[], musicDurationData[];
    Context context;

    public MyAdapter(Context ct, String musicTitle[], String musicDuration[]) {
        context = ct;
        musicTitleData = musicTitle;
        musicDurationData = musicDuration;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.musicTitle.setText(musicTitleData[position]);
        holder.musicDuration.setText(musicDurationData[position]);
    }

    @Override
    public int getItemCount() {
        return musicTitleData.length;
    }

    public class  MyViewHolder extends RecyclerView.ViewHolder {
        TextView musicTitle, musicDuration;

        public  MyViewHolder(@NonNull View itemView) {
            super(itemView);
            musicTitle = itemView.findViewById(R.id.musicTitle);
            musicDuration = itemView.findViewById(R.id.musicDuration);
        }
    }


}
