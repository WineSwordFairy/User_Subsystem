package com.example.demo.ServiceController;


import com.example.demo.ResultInfo;
import com.example.demo.Service.BuyProductRecordService;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BuyProductRecordService buyProductRecordService;


    @RequestMapping("/BuyProduct")
    @Transactional(isolation = Isolation.DEFAULT)
    public String BuyProduct(int accountId, int productId, int count,String createDate) {
        try {
            //查询商品数量。
            ResultInfo result = productService.BuyProduct(accountId, productId, count);

            if (result.get_code() == 0) {
                ///商品数量足够。
                buyProductRecordService.AddBuyProductRecord(accountId, productId, count,createDate);
                return "成功!";
            }
            else {
                return "商品已售空!";
            }
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
