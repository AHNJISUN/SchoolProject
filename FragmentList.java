package com.example.finalproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentList extends Fragment {
    DBHelper dbHelper;
    SQLiteDatabase db;
    TextView tvResult;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_list, container, false);
        tvResult = (TextView) view.findViewById(R.id.resultTextView);

        dbHelper = new DBHelper(getContext());
        db = dbHelper.getReadableDatabase();
        db=dbHelper.getWritableDatabase();

        String qrySelect = "SELECT strftime('%Y-%m-%d', date), cloth, cont FROM adddry ORDER BY date DESC";
        Cursor cursor = db.rawQuery(qrySelect, null);
        while (cursor.moveToNext()) {
            String tmp = cursor.getString(0) + ":" + cursor.getString(1) + "\n\t"+cursor.getString(2);
            tvResult.append("\n\n"+tmp);
        }



        db.close();

        return view;
    }
}