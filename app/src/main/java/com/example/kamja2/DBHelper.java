package com.example.kamja2;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kamja2.User;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ProductDatabase.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // ingredients는 쉼표로 구분
        db.execSQL("CREATE TABLE Recipe (" +
                " _id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "ingredients TEXT," +
                "instructions TEXT," +
                "category TEXT," +
                "difficulty INTEGER," +
                "score INTEGER," +
                "credit INTEGER," +
                "nutrient TEXT"+
                ");");

        db.execSQL("INSERT INTO Recipe (name, ingredients, instructions, category, difficulty, score, credit, nutrient)"+
                "VALUES( '중식요리1','재료1,재료2,재료3','요리방법:어쩌구어쩌구','중식',3,2,1000,'영양분 1, 영양분 2')");
        db.execSQL("INSERT INTO Recipe(name, ingredients, instructions, category, difficulty, score, credit, nutrient)"+
                " VALUES('한식요리1','재료11,재료12,재료13','요리방법:어쩌구어쩌구','한식',2,20,1000,'영양분 1, 영양분 2')");
        db.execSQL("INSERT INTO Recipe(name, ingredients, instructions, category, difficulty, score, credit, nutrient)"+
                " VALUES('한식요리4','재료5,재료8,재료6','요리방법:어쩌구어쩌구','한식',3,30,3000,'영양분 1, 영양분 2')");
        db.execSQL("INSERT INTO Recipe(name, ingredients, instructions, category, difficulty, score, credit, nutrient)"+
                " VALUES('중식요리2','재료21,재료22,재료23','요리방법:어쩌구어쩌구','중식',2,30,4000,'영양분 1, 영양분 2' )");
        db.execSQL("INSERT INTO Recipe(name, ingredients, instructions, category, difficulty, score, credit, nutrient)" +
                "VALUES('중식요리3','재료31,재료32,재료33','요리방법:어쩌구어쩌구','중식',1,10,5000,'영양분 1, 영양분 2')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // 카테고리랑 예산만으로 필터링
    public Cursor getDataByCategoryAndCredit(String categoryValue, int creditLimit) {
        SQLiteDatabase db = this.getReadableDatabase();

        // 카테고리가 매개변수와 같고 예산이 매개변수보다 작은 것
        String[] projection = null;
        String selection = "category=? AND credit <= ?";
        String[] selectionArgs = { categoryValue, String.valueOf(creditLimit) };

        Cursor cursor = db.query(
                "Recipe", // 테이블 이름
                projection, // 가져올 컬럼들, null인 경우 모든 컬럼을 가져옴
                selection, // 조건절
                selectionArgs, // 조건 값
                null, // groupBy
                null, // having
                null // orderBy
        );

        // 이후 cursor를 반환하거나 사용할 작업 수행
        return cursor;
    }
    // 카타고리랑 예산에 다른 기준으로 필터링
    public Cursor getDataByCategoryAndCredit(String categoryValue, int creditLimit, String orderByColumn) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = null;
        String selection = "category=? AND credit <= ?";
        String[] selectionArgs = { categoryValue, String.valueOf(creditLimit) };

        Cursor cursor = db.query(
                "Recipe",
                projection,
                selection,
                selectionArgs,
                null,
                null,
                orderByColumn  // 매개변수로 받은 orderByColumn에 따라 정렬
        );

        return cursor;
    }


}

