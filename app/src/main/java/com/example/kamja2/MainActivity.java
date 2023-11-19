package com.example.kamja2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getSharedPreferences("MyApp", MODE_PRIVATE);
        boolean isLoggedIn = sharedPref.getBoolean("isLoggedIn", false);

 /*       if (!isLoggedIn) {
            // 로그인이 안 되어있다면 LoginActivity를 시작한다
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish(); // MainActivity를 종료하여 뒤로 가기 버튼을 눌렀을 때 MainActivity로 돌아오지 않도록 한다
            return; // 로그인 액티비티로 이동 후 이후의 코드 실행 방지
        }
*/

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        // NavHostFragment의 참조를 가져온다.
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.container_main);

        // NavController를 가져온다. 하단 네비게이션바 관련 코드, 각각의 아이템을 클릭하면 해당 fragment로 이동
        NavController navController = null;
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        // BottomNavigationView와 NavController를 연결한다.
        if (navController != null) {
            NavigationUI.setupWithNavController(bottomNavigationView, navController);
        }

        BottomNavigationView navView = findViewById(R.id.nav_view);


        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_home) {
                    // 홈 버튼 클릭 시 동작

                } else if (item.getItemId() == R.id.navigation_search) {
                    // 검색 버튼 클릭 시 동작
                    Intent intent = new Intent(MainActivity.this, Search_home.class);
                    startActivity(intent);

                } else if (item.getItemId() == R.id.navigation_chatbot) {
                    // 챗봇 버튼 클릭 시 동작
                    Intent intent = new Intent(MainActivity.this, chatbot.class);
                    startActivity(intent);

                } else if (item.getItemId() == R.id.navigation_save) {
                    // 찜 버튼 클릭 시 동작
                    Intent intent = new Intent(MainActivity.this, heart.class);
                    startActivity(intent);


                } else if (item.getItemId() == R.id.navigation_me) {
                    // 나 버튼 클릭 시 동작
                    Intent intent = new Intent(MainActivity.this, mypage.class);
                    startActivity(intent);


                }

                return true;
            }

        });
    }

        // 메인 화면에서 로그인 버튼 클릭 시 로그인 페이지로 이동
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
    }


