package com.cocoa.t_rxjava;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cocoa.rxjava.rxjava.HttpResult
 * @author: shenjun@kuaiqiangche.com
 * @date: 17/2/27 16:22
 */
public class HttpResult<T> {

    private int count;
    private int start;
    private int total;
    private String title;

    //用来模仿Data
    private T subjects;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("title=" + title + " count=" + count + " start=" + start);
        if (null != subjects) {
            sb.append(" subjects:" + subjects.toString());
        }
        return sb.toString();
    }
}