package com.example.androidstutytool.androidtool.Exandablevlistview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.androidstutytool.androidtool.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class GJCXFragment extends Activity {
    private Map<String, List<BusstationInfo>> dataset = new HashMap<>();
    private String[] parentList = new String[]{"一号站台", "二号站台"};
    private List<BusstationInfo> childrenList1 = new ArrayList<>();
    private List<BusstationInfo> childrenList2 = new ArrayList<>();
    private ExpandableListView listView;
    private int distance1=1000,distance2=1000;
    private boolean flag=true;
    private myExpandableListView myadapt;
    @Override
    public void onDestroy() {
        super.onDestroy();
        flag=false;
    }

    @Override
    public void onResume() {
        super.onResume();
        flag=true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gjcx);

        init();
        dataset.put(parentList[0], childrenList1);
        dataset.put(parentList[1], childrenList2);
        listView=(ExpandableListView)findViewById(R.id.gjcx_list);
        myadapt=new myExpandableListView(GJCXFragment.this,dataset);
        listView.setAdapter(myadapt);
    }

    private void init() {


               BusstationInfo b=new BusstationInfo();

               b.setId(1);
               b.setDistance(1800);
               childrenList1.add(b);
               childrenList2.add(b);
               BusstationInfo b2=new BusstationInfo();
               b2.setId(2);
               b2.setDistance(1000);
               childrenList1.add(b2);
               childrenList2.add(b2);


               soortChild1();
               soortChild2();



    }




    public void soortChild1() {
        Collections.sort(childrenList1, new Comparator<BusstationInfo>() {
            @Override
            public int compare(BusstationInfo ledBean, BusstationInfo t1) {
                if (ledBean.getDistance() > t1.getDistance()) {
                    return 1;
                }
                if (ledBean.getDistance() < t1.getDistance()) {
                    return -1;
                }
                return 0;
            }
        });

    }

    public void soortChild2() {
        Collections.sort(childrenList2, new Comparator<BusstationInfo>() {
            @Override
            public int compare(BusstationInfo ledBean, BusstationInfo t1) {
                if (ledBean.getDistance() > t1.getDistance()) {
                    return 1;
                }
                if (ledBean.getDistance() < t1.getDistance()) {
                    return -1;
                }
                return 0;
            }
        });

    }
}
