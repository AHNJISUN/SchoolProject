package com.example.drawer_layout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class RegisterFragment extends Fragment {
    EditText tvRId, tvRPwd, tvRName, tvRMail;
    Button btnRegister;
    RequestQueue requestQueue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        tvRId = (EditText) view.findViewById(R.id.tvRId);
        tvRPwd = (EditText) view.findViewById(R.id.tvRPwd);
        tvRName = (EditText) view.findViewById(R.id.tvRName);
        tvRMail = (EditText) view.findViewById(R.id.tvRMail);
        btnRegister = (Button) view.findViewById(R.id.btnRegister);

        String url1 = "http://172.111.118.138:8080/AndroidAppEx/android2/register.jsp";


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url2 = url1+"?id="+tvRId.getText().toString()+
                        "&pwd="+tvRPwd.getText().toString()+
                        "&name="+tvRName.getText().toString()+
                        "&mail="+tvRMail.getText().toString();
                System.out.println("\n"+url2);
                requestQueue = Volley.newRequestQueue(getContext());
                StringRequest stringRequest = new StringRequest(
                        Request.Method.GET,
                        url2,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getContext(), "가입완료: "+response, Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getContext(), "error: "+error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }

                );
                requestQueue.add(stringRequest);
            }
        });

        return view;
    }
}