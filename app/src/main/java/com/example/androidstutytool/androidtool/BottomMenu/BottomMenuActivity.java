package com.example.androidstutytool.androidtool.BottomMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.androidstutytool.androidtool.R;

public class BottomMenuActivity extends AppCompatActivity {
    /**
     * 底部菜单栏
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bottom_menu);
    }
}
