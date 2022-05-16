package com.example.login_ex_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    EditText tmpID, tmpPWD;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tmpID=(EditText) findViewById(R.id.tmpID);
        tmpPWD=(EditText) findViewById(R.id.tmpPWD);
        button=(Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                String url = "http://172.111.121.11:8080/myapp/login1.jsp?id=Ahn&pwd=Ahn";
                StringRequest stringRequest = new StringRequest(Request.Method.GET,
                        url,      
                        new Response.Listener<String>() {        
                    @Override         
                    public void onResponse(String response) {         
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                }      },      
                        new Response.ErrorListener() {         
                    @Override         
                    public void onErrorResponse(VolleyError error) {
                        System.out.print("error>>>>>>>>>>>"+error);
                    }
                });
                requestQueue.add(stringRequest); 
            }
        });
    }
}