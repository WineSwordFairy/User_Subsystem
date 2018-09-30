package com.example.demo.BookInterface;


import com.example.demo.Model.BuyProductRecordInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Mapper
public interface IBuyProductRecordBook {

    @Insert("INSERT INTO BuyProductRecordTable(AccountId,ProductId,Count,CreateDate) VALUES(#{accountId}, #{productId},#{count},#{createDate})")
    int insert(BuyProductRecordInfo info);
}
