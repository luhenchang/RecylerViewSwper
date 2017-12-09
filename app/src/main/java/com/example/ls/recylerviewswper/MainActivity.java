package com.example.ls.recylerviewswper;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

/**
 *
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView mActivity_review;
    private UniversalAdapter mAdatper;
    private ArrayList<SwipeCardBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setData();
    }

    private void initView() {
        mList = new ArrayList<>();
        mActivity_review = (RecyclerView) findViewById(R.id.activity_review);

    }

    private void initData() {
        /**这里的图片就上网百度了8张。本人比较懒就用本地图片代替。
         当然你要有现成的接口也可以网络加载解析。*/
        int[] intimage = {R.drawable.ds, R.drawable.dsdd, R.drawable.dsdsf, R.drawable.psb,
                R.drawable.sadasd, R.drawable.sdsfdf, R.drawable.ss, R.drawable.ssssss};
        for (int i = 0; i < 8; i++) {
            SwipeCardBean swpe = new SwipeCardBean();
            swpe.resoutimage = intimage[i];
            swpe.title = "美丽" + i;
            mList.add(swpe);
        }
    }

    private void setData() {

        SwipeCardLayoutManager swmanamger = new SwipeCardLayoutManager(this);
        mActivity_review.setLayoutManager(swmanamger);
        mAdatper = new UniversalAdapter(mList, this);
        mActivity_review.setAdapter(mAdatper);
        CardConfig.initConfig(this);
        ItemTouchHelper.Callback callback=new SwipeCardCallBack(mList,mAdatper,mActivity_review);
        ItemTouchHelper helper=new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mActivity_review);

    }


}
