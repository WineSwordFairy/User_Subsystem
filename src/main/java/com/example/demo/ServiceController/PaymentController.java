package com.example.demo.ServiceController;


import com.example.demo.Model.AccountInfo;
import com.example.demo.Model.BankAccountInfo;
import com.example.demo.ResultInfo;
import com.example.demo.Service.AccountService;
import com.example.demo.Service.BankAccountService;
import com.example.demo.Tools.JsonTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PaymentController {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private AccountService accountService;

    ///扣费。
    @RequestMapping("/Payment")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public String Index(int accountId, String payPassword, BigDecimal amountOfPayment, String remark) {
        try {
            ///账号信息查询。
            ResultInfo resultInfo = accountService.ProvideAccountInfoByAccountId(accountId);
            ///账号信息查询失败。
            if (resultInfo.getcode() == -1)
                return JsonTool.SerializeObject(new ResultInfo(-1, resultInfo.getmessage()));

            AccountInfo accountInfo = (AccountInfo) resultInfo.getdata();
            //加载支付账号。
            ResultInfo bankAccountResultInfo = bankAccountService.ProvideBankAccountInfoById(((AccountInfo) resultInfo.getdata()).getId());
            //账号实体。
            BankAccountInfo bankAccountInfo = (BankAccountInfo) bankAccountResultInfo.getdata();
            //密码检查。
            if (!bankAccountInfo.getPayPassword().equals(payPassword)) {
                return JsonTool.SerializeObject(new ResultInfo(-1, "密码错误！"));
            }

            ///判断余额是否足够。(查询和扣费要是原子操作)
            if (amountOfPayment.compareTo(bankAccountInfo.getBlance()) != 1) {///余额足。
                ///开始扣费。
                ResultInfo payResultInfo = bankAccountService.Pay(bankAccountInfo.getAccountId(), amountOfPayment);

                if (payResultInfo.getcode() == 0) {//扣费成功。
                    ///插入扣费记录。
                    ResultInfo CreateResultInfo = bankAccountService.CreatePayRecord(accountInfo.getId(), amountOfPayment, remark);

                    if (CreateResultInfo.getcode() == 0) {///插入流水成功。

                        return JsonTool.SerializeObject(new ResultInfo(0, JsonTool.SerializeInfo(CreateResultInfo.getdata())));
                    } else {

                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return JsonTool.SerializeObject(new ResultInfo(0, CreateResultInfo.getmessage()));
                    }

                } else {///扣费失败。

                    return JsonTool.SerializeObject(new ResultInfo(-1, payResultInfo.getmessage()));
                }
            } else {///余额不足。

                return JsonTool.SerializeObject(new ResultInfo(-1, "余额不足！"));
            }
        } catch (Exception ex) {

            return JsonTool.SerializeObject(new ResultInfo(-1, ex.getMessage()));
        } finally {
            ///TODO
        }


    }
}
