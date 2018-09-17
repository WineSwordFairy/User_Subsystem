package com.example.demo.Book;

import com.example.demo.BaseClass.Book;
import com.example.demo.BookInterface.IRegisterBook;
import org.springframework.stereotype.Component;
//implements IRegisterBook
@Component
public class RegisterBook extends Book    {


    public RegisterBook() {
        this.BookName = "RegisterBook";
    }

//    @Override
//    public int insert(String UserName, String password, String name, String email, String remark) {
//        return 0;
//    }
//
//    @Override
//    public int test() {
//        return 01112;
//    }
}
