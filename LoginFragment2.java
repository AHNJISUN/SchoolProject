package com.example.drawer_layout;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment2 extends Fragment {
    EditText tvId ;
    EditText tvPwd;
    Button btnLogin;
    SharedPreferences preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        tvId = (EditText) view.findViewById(R.id.tvId);
        tvPwd = (EditText) view.findViewById(R.id.tvPwd);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvId.getText().toString().equals(tvPwd.getText().toString())) {
                    preferences = getContext().getSharedPreferences("userInfo", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("name", tvId.getText().toString());
                    editor.commit();
                    Toast.makeText(getContext(), "로그인성공"+tvId.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}