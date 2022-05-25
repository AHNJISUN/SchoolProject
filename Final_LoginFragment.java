package com.example.finalproj_2022_1;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginFragment extends Fragment {
    EditText tvId ;
    EditText tvPwd;
    Button btnLogin;
    SharedPreferences preferences;
    TextView tvUname;
    View navHeader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        tvId = (EditText) view.findViewById(R.id.tvId);
        tvPwd = (EditText) view.findViewById(R.id.tvPwd);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String url = "http://172.111.118.138:8080/AndroidAppEx/android2/register.jsp";

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String url2=url+"?id="+tvId.getText().toString()+"&pwd="+tvPwd.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.GET,
                        url2,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getContext(), "로그인 성공~!!", Toast.LENGTH_SHORT).show();
//                                preferences = getContext().getSharedPreferences("userInfo", MODE_PRIVATE);
//                                String uName = preferences.getString("name", "");
//                                tvUname = (TextView) navHeader.findViewById(R.id.u_name);
//                                navHeader = (View) view.findViewById(R.id.nav_view);
//                                tvUname.setText(uName + "님");
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                requestQueue.add(stringRequest);
            }
        });
        return view;
    }
}
