package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView btn1, btn2, btn3;
    FragmentAdd add;
    FragmentList list;
    FragmentPic pic;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn1 = (ImageView) findViewById(R.id.btn1);
        btn2 = (ImageView) findViewById(R.id.btn2);
        btn3 = (ImageView) findViewById(R.id.btn3);

        add=new FragmentAdd();
        list=new FragmentList();
        pic=new FragmentPic();

        fragmentManager=getSupportFragmentManager();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setVisibility(View.GONE);
                btn2.setVisibility(View.GONE);
                btn3.setVisibility(View.GONE);
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.container,add);
                ft.commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.container,list);
                ft.commit();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.container,pic);
                ft.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.frag1){
            Intent intent =new Intent(getApplicationContext(),IntroActivity.class);
            startActivity(intent);
        } else if (item.getItemId()==R.id.frag2){
            //Intent intent=new Intent(getApplicationContext(),FragmentAdd.class);
            getSupportFragmentManager().beginTransaction().replace(R.id.container,add).commit();
        } else if (item.getItemId()==R.id.frag3){
            Toast.makeText(getApplicationContext(), "세탁관련", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.frag4){
            //Intent intent=new Intent(getApplicationContext(),FragmentPic.class);
            getSupportFragmentManager().beginTransaction().replace(R.id.container,pic).commit();
        }
        return false;
    }
}
