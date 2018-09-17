package com.example.demo.Service;

import com.example.demo.BaseClass.Person;
import com.example.demo.Book.RegisterBook;
import com.example.demo.BookInterface.IRegisterBook;
import com.example.demo.BookInterface.IRegisterRecordBook;
import com.example.demo.Model.AccountInfo;
import com.example.demo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class RegisterService extends Person {

    ///这算是实例化接口？
    @Autowired
    @Qualifier("IRegisterBook")
    private IRegisterBook _myBook;

    public IRegisterBook get_myBook() {
        return _myBook;
    }

    public ResultInfo Register(String userName , String password , String name , String email, String remark)
    {
        ///接口如果没有实例化，抽象方法为什么可以调用???

        ///init.. model
        AccountInfo accountInfo=new AccountInfo(userName,password,name,email,remark);
        ///插入accountInfo。
        this.get_myBook().insert(accountInfo);
        return new ResultInfo(1,"test",accountInfo);
    }
}
