package com.example.prac_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView) findViewById(R.id.textView);

        String data = "{\"subject\":{\"과목명\": \"모프\",\"구분\": \"실습\" }}";
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONObject obj1 = jsonObject.getJSONObject("subject");

            String type = obj1.getString("과목명");
            textView.setText("과목명 : "+type);

            String doing = obj1.getString("구분");
            textView.append("\n구분 : "+doing);

        }catch (JSONException e){
            textView.setText("ERROR!!!");
        }
    }
}