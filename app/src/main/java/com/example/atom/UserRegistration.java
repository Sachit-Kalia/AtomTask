package com.example.atom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class UserRegistration extends AppCompatActivity {

    EditText userName;
    public static InputMethodManager imm;
    ImageView backBtn;
    Button continueGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        userName = (EditText) findViewById(R.id.userNameEnter);
        backBtn = (ImageView) findViewById(R.id.backButton);
        continueGuest = (Button) findViewById(R.id.guestContinue);
        imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(!(imm==null))
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,1);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(userName.getWindowToken(), 0);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        continueGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(userName.getWindowToken(), 0);
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finishAffinity();
            }
        });


    }

}