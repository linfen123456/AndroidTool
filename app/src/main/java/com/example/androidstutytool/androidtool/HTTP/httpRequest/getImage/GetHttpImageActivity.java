package com.example.androidstutytool.androidtool.HTTP.httpRequest.getImage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.androidstutytool.androidtool.HTTP.httpRequest.util;
import com.example.androidstutytool.androidtool.R;

import java.io.IOException;

public class GetHttpImageActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;
    private String imgaddress="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493876475297&di=1d83e14daa0774f1931e2ead02927609&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3D915d42037ed98d1076d40c39113eb807%2F8db1cb134954092362d4b7819058d109b2de4994.jpg";
    private Bitmap bm;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x001:
                    imageView.setImageBitmap(bm);
                    Toast.makeText(GetHttpImageActivity.this,"加载成功",Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_get_http_image);
        button=(Button)findViewById(R.id.http_image_button);
        imageView=(ImageView)findViewById(R.id.http_image_imageView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.i("获取网络图片大小","开始获取网络连接");
                            byte[] by= util.getImage(imgaddress);
                            Log.i("获取网络图片大小",by.length+"");
                            bm= BitmapFactory.decodeByteArray(by,0,by.length);
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
