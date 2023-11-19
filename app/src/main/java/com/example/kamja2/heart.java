package com.example.kamja2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

//찜하기 페이지
public class heart extends AppCompatActivity {

    ListView heart_list;
    String[] title = {
            "4700", "8000", "2700", "6000", "1000", "300", "5000",
            "4700", "8000", "2700", "6000", "1000", "300", "5000"
    };
    Integer[] image = {

            R.drawable.heart_food3,
            R.drawable.heart_food4,
            R.drawable.heart_food3,
            R.drawable.heart_food4,
            R.drawable.heart_food3,
            R.drawable.heart_food4,
            R.drawable.heart_food3,
            R.drawable.heart_food4,
            R.drawable.heart_food3,
            R.drawable.heart_food4,
            R.drawable.heart_food3,
            R.drawable.heart_food4,
            R.drawable.heart_food3,
            R.drawable.heart_food4
    };
    String[] body = {
            "참치김밥","제육김밥", "돈까스 김밥","전주비빔", "참치마요",
            "참치김밥","제육김밥", "돈까스 김밥","전주비빔", "참치마요"

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heart);

        heart_list = findViewById(R.id.heart_list);
        CustomList adapter = new CustomList(this);
        heart_list.setAdapter(adapter);
        BottomNavigationView navView = findViewById(R.id.nav_view);


        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_home) {
                    // 홈 버튼 클릭 시 동작
                    Intent intent = new Intent(heart.this, MainActivity.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.navigation_search) {
                    // 검색 버튼 클릭 시 동작
                    Intent intent = new Intent(heart.this, Search_home.class);
                    startActivity(intent);

                } else if (item.getItemId() == R.id.navigation_chatbot) {
                    // 챗봇 버튼 클릭 시 동작
                    Intent intent = new Intent(heart.this, chatbot.class);
                    startActivity(intent);

                } else if (item.getItemId() == R.id.navigation_save) {
                    // 찜 버튼 클릭 시 동작
                    Intent intent = new Intent(heart.this, heart.class);
                    startActivity(intent);


                } else if (item.getItemId() == R.id.navigation_me) {
                    // 나 버튼 클릭 시 동작
                    Intent intent = new Intent(heart.this, mypage.class);
                    startActivity(intent);


                }

                return true;
            }

        });
    }

    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;

        public CustomList(Activity context) {
            super(context, R.layout.heart_listitem, title);
            this.context = context;
        }


        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.heart_listitem, null, true);

            TextView heart_list_title = (TextView) rowView.findViewById(R.id.heart_list_title);
            ImageView heart_list_image = (ImageView) rowView.findViewById(R.id.heart_list_image);
            TextView heart_list_body = (TextView) rowView.findViewById(R.id.heart_list_body);
            TextView heart_list_body2 = (TextView) rowView.findViewById(R.id.heart_list_body2);

            // title 배열이 null이 아니고, position이 배열의 범위 내에 있는지 확인
            if (title != null && position >= 0 && position < title.length) {
                heart_list_title.setText(title[position]);
                // image 배열도 null이 아니고, position이 배열의 범위 내에 있는지 확인
                if (image != null && position >= 0 && position < image.length) {
                    heart_list_image.setImageResource(image[position]);
                } else {
                    // image 배열이 유효하지 않은 경우 기본 이미지 설정
                }
                heart_list_body.setText("참치김밥");
                heart_list_body2.setText("콜라");
            } else {
                // 예외 처리: 인덱스가 범위를 벗어난 경우 기본값 설정 또는 처리
                Log.e("MyApp", "ArrayIndexOutOfBoundsException: position=" + position + ", title.length=" + (title != null ? title.length : 0));
                heart_list_title.setText("기본값");
                heart_list_body.setText("기본 식품");
                heart_list_body2.setText("기본 음료");
            }

            return rowView;
        }



    }
}

