package com.example.kamja2;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import net.daum.mf.map.api.MapView;
public class map extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        // MapView 생성
        MapView mapView = new MapView(this);

        // map_view를 ViewGroup으로 가져오기
        ViewGroup mapViewContainer = findViewById(R.id.map_view);

        // ViewGroup에 MapView 추가
        mapViewContainer.addView(mapView);

    }
}
