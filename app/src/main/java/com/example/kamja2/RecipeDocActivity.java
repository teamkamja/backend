package com.example.kamja2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeDocActivity extends AppCompatActivity {

    Integer id;
    LinearLayout lineIngredients;
    RatingBar myRating;
    Button btnReview;
    TextView ingredients,instructions,difficulty,rating;
    TextView txtMyRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_document);
        lineIngredients = findViewById(R.id.lineIngredient);
        instructions = findViewById(R.id.txtRecipe);
        myRating = findViewById(R.id.myRating);
        txtMyRating = findViewById(R.id.txtRating);
        btnReview = findViewById(R.id.btnReview);


        // 리뷰작성 이동
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 리뷰 작성으로 이동 TODO: 액티비티 추가
                //Intent intent = new Intent(this,);
                //startActivity(intent);
            }
        });
        // 별점 반영
        myRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtMyRating.setText(""+rating+"/5");
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

    }

}