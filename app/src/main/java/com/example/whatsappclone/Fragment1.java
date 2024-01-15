package com.example.whatsappclone;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Fragment1 extends Fragment {

    private RecyclerView recyclerView;
    private ChatAdapter ChatAdapter;

    public Fragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);

        recyclerView = view.findViewById(R.id.recyclerchat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        String[] chatNames = getResources().getStringArray(R.array.chatNames);
        int[] imageResourceIDs = new int[]{
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g,
                R.drawable.h,
                R.drawable.i,
                R.drawable.j,
                R.drawable.k,
                R.drawable.l,
                R.drawable.m
        };
        String[] chatMessages = getResources().getStringArray(R.array.chatMessages);
        String[] timeStamps = getResources().getStringArray(R.array.timeStamps);

        ChatAdapter = new ChatAdapter(getActivity(), chatNames, imageResourceIDs, chatMessages, timeStamps);
        recyclerView.setAdapter(ChatAdapter);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddChat_page.class);
                startActivity(intent);
            }
        });

        LinearLayout archiveLayout = view.findViewById(R.id.archive);
        archiveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                archive(v);
            }
        });
        return view;
    }

    public void archive(final View v) {
        Intent intent = new Intent(getActivity(), Archive_page.class);
        startActivity(intent);

        v.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.gray));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setBackgroundColor(ContextCompat.getColor(getActivity(), android.R.color.transparent));
            }
        }, 200);
    }
}