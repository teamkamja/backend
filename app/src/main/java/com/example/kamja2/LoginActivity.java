package com.example.kamja2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kamja2.User;

public class LoginActivity extends AppCompatActivity {
    private TextView find_id, find_pw, join;
    private EditText inputId, inputPassword;
    private Button loginButton, joinButton;

    private CheckBox checkBox;
    private DBHelpers dbHelpers;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        inputId = (EditText) findViewById(R.id.id);
        inputPassword = (EditText) findViewById(R.id.pw);
        loginButton = (Button) findViewById(R.id.login_button);
        join = findViewById(R.id.join);
        checkBox = findViewById(R.id.check);

        dbHelpers = new DBHelpers(this);
        user = new User();

        loginButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               String email = inputId.getText().toString();
                                               String password = inputPassword.getText().toString();

                                               user.setUsername(email);
                                               user.setPassword(password);

                                               Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                               startActivity(intent);
                                               finishAffinity();

                                           }
                                       });
             /*   if (dbHelper.checkUser(user)) {
                    dbHelper.getLoginUser(email);

                    SharedPreferences sharedPref = getSharedPreferences("MyApp", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();

                    startActivity(intent);

                } else {
                    // 로그인 실패
                    Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });*/

                join.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LoginActivity.this, JoinFirstActivity.class);
                        startActivity(intent);


                    }
                });

                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (checkBox.isChecked()) {
                            // 체크되었을 떼 배경색
                            checkBox.setBackgroundColor(Color.parseColor("#AEAEAE"));
                        } else {
                            // 기본 배경색
                            checkBox.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        }
                    }
                });
            }

}