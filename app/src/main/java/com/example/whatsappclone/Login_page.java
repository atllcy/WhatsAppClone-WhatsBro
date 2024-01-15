package com.example.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.hbb20.CountryCodePicker;

public class Login_page extends AppCompatActivity {

    private CountryCodePicker ccp;
    private TextView phoneTextView;
    private Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        initializeViews();
        listeners();
    }
    private void initializeViews(){
        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        phoneTextView = (EditText) findViewById(R.id.editTextPhone);
        sendBtn = (Button) findViewById(R.id.btnSend);
    }
    private void listeners(){
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = ccp.getSelectedCountryCode();
                String country = ccp.getSelectedCountryEnglishName();
                String number = phoneTextView.getText().toString();

                if (!number.isEmpty()) {
                    String verificationMessage = "Silakan cek pesan Anda";
                    Toast.makeText(Login_page.this, verificationMessage, Toast.LENGTH_SHORT).show();
                    navigateToOTPPage();
                } else {
                    String errorMessage = "Masukkan nomor telepon";
                    Toast.makeText(Login_page.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void navigateToOTPPage(){
        Intent intent = new Intent(Login_page.this, Login_page2.class);
        startActivity(intent);
    }
}
