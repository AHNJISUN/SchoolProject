package com.example.finalproj_2022_1;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class WeatherFragment extends Fragment {
    TextView textView;
    SharedPreferences preferences;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        textView = (TextView) view.findViewById(R.id.tvWeather);

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());  //

        preferences = getContext().getSharedPreferences("userInfo", MODE_PRIVATE);
        String lat= preferences.getString("lat","");
        String lng = preferences.getString("lng","");
        Log.d("\n\n================", "lat"+lat+"lng"+lng);
        //String url = "https://api.openweathermap.org/data/2.5/weather?lat=37.5&lon=126.9&appid=637cf946384e938597d68fdfc05f6779";
        String url = "https://api.openweathermap.org/data/2.5/weather?lat="
                + lat +"&lon="+lng +"&appid=18dae7c1bb885bb0e25d427ca8ca556a";
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText("날씨: \n\n" + response.substring(0,500));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("error:"+error.toString());
                    }
                });

        requestQueue.add(stringRequest);
        return view;
    }
}
