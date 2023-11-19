package com.example.kamja2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//마이페이지
public class mypage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);


        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_home) {
                    // 홈 버튼 클릭 시 동작
                    Intent intent = new Intent(mypage.this, MainActivity.class);
                    startActivity(intent);                }
                else if (item.getItemId() == R.id.navigation_search) {
                    // 검색 버튼 클릭 시 동작
                    Intent intent = new Intent(mypage.this, Search_home.class);
                    startActivity(intent);

                } else if (item.getItemId() == R.id.navigation_chatbot) {
                    // 챗봇 버튼 클릭 시 동작
                    Intent intent = new Intent(mypage.this, chatbot.class);
                    startActivity(intent);

                } else if (item.getItemId() == R.id.navigation_save) {
                    // 찜 버튼 클릭 시 동작
                    Intent intent = new Intent(mypage.this, heart.class);
                    startActivity(intent);


                } else if (item.getItemId() == R.id.navigation_me) {
                    // 나 버튼 클릭 시 동작
                    Intent intent = new Intent(mypage.this, mypage.class);
                    startActivity(intent);


                }

                return true;
            }

        });


    }
}


