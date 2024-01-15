package com.example.whatsappclone;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.PopupMenu;

public class Fragment2 extends Fragment {

    public Fragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        View moreVertIcon = view.findViewById(R.id.moreVertIcon);
        View addChanIcon = view.findViewById(R.id.addchan);

        moreVertIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
        addChanIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddChanMenu(view);
            }
        });

        return view;
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), view, Gravity.END);
        popupMenu.getMenuInflater().inflate(R.menu.status_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.setpriv) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        popupMenu.show();
    }

    private void showAddChanMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), view, Gravity.END);
        popupMenu.getMenuInflater().inflate(R.menu.channel_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                // Handle menu item click for AddChan icon
                if (menuItem.getItemId() == R.id.create_channel) {
                    return true;
                } else if (menuItem.getItemId() == R.id.find_channel) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        popupMenu.show();
    }
}
