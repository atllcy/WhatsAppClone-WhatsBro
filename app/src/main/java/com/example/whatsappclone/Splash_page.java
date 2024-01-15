package com.example.whatsappclone;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class Splash_page extends AppCompatActivity {
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        progressBar = findViewById(R.id.progressBar);

        // Set visibility of progressBar to VISIBLE
        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Set visibility of progressBar to GONE
                progressBar.setVisibility(View.GONE);

                // Start MainActivity
                startActivity(new Intent(Splash_page.this, Welcome_page.class));
                finish();
            }
        }, 3000);
    }
}