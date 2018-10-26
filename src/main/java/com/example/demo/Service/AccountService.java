package com.example.demo.Service;

import com.example.demo.BaseClass.Person;
import com.example.demo.BookInterface.AccountBook;
import com.example.demo.BookInterface.IRegisterBook;
import com.example.demo.Model.AccountInfo;
import com.example.demo.Model.CountInfo;
import com.example.demo.ResultInfo;
import com.example.demo.Tools.JsonTool;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountService extends Person {

    ///这算是实例化接口？
    @Autowired
    private AccountBook _myBook;

    ///账号密码验证。
    public ResultInfo AccountValidate(String userName, String password) {
        ///查对应数据。
        AccountInfo accountInfo = this._myBook.Query(userName, password);
        ///验证。
        if (accountInfo != null) {

            if (accountInfo.getPassword().equals(password)) {

                String test=JsonTool.Serializea(accountInfo);

                return ProviceResult(0, JsonTool.Serializea(accountInfo));

            } else {
                return ProviceResult(-1, "密码不正确!");
            }
        } else {
            return ProviceResult(-1, "用户名不存在!");
        }

    }

    ///查询账号信息。
    public ResultInfo ProvideAccountInfoByAccountAndPassword(String userName, String password) {
        try {
            /// TO DO
            AccountInfo accountInfo = this._myBook.Query(userName, password);
            return ProviceResult(0, "", accountInfo);

        } catch (Exception ex) {
            ///
            return ProviceResult(-1, ex.getMessage());
        } finally {
            ///TODO
        }

    }


    public ResultInfo ProvideAccountInfoByAccountId(int accountId) {
        try {
            /// TO DO
            AccountInfo accountInfo = this._myBook.QueryById(Integer.valueOf(accountId));
            return ProviceResult(0, "", accountInfo);

        } catch (Exception ex) {
            ///
            return ProviceResult(-1, ex.getMessage());
        } finally {
            ///TODO
        }

    }

}
