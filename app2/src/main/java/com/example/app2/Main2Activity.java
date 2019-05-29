package com.example.app2;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.app2.adapter.MyVpAdapter;
import com.example.app2.bean.MyBean;
import com.example.app2.bean.Stu;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ViewPager vp;
    private TextView tv;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        EventBus.getDefault().register(this);
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void init(final Stu s){
        ArrayList<View> views = new ArrayList<>();
        ArrayList<MyBean.ResultsBean> list = s.getList();
        for (int i = 0; i < list.size(); i++) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_img, null);
            img = inflate.findViewById(R.id.iv);
            tv = inflate.findViewById(R.id.tv8);
            Glide.with(this).load(list.get(i).getUrl()).into(img);
            views.add(inflate);


            vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {
                    tv.setText(s.getI()+1+"/"+"20");
                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });

            MyVpAdapter myVpAdapter = new MyVpAdapter(views);
            vp.setAdapter(myVpAdapter);

            vp.setCurrentItem(s.getI());
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
