package com.example.finalproject;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class FragmentAdd extends Fragment {
    Button backBtn, dateBtn, writeBtn;
    TextView date;
    EditText eCategory, eContent;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add, container, false);
        backBtn = (Button) view.findViewById(R.id.backButton);
        date = (TextView) view.findViewById(R.id.laundryDate);
        dateBtn = (Button) view.findViewById(R.id.dateBtn);
        writeBtn = (Button) view.findViewById(R.id.writeButton);
        eCategory = (EditText) view.findViewById(R.id.category);
        eContent = (EditText) view.findViewById(R.id.laundryContent);

        DBHelper helper = new DBHelper(getContext());
        final SQLiteDatabase[] db = {helper.getWritableDatabase()};


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), listener, mYear, mMonth, mDay);
                dialog.show();
            }
        });
        /* 유효성 검사 코드
            writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String form_date = date.getText().toString();
                String form_category = eCategory.getText().toString();
                String form_content = eContent.getText().toString();

                ContentValues values = new ContentValues();
                if(form_date.equals("") || form_date.equals(null)){
                    Toast.makeText(getContext(),"접수일을 입력해주세요", Toast.LENGTH_LONG).show();
                }else {
                    String fulldate = form_date;
                    String mYear = fulldate.substring(0,4);
                    String mMonth = fulldate.substring(6,7);
                    String mDay = fulldate.substring(9,10);
                    String reDate = mYear + "-" + mMonth + "-" + mDay;
                    values.put("date", reDate);
                }
                if(form_category.equals("") || form_category.equals(null)){
                    Toast.makeText(getContext(),"옷 종류를 입력해주세요", Toast.LENGTH_LONG).show();
                }else {
                    values.put("cloth", form_category);
                }
                if(form_content.equals("") || form_content.equals(null)){
                    Toast.makeText(getContext(),"참고사항을 입력해주세요", Toast.LENGTH_LONG).show();
                }else {
                    values.put("cont", form_content);
                }


                if(values.containsKey("date")
                        && values.containsKey("cloth")
                        && values.containsKey("cont")){
                    db.insert("adddry",null, values);
                    db.close();
                }else{
                    Toast.makeText(getContext(),"입력 양식을 확인인해주세요", Toast.LENGTH_LONG).show();

               }sork


            }
        });*/
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dbHelper=new DBHelper(getContext());
                db[0] =dbHelper.getWritableDatabase();

                String tmp="INSERT INTO adddry(date, cloth, cont) " +
                        "values('"+date.getText().toString()+"','"+eCategory.getText().toString()+"','"+eContent.getText().toString()+"')";
                db[0].execSQL(tmp);
                db[0].close();
                Toast.makeText(getContext(), "등록 완료\n3일 뒤에 찾으러 가기!!!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            int mMonth = monthOfYear + 1;
            if(dayOfMonth<10){
                date.setText(year + "-" + mMonth + "-0" + dayOfMonth);
                Toast.makeText(getContext(), year + "년" + mMonth + "월 0" + dayOfMonth + "일", Toast.LENGTH_SHORT).show();
            }else{
                date.setText(year + "-" + mMonth + "-" + dayOfMonth);
                Toast.makeText(getContext(), year + "년" + mMonth + "월" + dayOfMonth + "일", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
