package com.example.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddChat_page extends AppCompatActivity {

    private View moreVertIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat_page);

        moreVertIcon = findViewById(R.id.more_set);
        moreVertIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
            ImageButton backButton = findViewById(R.id.backbuttonaddchat);
                backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view, Gravity.END);
        popupMenu.getMenuInflater().inflate(R.menu.addchat_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.ng) {
                    return true;
                } else if (menuItem.getItemId() == R.id.nb) {
                    return true;
                } else if (menuItem.getItemId() == R.id.ld) {
                    return true;
                }else if (menuItem.getItemId() == R.id.sm) {
                    return true;
                }else {
                    return false;
                }
            }
        });
        popupMenu.show();
    }
    public void onRelativeLayoutClick(View view) {
        Toast.makeText(this, "Halaman selanjutnya menyusul!", Toast.LENGTH_SHORT).show();
    }
}
