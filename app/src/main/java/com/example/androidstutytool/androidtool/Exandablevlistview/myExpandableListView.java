package com.example.androidstutytool.androidtool.Exandablevlistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.androidstutytool.androidtool.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Created by World on 2017/5/3.
 */

public class myExpandableListView extends BaseExpandableListAdapter {
    private Map<String, List<BusstationInfo>> dataset = new HashMap<>();
    private String[] parentList = new String[]{"一号站台", "二号站台"};
    private List<BusstationInfo> childrenList1 = new ArrayList<>();
    private List<BusstationInfo> childrenList2 = new ArrayList<>();

    private  Context context;
    public myExpandableListView(Context context, Map<String,List<BusstationInfo>> dataset){
        this.dataset=dataset;
        this.context=context;
    }
    //  获得某个父项的某个子项
    @Override
    public Object getChild(int parentPos, int childPos) {
        return dataset.get(parentList[parentPos]).get(childPos);
    }

    //  获得父项的数量
    @Override
    public int getGroupCount() {
        return dataset.size();
    }

    //  获得某个父项的子项数目
    @Override
    public int getChildrenCount(int parentPos) {
        return dataset.get(parentList[parentPos]).size();
    }

    //  获得某个父项
    @Override
    public Object getGroup(int parentPos) {
        return dataset.get(parentList[parentPos]);
    }

    //  获得某个父项的id
    @Override
    public long getGroupId(int parentPos) {
        return parentPos;
    }

    //  获得某个父项的某个子项的id
    @Override
    public long getChildId(int parentPos, int childPos) {
        return childPos;
    }

    //  按函数的名字来理解应该是是否具有稳定的id，这个方法目前一直都是返回false，没有去改动过
    @Override
    public boolean hasStableIds() {
        return false;
    }

    //  获得父项显示的view
    @Override
    public View getGroupView(int parentPos, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {

            view = View.inflate(context, R.layout.parent_gjcx_item, null);
        }
        view.setTag(R.layout.parent_gjcx_item, parentPos);
        view.setTag(R.layout.child_gjcx_item, -1);
        TextView text = (TextView) view.findViewById(R.id.gjcx_parent);
        text.setText(parentList[parentPos]);
        return view;
    }

    //  获得子项显示的view
    @Override
    public View getChildView(int parentPos, int childPos, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(context,R.layout.child_gjcx_item, null);
        }
        view.setTag(R.layout.parent_gjcx_item, parentPos);
        view.setTag(R.layout.child_gjcx_item, childPos);
        TextView id = (TextView) view.findViewById(R.id.gjcx_child_busID);
        TextView distance = (TextView) view.findViewById(R.id.gjcx_child_distance);
        id.setText(dataset.get(parentList[parentPos]).get(childPos).getId()+"号");
        distance.setText("距离站台"+dataset.get(parentList[parentPos]).get(childPos).getDistance()+"米");

        return view;
    }
    //  子项是否可选中，如果需要设置子项的点击事件，需要返回true
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
