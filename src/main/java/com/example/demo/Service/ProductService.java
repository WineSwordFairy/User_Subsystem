package com.example.demo.Service;

import com.example.demo.BaseClass.Person;
import com.example.demo.BookInterface.IProductBook;
import com.example.demo.BookInterface.IRegisterBook;
import com.example.demo.Model.ProductInfo;
import com.example.demo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProductService extends Person {

    @Autowired
    @Qualifier("IProductBook")
    private IProductBook _myBook;

    public IProductBook get_myBook() {
        return _myBook;
    }


    public ResultInfo BuyProduct(int accountId, int productId, int buyCount) {


        //查看商品数量。
        ProductInfo pInfo = get_myBook().Query(productId);

        if (pInfo.getCount() > 0) {
            //减掉商品数量。
            this.get_myBook().UpdateCount(productId);
        } else {
            return ProviceResult(-1, "商品数量不足");
        }
        return ProviceResult(0, "sucessfully");
    }


}
