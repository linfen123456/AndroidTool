package com.example.androidstutytool.androidtool.HTTP.httpRequest;

import android.os.Handler;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by World on 2017/5/4.
 */

public class util {
    public  static byte[] getImage(String urladdress) throws IOException {
        URL url=new URL(urladdress);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        InputStream in=connection.getInputStream();
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        byte[] file=new byte[1024];
        int len=0;
        while ((len=in.read(file))!=-1){
            outputStream.write(file,0,len);
        }
        file=outputStream.toByteArray();
        connection.disconnect();

        return  file;
    }

    public  static String getWEB(String urladdress, Handler handler) throws IOException {
        URL url=new URL(urladdress);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(8000);
        InputStream in=connection.getInputStream();
        BufferedReader buffer=new BufferedReader(new InputStreamReader(in));
        DataOutputStream out=new DataOutputStream(connection.getOutputStream());
        out.write("123".getBytes());
        StringBuilder str=new StringBuilder();

        String len;
        while ((len= buffer.readLine())!=null){
            str.append(len+"\n");
        }
//        OkHttpClient client=new OkHttpClient();
//        Request request=new Request.Builder()
//                .url("www.baidu.com")
//                .build();
//        Response response=client.newCall(request).execute();
//        String responeDate=response.body().string();

        return  str.toString();
    }
}
