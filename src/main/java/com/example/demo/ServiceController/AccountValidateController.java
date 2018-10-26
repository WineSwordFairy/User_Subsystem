package com.example.demo.ServiceController;

import com.example.demo.ResultInfo;
import com.example.demo.Service.AccountService;
import com.example.demo.Tools.JsonTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountValidateController {

    @Autowired
    private AccountService accountService;
    ///账号密码验证。
    @RequestMapping("/AccountValidate")
    public String Index(String userName , String password){
        ///验证。
        ResultInfo resultInfo=accountService.AccountValidate(userName,password);
        //json处理。
        String result= JsonTool.SerializeObject(resultInfo);

        return result;
    }



}
