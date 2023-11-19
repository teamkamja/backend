package com.example.kamja2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.ArrayList;

public class JoinLastActivity extends AppCompatActivity {
    private TextView allergyPlusButton, unbalancedPlusButton, firstIdBtn;
    private EditText allergyInput, unbalancedInput;
    private ConstraintLayout allergyButtons, unbalancedButtons;

    private ArrayList<Integer> allergyButtonIds = new ArrayList<>(); // 알러지 버튼 ID 리스트
    private ArrayList<Integer> unbalancedButtonIds = new ArrayList<>(); //

    int allergyLastButtonId = R.id.allergy_first_button_id; // 알러지 초기 버튼 ID 설정
    int unbalancedLastButtonId = R.id.unbalanced_first_button_id; // 편식 초기 버튼 ID 설정

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_last);

        Button complete_button = (Button) findViewById(R.id.complete_button);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Intent intent  = getIntent();
        String email = intent.getStringExtra("email");
        String pw = intent.getStringExtra("pw");
        String gender = intent.getStringExtra("gender");

        System.out.println("email은 " + email + "이고, pw는 " + pw + "이고, 성별은 " + gender + "이다");

        allergyPlusButton = findViewById(R.id.allergy_plus_button); //알러지 + 버튼
        allergyInput = findViewById(R.id.allergy_input); // EditText
        allergyButtons = findViewById(R.id.allergy_buttons); // 버튼을 추가할 레이아웃
        unbalancedPlusButton = findViewById(R.id.unbalanced_plus_button); //알러지 + 버튼
        unbalancedInput = findViewById(R.id.unbalanced_input); // EditText
        unbalancedButtons = findViewById(R.id.unbalanced_buttons); // 버튼을 추가할 레이아웃


        complete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinLastActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        allergyPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String buttonText = allergyInput.getText().toString() + " X";
                    Button newButton = new Button(JoinLastActivity.this);
                    newButton.setId(View.generateViewId());
                    newButton.setText(buttonText);

                    newButton.setMinimumWidth(0);
                    newButton.setMinimumHeight(0);

                    newButton.setPadding(0, 0, 0, 0);

                    ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                            ConstraintLayout.LayoutParams.WRAP_CONTENT,
                            ConstraintLayout.LayoutParams.WRAP_CONTENT);
                    newButton.setLayoutParams(params);
                newButton.setBackgroundResource(R.drawable.join_add_buttons_background);
                newButton.setTextColor(Color.parseColor("#9EB23B"));
                newButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int removedId = view.getId();
                        allergyButtons.removeView(view);
                        allergyButtonIds.remove((Integer) removedId);

                        // 리스트가 비어있지 않으면 마지막 ID 업데이트
                        if (!allergyButtonIds.isEmpty()) {
                            allergyLastButtonId = allergyButtonIds.get(allergyButtonIds.size() - 1);
                        } else {
                            allergyLastButtonId = R.id.allergy_first_button_id; // 또는 적절한 초기 ID
                        }

                        // 나머지 버튼들의 제약 다시 설정
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.clone(allergyButtons);
                        int lastId = R.id.allergy_first_button_id;
                        for (int id : allergyButtonIds) {
                            constraintSet.connect(id, ConstraintSet.LEFT, lastId, lastId == R.id.allergy_first_button_id ? ConstraintSet.LEFT : ConstraintSet.RIGHT, 8);
                            lastId = id;
                        }
                        constraintSet.applyTo(allergyButtons);
                    }
                });

                allergyButtons.addView(newButton);
                allergyButtonIds.add(newButton.getId()); // ID 리스트에 추가


                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.clone(allergyButtons);
                    constraintSet.connect(newButton.getId(), ConstraintSet.LEFT, allergyLastButtonId, ConstraintSet.RIGHT, 8);
                    constraintSet.applyTo(allergyButtons);

                    allergyLastButtonId = newButton.getId();
                    System.out.println("마지막 버튼 아이디: " + allergyLastButtonId);
                    allergyInput.setText("");// 마지막 버튼 ID 업데이트
                }
        });

        unbalancedPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String buttonText = unbalancedInput.getText().toString() + " X";
                Button newButton = new Button(JoinLastActivity.this);
                newButton.setId(View.generateViewId());
                newButton.setText(buttonText);

                ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT);
                newButton.setLayoutParams(params);
                newButton.setBackgroundResource(R.drawable.join_add_buttons_background);
                newButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int removedId = view.getId();
                        unbalancedButtons.removeView(view);
                        unbalancedButtonIds.remove((Integer) removedId);

                        // 리스트가 비어있지 않으면 마지막 ID 업데이트
                        if (!unbalancedButtonIds.isEmpty()) {
                            unbalancedLastButtonId = unbalancedButtonIds.get(unbalancedButtonIds.size() - 1);
                        } else {
                            unbalancedLastButtonId = R.id.unbalanced_first_button_id; // 또는 적절한 초기 ID
                        }

                        // 나머지 버튼들의 제약 다시 설정
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.clone(unbalancedButtons);
                        int lastId = R.id.unbalanced_first_button_id;
                        for (int id : unbalancedButtonIds) {
                            constraintSet.connect(id, ConstraintSet.LEFT, lastId, lastId == R.id.unbalanced_first_button_id ? ConstraintSet.LEFT : ConstraintSet.RIGHT, 8);
                            lastId = id;
                        }
                        constraintSet.applyTo(unbalancedButtons);
                    }
                });

                unbalancedButtons.addView(newButton);
                unbalancedButtonIds.add(newButton.getId()); // ID 리스트에 추가


                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(unbalancedButtons);
                constraintSet.connect(newButton.getId(), ConstraintSet.LEFT, unbalancedLastButtonId, ConstraintSet.RIGHT, 8);
                constraintSet.applyTo(unbalancedButtons);

                unbalancedLastButtonId = newButton.getId();
                System.out.println("마지막 버튼 아이디: " + unbalancedLastButtonId);
                unbalancedInput.setText("");// 마지막 버튼 ID 업데이트
            }
        });



    }
}
