package com.example.whatsappclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class CallAdapter extends RecyclerView.Adapter<CallAdapter.ViewHolder> {
    private Context context;
    private String[] callNames;
    private int[] imageResourceIDs;
    private String[] callTimes;
    private int[] callIcon;
    public CallAdapter(Context context, String[] callNames, int[] imageResourceIDs, String[] callTimes, int[] callIcon) {
        this.context = context;
        this.callNames = callNames;
        this.imageResourceIDs = imageResourceIDs;
        this.callTimes = callTimes;
        this.callIcon = callIcon;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_call, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(imageResourceIDs[position]);
        holder.nameTextView.setText(callNames[position]);
        holder.timeTextView.setText(callTimes[position]);
        holder.iconCallImageView.setImageResource(callIcon[position]);
    }
    @Override
    public int getItemCount() {
        return callNames.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView timeTextView;
        ImageView iconCallImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.images);
            nameTextView = itemView.findViewById(R.id.name);
            timeTextView = itemView.findViewById(R.id.time);
            iconCallImageView = itemView.findViewById(R.id.icon_call);
        }
    }
}
