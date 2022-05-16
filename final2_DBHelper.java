package com.example.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;

    public DBHelper(@Nullable Context context) {
        super(context, "mydb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_create = "CREATE TABLE adddry(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "date DATETIME," +
                "cloth CHAR(20)," +
                "cont CHAR(200));";
        db.execSQL(query_create);


        db.execSQL("INSERT INTO adddry (date, cloth, cont) values ('2020-03-02', '하늘색 셔츠', '목 부분 이염');");
        db.execSQL("INSERT INTO adddry (date, cloth, cont) values ('2020-04-14', '꽃무늬 스커트', '올 나감\n\t탈취 요청');");
        db.execSQL("INSERT INTO adddry (date, cloth, cont) values ('2020-07-04', '노란색 니트 가디건', '소매부분 이염');");
        db.execSQL("INSERT INTO adddry (date, cloth, cont) values ('2020-07-18', '체크무늬 블레이저', '요청사항 없음');");
        db.execSQL("INSERT INTO adddry (date, cloth, cont) values ('2020-09-26', '트위드 투피스 정장', '기장 5cm 수선 요청');");
        db.execSQL("INSERT INTO adddry (date, cloth, cont) values ('2020-11-28', '체크무늬 블레이저', '요청사항 없음');");
        db.execSQL("INSERT INTO adddry (date, cloth, cont) values ('2021-01-02', '하늘색 남방 원피스', '요청사항 없음');");
        db.execSQL("INSERT INTO adddry (date, cloth, cont) values ('2021-01-30', '소매 퍼프 황토색 블라우스', '구김 없게 세탁 요청');");
        db.execSQL("INSERT INTO adddry (date, cloth, cont) values ('2021-05-07', '가죽 자켓', '요청사항 없음');");
        db.execSQL("INSERT INTO adddry (date, cloth, cont) values ('2021-05-19', '트렌치코트', '탈취 요청');");
        db.execSQL("INSERT INTO adddry (date, cloth, cont) values ('2021-11-28', '회색 후드티', '고가 제품, 조심스러운 세탁 요청');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("DROP TABLE adddry");
            onCreate(db);
        }
    }
}
