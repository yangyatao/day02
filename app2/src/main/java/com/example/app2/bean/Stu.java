package com.example.app2.bean;

import java.util.ArrayList;

public class Stu {
    private ArrayList<MyBean.ResultsBean> list;
    private int i;

    public Stu(ArrayList<MyBean.ResultsBean> list, int i) {
        this.list = list;
        this.i = i;
    }

    public Stu() {
    }

    public ArrayList<MyBean.ResultsBean> getList() {
        return list;
    }

    public void setList(ArrayList<MyBean.ResultsBean> list) {
        this.list = list;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "list=" + list +
                ", i=" + i +
                '}';
    }
}
