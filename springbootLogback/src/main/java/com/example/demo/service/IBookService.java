package com.example.demo.service;

import com.example.demo.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author felix
 * @since 2022-07-09
 */
public interface IBookService extends IService<Book> {

    //这些是IBookService自定义的接口 需要实现

    List<Book> findAllBook();


    List<Book> getAllbook();



}
