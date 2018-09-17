package com.example.demo.Model;

public class AccountInfo {

    public AccountInfo(String _userName, String _password, String _name, String _email, String _remark) {
        this._userName = _userName;
        this._password = _password;
        this._name = _name;
        this._email = _email;
        this._remark = _remark;
    }


    private int _id;

    private String _userName;

    private String _password;

    private String _name;

    private String _email;

    private String _remark;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    public String get_userName() {
        return _userName;
    }

    public void set_userName(String _userName) {
        this._userName = _userName;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_remark() {
        return _remark;
    }

    public void set_remark(String _remark) {
        this._remark = _remark;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "_userName='" + _userName + '\'' +
                ", _password='" + _password + '\'' +
                ", _name='" + _name + '\'' +
                ", _email='" + _email + '\'' +
                ", _remark='" + _remark + '\'' +
                '}';
    }
}
