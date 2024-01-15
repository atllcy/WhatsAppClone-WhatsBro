package com.example.whatsappclone;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Archive_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_page);

        ImageButton backButton = findViewById(R.id.backbuttonarchive);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView moreVertButton = findViewById(R.id.arcmore);
        moreVertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerarc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inisialisasi data
        String[] chatNames = getResources().getStringArray(R.array.chatNames);
        int[] imageResourceIDs = new int[]{
                R.drawable.m,
                R.drawable.l,
                R.drawable.k,
                R.drawable.j,
                R.drawable.i,
                R.drawable.h,
                R.drawable.g,
                R.drawable.f,
                R.drawable.e,
                R.drawable.d,
                R.drawable.c,
                R.drawable.b,
                R.drawable.a
        };
        String[] chatMessages = getResources().getStringArray(R.array.chatMessages);
        String[] timeStamps = getResources().getStringArray(R.array.timeStamps);

        // Inisialisasi adapter
        ChatAdapter chatAdapter = new ChatAdapter(this, chatNames, imageResourceIDs, chatMessages, timeStamps);
        recyclerView.setAdapter(chatAdapter);
    }
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.archive_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.arcset) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        popupMenu.show();
    }
}