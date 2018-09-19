package com.example.demo.ServiceController;


import com.example.demo.Model.AccountInfo;
import com.example.demo.ResultInfo;
import com.example.demo.Service.RegisterRecordService;
import com.example.demo.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private RegisterRecordService registerrecordService;

    @RequestMapping("/Register")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int Register(String userName, String password,String email ,String name,String remark) {

        String test=userName;
        int resultInt = 0;


        try {
            ResultInfo result = registerService.Register(userName, password,
                    name, email, remark);

            int accountId = ((AccountInfo) result.get_data()).get_id();
            ResultInfo result2 = registerrecordService.AddRegisterRecord(accountId, 1);
        } catch (Exception ex) {
            resultInt = -1;
        }

        return resultInt;
    }

}
