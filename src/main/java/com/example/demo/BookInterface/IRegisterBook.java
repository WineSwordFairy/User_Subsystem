package com.example.demo.BookInterface;

import com.example.demo.Model.AccountInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface IRegisterBook {

    @Insert("INSERT INTO AccountTable(UserName,password,name,email,remark,CreateDate,CityId,ProvinceId) VALUES(#{_userName}, #{_password},#{_name},#{_email}," +
            " #{_remark}, #{_createDate}, #{_cityId}, #{_provinceId})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty="_id", before=false, resultType=int.class )
    int insert(AccountInfo accountInfo);

}
