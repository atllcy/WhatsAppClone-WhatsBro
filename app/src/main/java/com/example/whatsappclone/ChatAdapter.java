package com.example.whatsappclone;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private String[] chatNames;
    private int[] imageResourceIDs;
    private String[] chatMessages;
    private String[] timeStamps;
    private Context context;

    public ChatAdapter(Context context, String[] chatNames, int[] imageResourceIDs, String[] chatMessages, String[] timeStamps) {
        this.context = context;
        this.chatNames = chatNames;
        this.imageResourceIDs = imageResourceIDs;
        this.chatMessages = chatMessages;
        this.timeStamps = timeStamps;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_chat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(chatNames[position]);
        holder.images.setImageResource(imageResourceIDs[position]);
        holder.chat.setText(chatMessages[position]);
        holder.time.setText(timeStamps[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RecyclerView", "Item clicked: " + position);
                // Tambahkan logika atau tindakan yang diinginkan saat item diklik di sini
            }
        });
    }

    @Override
    public int getItemCount() {
        return chatNames.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView name;
        TextView chat;
        TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.images);
            name = itemView.findViewById(R.id.name);
            chat = itemView.findViewById(R.id.chat);
            time = itemView.findViewById(R.id.time);
        }
    }
}
