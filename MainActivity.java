package com.example.login_db_ex_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

    EditText tmpName, tmpId, tmpPwd, tmpEmail;
    Button button;
    String name="",id="",pwd="",email="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tmpName=(EditText) findViewById(R.id.tmpName);
        tmpId=(EditText) findViewById(R.id.tmpId);
        tmpPwd=(EditText) findViewById(R.id.tmpPwd);
        tmpEmail=(EditText) findViewById(R.id.tmpEmail);
        button=(Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name=tmpName.getText().toString();
                id=tmpId.getText().toString();
                pwd=tmpPwd.getText().toString();
                email=tmpEmail.getText().toString();

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                //String url = "http://172.111.121.11:8080/myapp/login2.jsp?name=AhnJiSun&id=Ahn&pwd=Ahn&email=abc@co.kr";
                String url = "http://172.30.1.6:8080/myapp/login2.jsp?name="+name+"&id="+id+"&pwd="+pwd+"&email="+email;
                StringRequest stringRequest = new StringRequest(Request.Method.GET,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("error", error.toString());
                            }
                        });
                requestQueue.add(stringRequest);
            }
        });
    }
}