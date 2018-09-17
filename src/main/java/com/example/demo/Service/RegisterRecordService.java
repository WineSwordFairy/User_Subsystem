package com.example.demo.Service;

import com.example.demo.BaseClass.Person;
import com.example.demo.BookInterface.IRegisterBook;
import com.example.demo.BookInterface.IRegisterRecordBook;
import com.example.demo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class RegisterRecordService extends Person {


    ///这算是实例化接口？
    @Autowired
    @Qualifier("IRegisterRecordBook")
    private IRegisterRecordBook _myBook;

    public IRegisterRecordBook get_myBook() {
        return _myBook;
    }

    public ResultInfo AddRegisterRecord(int accountId, int registerType)
    {
        ///接口如果没有实例化，抽象方法为什么可以调用。。。？
        this.get_myBook().insert(accountId,registerType,new Date());

        return new ResultInfo(1,"test");
    }

}
