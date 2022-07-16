package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Book;
import com.example.demo.service.IBookService;
import com.google.gson.Gson;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author felix
 * @since 2022-07-09
 */
@RestController
@EnableWebMvc
@Api(tags = "书籍管理接口")
@RequestMapping("/book")
@Slf4j
public class BookController {
    private static Gson gson = new Gson();

    @Autowired
    private IBookService bookService;


    @RequestMapping("/getBook/{id}")
    String bookInfo(@PathVariable("id") Integer id) {
        log.info("按id查找");
        return gson.toJson(bookService.getById(id));
    }


    @Operation(summary ="按名字查找")
    @GetMapping("/getBookByName")
    String bookInfo(@ApiParam(name = "name", value = "姓名",example = "wzy") @RequestParam("name") String name) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        if(!name.isEmpty()){
            queryWrapper.eq("name",name);
        }
        log.info("按名字查找");
        return gson.toJson(bookService.list(queryWrapper).get(0));
    }

    @RequestMapping("/findAllBook")
    String findAllBook(){
        return gson.toJson(bookService.findAllBook().get(0));
    }

    @Operation(summary ="按作者查找")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "author",value = "名称1",defaultValue = "空串",required = true,paramType = "query")
            })

    @GetMapping("/getBookByAuthor")
    String getBookByAuthor(String author){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        if(!author.isEmpty()){
            queryWrapper.eq("author",author);
        }
        log.info("按作者查找");
        return gson.toJson(bookService.list(queryWrapper).get(0));
    }


}
