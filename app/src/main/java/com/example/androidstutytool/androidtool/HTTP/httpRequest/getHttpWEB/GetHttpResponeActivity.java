package com.example.androidstutytool.androidtool.HTTP.httpRequest.getHttpWEB;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidstutytool.androidtool.HTTP.httpRequest.util;
import com.example.androidstutytool.androidtool.R;

import java.io.IOException;


public class GetHttpResponeActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private String imgaddress="https://www.baidu.com/";
    private String str;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x001:
                textView.setText(str);
                    Toast.makeText(GetHttpResponeActivity.this,"加载成功",Toast.LENGTH_SHORT).show();
                    break;
                case 0x002:
                    break;
                case 0x03:
                    break;
                case 0x004:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_http_respone);
        button=(Button)findViewById(R.id.http_respone_button);
        textView=(TextView)findViewById(R.id.http_respone_textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.i("获取网络图片大小","开始获取网络连接");
                            str= util.getWEB(imgaddress,handler);
                            Log.i("获取网络图片大小",str.length()/1024.0+"");

                            handler.sendEmptyMessage(0x001);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }).start();
            }
        });
    }
}
