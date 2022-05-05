package com.example.openweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView countryName, min, max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryName = (TextView) findViewById(R.id.country_name);
        min = (TextView) findViewById(R.id.temp_min);
        max = (TextView) findViewById(R.id.temp_max);

        DecimalFormat df = new DecimalFormat("0.0");


        String url = "https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=2b7453af9772f8479eddcdb7494c3185";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject jsonObject1 = jsonObject.getJSONObject("main");

                            double temp_min = jsonObject1.getDouble("temp_min")-273.15;
                            min.setText("최저기온 : " + df.format(temp_min));

                            double temp_max = jsonObject1.getDouble("temp_max")-273.15;
                            max.setText("최고기온 : " + df.format(temp_max));

                            String cityName = jsonObject.getString("name");

                            countryName.setText("도시 이름: " + cityName);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);

    }
}
