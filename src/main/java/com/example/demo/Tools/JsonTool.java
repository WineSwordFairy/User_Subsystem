package com.example.demo.Tools;

import com.example.demo.Model.AccountInfo;
import net.sf.json.JSONArray;
import com.example.demo.ResultInfo;
import net.sf.json.JSONObject;

public class JsonTool {


    ///序列化结果。
    public static String SerializeObject(ResultInfo resultInfo) {
        JSONObject json = JSONObject.fromObject(resultInfo);
        return json.toString();
    }


    ///序列化结果。
    public static String Serializea(AccountInfo Info) {
        JSONObject json = JSONObject.fromObject(Info);
        return json.toString();
    }

    ///序列化业务对象。
    public static String SerializeInfo(Object Info) {
        JSONObject json = JSONObject.fromObject(Info);
        return json.toString();
    }

}
