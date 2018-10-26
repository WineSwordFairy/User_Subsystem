package com.example.demo.Service;

import com.example.demo.BaseClass.Person;
import com.example.demo.BookInterface.BankAccountBook;
import com.example.demo.Model.BankAccountInfo;
import com.example.demo.Model.PayRecordInfo;
import com.example.demo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class BankAccountService extends Person {

    @Autowired
    private BankAccountBook bankAccountBook;

    ///查询银行账号实体根据ID。
    public ResultInfo ProvideBankAccountInfoById(int id) {
        try {
            /// TO DO
            BankAccountInfo bankAccountInfo = this.bankAccountBook.QueryById(id);
            return ProviceResult(0, "", bankAccountInfo);
        } catch (Exception ex) {
            return ProviceResult(-1, ex.getMessage());
        } finally {

        }
    }

    ///扣费。
    public ResultInfo Pay(int accountId, BigDecimal amountOfPayment) {

        try {
            /// TO DO
            int updateCount = this.bankAccountBook.LessBanlance(accountId, amountOfPayment);
            if (updateCount > 0) {
                return ProviceResult(0, "");
            } else {
                return ProviceResult(-1, "支付失败，请重试!!");
            }
        } catch (Exception ex) {
            ///TODO
            return ProviceResult(-1, ex.getMessage());
        } finally {
            ///TODO
        }
    }

    ///生成扣费记录。
    public ResultInfo CreatePayRecord(int accountId, BigDecimal amountOfPayment, String remark) {
        try {
            /// TO DO
            PayRecordInfo payRecordInfo = new PayRecordInfo(1, accountId, amountOfPayment, remark, new Timestamp(new Date().getTime()));
            int resultCount = bankAccountBook.Insert(payRecordInfo);
            return ProviceResult(0, "", payRecordInfo);
        } catch (Exception ex) {
            ///TODO
            return ProviceResult(-1, ex.getMessage());
        } finally {
            ///TODO
        }
    }

}
