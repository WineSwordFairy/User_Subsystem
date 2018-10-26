package com.example.demo.BookInterface;

import com.example.demo.Model.BankAccountInfo;
import com.example.demo.Model.PayRecordInfo;
import com.example.demo.Model.ProductInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Mapper
public interface BankAccountBook {
    ///查询记录。
    @Select("SELECT * FROM BankAccountTable WHERE AccountId=#{id}")
    BankAccountInfo QueryById(@Param("id") int accountId);

    ///扣余额。
    @Update("Update BankAccountTable SET Balance = Balance - #{amountOfPayment}" +
            " WHERE AccountId=#{accountId}  AND Balance > 0")
    int LessBanlance(@Param("accountId") int accountId,
                     @Param("amountOfPayment") BigDecimal amountOfPayment);

    ///插入记录。
    @Insert("INSERT INTO PayRecordTable(AccountId,AmountOfPayment,Remark,CreateDate) " +
            "VALUES(#{accountId},#{amountOfPayment},#{remark},#{createDate})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    int Insert(PayRecordInfo payRecordInfo);
}


