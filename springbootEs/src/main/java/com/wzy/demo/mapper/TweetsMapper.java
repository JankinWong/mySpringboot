package com.wzy.demo.mapper;

import com.wzy.demo.entity.Tweets;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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
public interface TweetsMapper extends BaseMapper<Tweets> {
    @Select("select * from tweets where screenName=#{screenName}")
    List<Tweets> getTweetsByOrder(String screenName);
}
