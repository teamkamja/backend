package com.example.kamja2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JoinSecondActivity extends AppCompatActivity {
    private EditText nicknameInput, birthInput;
    private TextView birthText;
    private Button nicknameButton, maleBtn, femaleBtn, etcBtn, nextButton;
    boolean maleClicked = false, femaleClicked=false, etcClicked=false;
    String gender;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_second);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Intent intent  = getIntent();
        String email = intent.getStringExtra("email");
        String pw = intent.getStringExtra("pw");



        birthText = findViewById(R.id.birth_text);
        nicknameInput = findViewById(R.id.nickname_input);
        birthInput = findViewById(R.id.birth_input);

        maleBtn = findViewById(R.id.male_button);
        femaleBtn = findViewById(R.id.female_button);
        etcBtn = findViewById(R.id.etc_button);

        nextButton = findViewById(R.id.next_button);



        String text = "생년월일 8자리";
        SpannableString spannableString = new SpannableString(text);


        // '8' 문자의 시작과 끝 인덱스 찾기
        int startIndex = text.indexOf("8");
        int endIndex = startIndex + 1;

// '8' 문자에 대한 스타일 설정
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#707070")), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // 진한 색상 적용

// TextView에 스타일 적용된 텍스트 설정
        birthText.setText(spannableString);


        maleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maleClicked = true;
                femaleClicked = false;
                etcClicked = false;

                gender = maleBtn.getText().toString();

                maleBtn.setBackgroundResource(R.drawable.join_gender_button_clicked);
                femaleBtn.setBackgroundResource(R.drawable.join_gender_button_normal);
                etcBtn.setBackgroundResource(R.drawable.join_gender_button_normal);
                maleBtn.setTextColor(Color.parseColor("#C7D36F"));
                femaleBtn.setTextColor(Color.parseColor("#FFFFFF"));
                etcBtn.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

        femaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maleClicked = false;
                femaleClicked = true;
                etcClicked = false;

                gender = femaleBtn.getText().toString();

                femaleBtn.setBackgroundResource(R.drawable.join_gender_button_clicked);
                maleBtn.setBackgroundResource(R.drawable.join_gender_button_normal);
                etcBtn.setBackgroundResource(R.drawable.join_gender_button_normal);
                femaleBtn.setTextColor(Color.parseColor("#C7D36F"));
                maleBtn.setTextColor(Color.parseColor("#FFFFFF"));
                etcBtn.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

        etcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maleClicked = false;
                femaleClicked = false;
                etcClicked = true;

                gender = etcBtn.getText().toString();

                etcBtn.setBackgroundResource(R.drawable.join_gender_button_clicked);
                femaleBtn.setBackgroundResource(R.drawable.join_gender_button_normal);
                maleBtn.setBackgroundResource(R.drawable.join_gender_button_normal);
                etcBtn.setTextColor(Color.parseColor("#C7D36F"));
                maleBtn.setTextColor(Color.parseColor("#FFFFFF"));
                femaleBtn.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nickname = nicknameInput.getText().toString();
                String birth = birthInput.getText().toString();

//                if(nickname.isEmpty()){
//                    Toast.makeText(JoinSecondActivity.this, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show();
//                }else if(birth.isEmpty()) {
//                    Toast.makeText(JoinSecondActivity.this, "생년월일을 입력해주세요", Toast.LENGTH_SHORT).show();
//                }else if(maleClicked == false && femaleClicked == false && etcClicked == false) {
//                    Toast.makeText(JoinSecondActivity.this, "성별을 선택해주세요", Toast.LENGTH_SHORT).show();
//                }else if(maleClicked == true){
//                    gender = "남성";
//                }else if(femaleClicked == true){
//                    gender = "여성";
//                }else if(etcClicked == true){
//                    gender = "기타";
//                }else {
//                    System.out.println("닉네임은 " + nickname);
//                    System.out.println("생일은 " + birth);
//                    System.out.println("gender는 " + gender);
//                    Intent intent = new Intent(JoinSecondActivity.this, JoinLastActivity.class);
//                    intent.putExtra("email", email);
//                    intent.putExtra("pw",  pw);
//                    intent.putExtra("nickname", nickname);
//                    intent.putExtra("birth", birth);
//                    intent.putExtra("gender", gender);
//
//                    startActivity(intent);
//                }

                // 상단 코드 오류 발생해서 그냥 다음 버튼 누르면 이동하게 설정해놓음
                Intent intent = new Intent(JoinSecondActivity.this, JoinLastActivity.class);
                startActivity(intent);
            }


        });


    }
}
