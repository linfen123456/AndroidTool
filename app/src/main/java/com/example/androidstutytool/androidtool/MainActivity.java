package com.example.androidstutytool.androidtool;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.androidstutytool.androidtool.BottomMenu.BottomMenuActivity;
import com.example.androidstutytool.androidtool.Exandablevlistview.GJCXFragment;
import com.example.androidstutytool.androidtool.HTTP.httpRequest.getHttpWEB.GetHttpResponeActivity;
import com.example.androidstutytool.androidtool.HTTP.httpRequest.getImage.GetHttpImageActivity;
import com.example.androidstutytool.androidtool.RecycleView.ListItem;
import com.example.androidstutytool.androidtool.RecycleView.RecycleListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String [] mainListTitle={"底部菜单栏","网络获取图片"," 获取网页内容"};
    String [] mainList={"ExpandableListView","得到"," 对对对"};
private List<ListItem> list=new ArrayList<ListItem>();
    private RecyclerView recyclerView;
    private ImageView layout_honizontal,layout_pubu,layout_veritor;
    private  LinearLayoutManager linearLoyout;
    private ListView listview,mianListview;

    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        init();//初始化数据
        linearLoyout=new LinearLayoutManager(this);//绑定控件
        recyclerView=(RecyclerView)findViewById(R.id.main_recycleView);
        layout_honizontal=(ImageView)findViewById(R.id.main_horizontal);
        layout_pubu=(ImageView)findViewById(R.id.main_pubuliu);
        layout_veritor=(ImageView)findViewById(R.id.main_veritor);


            //水平方向列表
         recyclerView.setLayoutManager(linearLoyout);
        RecycleListAdapter listAdapter=new RecycleListAdapter(list,R.layout.list_item3);
        recyclerView.setAdapter(listAdapter);



        layout_veritor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
                linearLoyout=new LinearLayoutManager(MainActivity.this);
                linearLoyout.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLoyout);
                RecycleListAdapter listAdapter=new RecycleListAdapter(list,R.layout.list_item3);
                recyclerView.setAdapter(listAdapter);
                recyclerView.setVerticalScrollbarPosition(list.size()/2);
            }
        });
        layout_honizontal.setOnClickListener(new View.OnClickListener() {//垂直方向列表
            @Override
            public void onClick(View v) {
                //获取布局管理武器，设置水平方向

                init();
                linearLoyout=new LinearLayoutManager(MainActivity.this);
                linearLoyout.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(linearLoyout);
                RecycleListAdapter listAdapter=new RecycleListAdapter(list,R.layout.list_item2);
                recyclerView.setAdapter(listAdapter);
                recyclerView.setVerticalScrollbarPosition(list.size()/2);
            }
        });

        layout_pubu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取瀑布流管理器3个一行，瀑布流水平方向
                StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(staggeredGridLayoutManager);
                init2();
                RecycleListAdapter listAdapter=new RecycleListAdapter(list,R.layout.list_item2);
                recyclerView.setAdapter(listAdapter);
            }
        });


        /**
         *
         * 主页面菜单
         */
        listview=(ListView)findViewById(R.id.main_toolList);
        ArrayAdapter<String> adaapt=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,mainListTitle);
        listview.setAdapter(adaapt);
        setOnClickList();//主菜单点击跳转界面


        //右侧滑菜单
        mianListview=(ListView)findViewById(R.id.main_mainList);
        ArrayAdapter<String> adaapt2=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,mainList);
        mianListview.setAdapter(adaapt2);
        setMainListOnClick();




        //下拉刷新
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.main_SwipeRefreshLayout_Recycle);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                android.os.Handler handler=new android.os.Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(staggeredGridLayoutManager);
                        init2();
                        RecycleListAdapter listAdapter=new RecycleListAdapter(list,R.layout.list_item2);
                        recyclerView.setAdapter(listAdapter);
                        swipeRefreshLayout.setRefreshing(false);//关闭下拉进度条
                    }
                },3000);





            }
        });
    }



    private void init() {
                list.clear();
            ListItem listItem=new ListItem();
        listItem.setImg(R.mipmap.ic_launcher);
            listItem.setTitle("啦啦啦"+1);
        list.add(listItem);

        ListItem listItem1=new ListItem();
        listItem1.setImg(R.mipmap.ic_launcher);
        listItem1.setTitle("啦啦啦"+2);
        list.add(listItem1);
        list.add(listItem1);
        list.add(listItem1);



    }
    private void init2() {
        list.clear();
        for(int i=0;i<20;i++) {
            String str="";
           int a =(int)(Math.random()*20);
            for (int j=0;j<a;j++) {
               str+="啦";
            }
            ListItem listItem = new ListItem();
            listItem.setImg(R.mipmap.ic_launcher);
            listItem.setTitle(str + i);
            list.add(listItem);
        }
    }

    private void setOnClickList() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent1=new Intent(MainActivity.this, BottomMenuActivity.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2=new Intent(MainActivity.this, GetHttpImageActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3=new Intent(MainActivity.this, GetHttpResponeActivity.class);
                        startActivity(intent3);
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;

                }
            }
        });
    }

    private void setMainListOnClick(){
        mianListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent0=new Intent(MainActivity.this, GJCXFragment.class);
                        startActivity(intent0);
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;

                }
            }
        });
    }
}
