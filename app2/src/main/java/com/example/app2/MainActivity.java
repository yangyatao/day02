package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.app2.adapter.MyAdapter;
import com.example.app2.bean.MyBean;
import com.example.app2.bean.Stu;
import com.example.app2.model.MyModelImpl;
import com.example.app2.presenter.MyPresenterImpl;
import com.example.app2.view.MyView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyView, MyAdapter.DianJi {

    private RecyclerView rlv;
    private MyPresenterImpl myPresenter;
    private ArrayList<MyBean.ResultsBean> list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        myPresenter = new MyPresenterImpl(new MyModelImpl(), this);
        myPresenter.getData();
    }

    private void initView() {
        rlv = (RecyclerView) findViewById(R.id.rlv);
        list = new ArrayList<>();
        adapter = new MyAdapter(list,this);
        rlv.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rlv.setLayoutManager(gridLayoutManager);
        adapter.setDianJi(this);
        //rlv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void cheng(MyBean bean) {
        if (bean!=null&&bean.getResults()!=null) {
            list.addAll(bean.getResults());
            adapter.setList(list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void shi(String str) {

    }

    @Override
    public void jisnTing(int position) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        EventBus.getDefault().postSticky(new Stu(list,position));
    }
}
