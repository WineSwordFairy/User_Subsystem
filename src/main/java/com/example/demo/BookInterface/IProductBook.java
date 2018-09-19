package com.example.demo.BookInterface;

import com.example.demo.Model.AccountInfo;
import com.example.demo.Model.ProductInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface IProductBook {

    @Select("SELECT * FROM ProductTable WHERE PID=#{PID}")
    ProductInfo Query(@Param("PID") int pId);


    @Update("UPDATE ProductTable SET Count=Count-1 WHERE PID=#{PID}")
    int UpdateCount(@Param("PID") int pId);

}
