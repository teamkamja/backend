package com.example.kamja2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Search_home extends AppCompatActivity {
    Button search,back,convi;
    SeekBar creditBar;
    TextView txtCredit;
    Button[] categoryButtons = new Button[8];
    Integer[] categoryIDs = {R.id.btnKFood,R.id.btnCFood,R.id.btnInstance,R.id.btnCook,R.id.btnYFood,R.id.btnJFood,R.id.btnEasy,R.id.btnEvent};
    String category = "";
    String credit = "1000";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_home);
        search = (Button) findViewById(R.id.btnSearch);
        //back = (Button) findViewById(R.id.btnBackMenu);
        creditBar = findViewById(R.id.barCredit);
        txtCredit = findViewById(R.id.txtCredit);
        convi = findViewById(R.id.btnConvi);
        int greenColor = ContextCompat.getColor(this, R.color.green);
        int whiteColor = ContextCompat.getColor(this, R.color.white);
        ColorStateList colorStateList = ColorStateList.valueOf(greenColor);
        ColorStateList colorStateListWithe = ColorStateList.valueOf(whiteColor);
        for (int i = 0; i < categoryButtons.length;i++)
        {
            categoryButtons[i] = (Button) findViewById(categoryIDs[i]);
        }
        for (int i = 0; i < categoryButtons.length;i++)
        {
            final int index;
            index = i;
            categoryButtons[index].setBackgroundTintList(colorStateListWithe);
            categoryButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    category = categoryButtons[index].getText().toString();
                    for (int j = 0; j < categoryButtons.length;j++)
                    {
                        final int index2;
                        index2 = j;
                        categoryButtons[index2].setBackgroundTintList(colorStateListWithe);
                        categoryButtons[index2].setTextColor(ColorStateList.valueOf(ContextCompat.getColor(Search_home.this, R.color.Lightgray)));
                    }
                    categoryButtons[index].setBackgroundTintList(colorStateList);
                    categoryButtons[index].setTextColor(colorStateListWithe);

                }
            });
        }
        convi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search_home.this,MainActivity.class);
                startActivity(intent);
            }
        });
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Search_home.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (category != "")
                {
                    Intent intent = new Intent(Search_home.this,SearchListActivity.class);
                    intent.putExtra("Category",category);
                    intent.putExtra("Credit",credit);
                    startActivity(intent);
                }
            }
        });
        creditBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtCredit.setText(1000 + progress*100 + "원");
                credit =String.valueOf(1000 + progress*100);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}
