package com.example.finalproj_2022_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DrawerLayout
        drawer = (DrawerLayout) findViewById(R.id.main_drawer);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //navigation toggle home
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.d_open, R.string.d_close);
        toggle.syncState();

        //NavigationView
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.menu_home) {
                    Toast.makeText(getApplicationContext(), "NavigationDrawer home", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.menu_login) {
                    Toast.makeText(getApplicationContext(), "로그인", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.menu_register) {
                    Toast.makeText(getApplicationContext(), "회원가입", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.menu_weather) {
                    Toast.makeText(getApplicationContext(), "날씨", Toast.LENGTH_SHORT).show();
                }else if (id == R.id.menu_location) {
                    Toast.makeText(getApplicationContext(), "우치", Toast.LENGTH_SHORT).show();
                }else if (id == R.id.menu_schedule) {
                    Toast.makeText(getApplicationContext(), "스케쥴", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){  //navigation toggle
            return false;
        }
        return super.onOptionsItemSelected(item);
    }
}