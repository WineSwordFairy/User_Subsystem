package com.example.demo.Model;

import java.util.Date;

public class AccountInfo {

    public AccountInfo(String _userName, String _password, String _name, String _email, String _remark, Date _createDate, int _provinceId, int _cityId) {
        this._id = _id;
        this._userName = _userName;
        this._password = _password;
        this._name = _name;
        this._email = _email;
        this._remark = _remark;
        this._createDate = _createDate;
        this._provinceId = _provinceId;
        this._cityId = _cityId;
    }

    private int _id;

    private String _userName;

    private String _password;

    private String _name;

    private String _email;

    private String _remark;

    public Date get_createDate() {
        return _createDate;
    }

    public void set_createDate(Date _createDate) {
        this._createDate = _createDate;
    }

    public int get_provinceId() {
        return _provinceId;
    }

    public void set_provinceId(int _provinceId) {
        this._provinceId = _provinceId;
    }

    public int get_cityId() {
        return _cityId;
    }

    public void set_cityId(int _cityId) {
        this._cityId = _cityId;
    }

    private Date _createDate;
    private int _provinceId;
    private int _cityId;

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
