package com.example.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.chaos.view.PinView;

public class Login_page2 extends AppCompatActivity {

    PinView pinView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page2);

        pinView = findViewById(R.id.pinview);
        button = findViewById(R.id.show_otp);

        View iconsNavig = findViewById(R.id.icons_navig);
        iconsNavig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_page2.this, Login_page.class);
                startActivity(intent);
            }
        });

        String defaultOtp = "123456";
        pinView.setText(defaultOtp);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String otp = pinView.getText().toString();
                if (!otp.isEmpty() && otp.length() == 6) {
                    navigateToNextPage();
                } else {
                    Toast.makeText(Login_page2.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
        private void navigateToNextPage() {
            Intent intent = new Intent(Login_page2.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(Login_page2.this, "Verification Successful, Navigating to Next Page", Toast.LENGTH_SHORT).show();
        }
    }