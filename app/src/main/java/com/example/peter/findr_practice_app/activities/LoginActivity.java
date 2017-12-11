package com.example.peter.findr_practice_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.peter.findr_practice_app.AuthCallback;
import com.example.peter.findr_practice_app.PracticeAppPref;
import com.example.peter.findr_practice_app.logics.AuthLogic;
import com.example.peter.findr_practice_app.models.Authorization;
import com.example.peter.findr_practice_app.PracticeApp;
import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.models.LoginRequest;

/**
 * Created by peter on 11/29/17.
 */

public class LoginActivity extends AppCompatActivity implements AuthCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((Button) findViewById(R.id.btn_login)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginRequest loginRequest = new LoginRequest();
//                loginRequest.setUsername(((TextView) findViewById(R.id.et_username)).getText().toString());
//                loginRequest.setPassword(((TextView) findViewById(R.id.et_password)).getText().toString());
                loginRequest.setUsername("admin@satellite.com.ph");
                loginRequest.setPassword("admin");

                final AuthLogic authLogic = new AuthLogic();
                authLogic.authorize(loginRequest, LoginActivity.this);

//                Intent intent = new Intent(PracticeApp.getContext(), MainActivity.class);
//                startActivity(intent);

            }


        });
    }

    @Override
    public void onSuccess(Authorization authorization) {
        Log.e("Token", authorization.getToken());
        PracticeAppPref.setPrefToken(PracticeApp.getContext(), authorization.getToken());
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onError(String error) {
        Log.e("Auth", error);
    }

}