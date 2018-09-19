package com.example.demo.Service;

import com.example.demo.BaseClass.Person;
import com.example.demo.BookInterface.IBuyProductRecordBook;
import com.example.demo.BookInterface.IProductBook;
import com.example.demo.Model.BuyProductRecordInfo;
import com.example.demo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BuyProductRecordService extends Person {


    @Autowired
    @Qualifier("IBuyProductRecordBook")
    private IBuyProductRecordBook _myBook;

    public IBuyProductRecordBook get_myBook() {
        return _myBook;
    }

    public ResultInfo AddBuyProductRecord(int accountId, int productId, int count) {
        BuyProductRecordInfo info = new BuyProductRecordInfo(accountId, productId, count);
        get_myBook().insert(info);
        return ProviceResult(0,"Sucessfully!");
    }


}
