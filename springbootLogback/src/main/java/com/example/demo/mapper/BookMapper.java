package com.example.demo.mapper;

import com.example.demo.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 * BookMapper 集成BaseMapper（自身带有很多增删改查操作）如果需要自己手写（xml或者注解方式 就写在自己定义的xxxMapper里 非常灵活）
 * @author felix
 * @since 2022-07-09
 */

public interface BookMapper extends BaseMapper<Book> {


     //自己定义的查询语句（xml方式）
     List<Book> findAllBook();


     /**
      *自己定义的查询语句（注解方式）
      * @return 查询结果
      */
     @Select("SELECT * FROM book")
     List<Book> getAllbook();
}
