package com.kiran.ds.generics;

import java.util.List;

public class Response<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuffer value = new StringBuffer();
        for(T ele : data) {
            value.append(ele.toString());
        }
        return "Response{" +
                "data=" + value.toString() +
                '}';
    }
}
