package com.example.androidstutytool.androidtool.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;


import com.example.androidstutytool.androidtool.MainActivity;
import com.example.androidstutytool.androidtool.R;

import java.util.ArrayList;
import java.util.List;

public class HelloActivity extends AppCompatActivity {
    /**
     * 欢迎界面
     */
    private ViewPager viewPager;
    private List<View> list;
    private RadioButton[] radioButtons=new RadioButton[3];
    private int[] Rbutton={R.id.hello_radioButton1, R.id.hello_radioButton2,R.id.hello_radioButton3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        list=new ArrayList<View>();
        list.add(LayoutInflater.from(this).inflate(R.layout.viewpager_one,null));
        list.add(LayoutInflater.from(this).inflate(R.layout.viewpager_two,null));
        list.add(LayoutInflater.from(this).inflate(R.layout.viewpager_three,null));

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        MyViewPager myViewPager=new MyViewPager();
        viewPager.setAdapter(myViewPager);


        for (int i=0;i<radioButtons.length;i++){
            radioButtons[i]=(RadioButton)findViewById(Rbutton[i]);
            radioButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i=0;i<radioButtons.length;i++){
                        if (v.getId()==Rbutton[i]){
                            viewPager.setCurrentItem(i);
                        }
                    }
                }
            });
        }
        radioButtons[0].setChecked(true);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) { radioButtons[position].setChecked(true);

                if (position==2){
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(HelloActivity.this, MainActivity.class));
                        }
                    },3000);

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    class MyViewPager extends PagerAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
          container.removeView(list.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }
    }
}
