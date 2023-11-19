package com.example.kamja2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {

    private Button loginButton, chatbotButton, recommendButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 인플레이트된 뷰를 사용하여 버튼을 찾습니다.

        // 필요한 경우 버튼에 리스너를 설정합니다.



        return view;
    }
}
