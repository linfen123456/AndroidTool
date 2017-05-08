package com.example.androidstutytool.androidtool.TitleLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.androidstutytool.androidtool.R;


/**顶部标题栏
 * Created by World on 2017/4/25.
 */

public class TitleLinnear extends LinearLayout {
    public TitleLinnear(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.titlelayout,this);
        Button button=(Button)findViewById(R.id.Title_t1);
        Button button1=(Button)findViewById(R.id.Title_t2);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"退出",Toast.LENGTH_SHORT).show();;

            }
        });
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"菜单",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
