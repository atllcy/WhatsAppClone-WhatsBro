package com.example.whatsappclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment3 extends Fragment {

    private RecyclerView recyclerView;
    private CallAdapter callAdapter;

    public Fragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        recyclerView = view.findViewById(R.id.recyclercall);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        String[] callNames = getResources().getStringArray(R.array.callNames);
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
        String[] callTimes = getResources().getStringArray(R.array.callTimes);
        int[] callIcon = new int[]{
                R.drawable.baseline_videocam_24,
                R.drawable.baseline_call_24,
                R.drawable.baseline_videocam_24,
                R.drawable.baseline_call_24,
                R.drawable.baseline_call_24,
                R.drawable.baseline_call_24,
                R.drawable.baseline_call_24,
                R.drawable.baseline_videocam_24,
                R.drawable.baseline_videocam_24,
                R.drawable.baseline_videocam_24,
                R.drawable.baseline_call_24,
                R.drawable.baseline_videocam_24,
                R.drawable.baseline_call_24
        };

        callAdapter = new CallAdapter(getActivity(), callNames, imageResourceIDs, callTimes, callIcon);
        recyclerView.setAdapter(callAdapter);

        return view;
    }
}
