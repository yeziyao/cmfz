package com.baizhi.cmfz.entity;

import java.util.ArrayList;
import java.util.List;

public class RichTextResult {
    private Integer errno;
    private List<String> data = new ArrayList<String>();

    @Override
    public String toString() {
        return "RichTextResult{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public RichTextResult() {

    }

    public RichTextResult(Integer errno, List<String> data) {

        this.errno = errno;
        this.data = data;
    }
}
