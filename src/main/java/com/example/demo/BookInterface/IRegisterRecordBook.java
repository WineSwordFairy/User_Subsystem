package com.example.demo.BookInterface;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface IRegisterRecordBook {

    @Insert("INSERT INTO RegisterRecordTable(AccountId,CreateDate,RegisterType) VALUES(#{AccountId}, #{CreateDate},#{RegisterType})")
    int insert(@Param("AccountId") int accountId, @Param("RegisterType") int registerType,@Param("CreateDate") Date CreateDate);

}
