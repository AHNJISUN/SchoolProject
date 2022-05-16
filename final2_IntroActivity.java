package com.example.finalproject;

import androidx.annotation.NonNull;

import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity {

    ImageView imgIntro;
    EditText password;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        imgIntro = (ImageView) findViewById(R.id.dry2);
        password = (EditText) findViewById(R.id.password);


        imgIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(getApplicationContext(), R.layout.dialog, null);
                EditText password = (EditText) dialogView.findViewById(R.id.password);
                LayoutInflater inflater = getLayoutInflater();



                AlertDialog.Builder dlg = new AlertDialog.Builder(IntroActivity.this);
                dlg.setTitle("Check-in");
                dlg.setView(dialogView);
                dlg.setPositiveButton("login", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (password.getText().toString().equals("inbo1234")) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "다시 오셨군요?", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                dlg.show();
            }
        });
    }
}
