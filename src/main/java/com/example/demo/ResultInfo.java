package com.example.demo;

public class ResultInfo {

    private int code;

    private String message;

    private Object data;

    public int getcode() {
        return code;
    }

    public void setcode(int code) {
        this.code = code;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public Object getdata() {
        return data;
    }

    public void setdata(Object data) {
        this.data = data;
    }


    public ResultInfo(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultInfo(int _code, String message) {
        this.code = _code;
        this.message = message;
        this.data=new Object();
    }
}
