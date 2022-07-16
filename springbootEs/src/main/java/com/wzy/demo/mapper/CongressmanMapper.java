package com.wzy.demo.mapper;

import com.wzy.demo.entity.Congressman;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author felix
 * @since 2022-07-15
 */
public interface CongressmanMapper extends BaseMapper<Congressman> {

    @Select("select * from congressman")
    List<Congressman> getCongressmanList();
}
