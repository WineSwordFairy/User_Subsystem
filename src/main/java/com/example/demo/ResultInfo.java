package com.example.demo;

public class ResultInfo {

    private int _code;

    private String _message;

    private Object _data;

    public int get_code() {
        return _code;
    }

    public void set_code(int _code) {
        this._code = _code;
    }

    public String get_message() {
        return _message;
    }

    public void set_message(String _message) {
        this._message = _message;
    }

    public Object get_data() {
        return _data;
    }

    public void set_data(Object _data) {
        this._data = _data;
    }


    public ResultInfo(int _code, String _message, Object _data) {
        this._code = _code;
        this._message = _message;
        this._data = _data;
    }

    public ResultInfo(int _code, String _message) {
        this._code = _code;
        this._message = _message;
        this._data=new Object();
    }
}
