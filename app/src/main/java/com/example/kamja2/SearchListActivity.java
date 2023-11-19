package com.example.kamja2;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SearchListActivity extends AppCompatActivity {
    String category;
    Integer credit;
    Button back;
    Spinner sort;
    ListView recipeList;
    SQLiteDatabase db;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_list);
        recipeList = findViewById(R.id.recipeList);
        sort = findViewById(R.id.sortSpiner);
        sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                //onResume();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        helper = new DBHelper(this);
        try {
            db = helper.getWritableDatabase();
        } catch (SQLException e)
        {
            db = helper.getReadableDatabase();
        }
        category = getIntent().getStringExtra("Category") ;
        credit = Integer.valueOf(getIntent().getStringExtra("Credit"));
        Cursor cursor = helper.getDataByCategoryAndCredit(category,credit);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.search_list_item, // 리스트뷰 아이템을 표시할 레이아웃
                cursor,
                new String[] {"credit", "name"}, // 표시할 컬럼들
                new int[] {R.id.itemCredit, R.id.itemName}, // 각 컬럼이 표시될 뷰의 ID
                0
        );
        recipeList.setAdapter(adapter);
        recipeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SearchListActivity.this,RecipeDocActivity.class);
//                intent.putExtra("RecipeName",data);
//                intent.putExtra("ingredients",(String) adapter.getItem(position).getIngredients());
//                intent.putExtra("instructions",(String) adapter.getItem(position).getInstructions());
//                intent.putExtra("rating",(Integer) adapter.getItem(position).getRating());
                startActivity(intent);
            }
        });
    }

    // 다시 불러 왔을 경우 실행 (ex: 검색 조건 변경, 정령 변경)
    @Override
    protected void onResume() {super.onResume();
        // 카테고리, 예산 불러오기
        category = getIntent().getStringExtra("Category") ;
        credit = Integer.valueOf(getIntent().getStringExtra("Credit"));

        //데이터베이스로 리스트 갱신하기

        Cursor cursor = helper.getDataByCategoryAndCredit(category,credit);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.search_list_item, // 리스트뷰 아이템을 표시할 레이아웃
                cursor,
                new String[] {"credit", "name"}, // 표시할 컬럼들
                new int[] {R.id.itemCredit, R.id.itemName}, // 각 컬럼이 표시될 뷰의 ID
                0
        );

        recipeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Click2", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SearchListActivity.this,RecipeDocActivity.class);
//                intent.putExtra("RecipeName",data);
//                intent.putExtra("ingredients",(String) adapter.getItem(position).getIngredients());
//                intent.putExtra("instructions",(String) adapter.getItem(position).getInstructions());
//                intent.putExtra("rating",(Integer) adapter.getItem(position).getRating());
                startActivity(intent);
            }
        });
        recipeList.setAdapter(adapter);
    }

}