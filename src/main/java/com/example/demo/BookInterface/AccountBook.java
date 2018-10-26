package com.example.demo.BookInterface;

import com.example.demo.Model.AccountInfo;
import com.example.demo.Model.CountInfo;
import com.example.demo.Model.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface AccountBook {

    @Select("SELECT * FROM accountTable WHERE userName=#{userName} AND password=#{password} LIMIT 1")
    AccountInfo Query(@Param("userName") String userName, @Param("password") String password);


    @Select("SELECT * FROM accountTable WHERE ID=#{Id} LIMIT 1")
    AccountInfo QueryById(@Param("Id") Integer id);


}
