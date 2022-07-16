package com.wzy.demo.service;

import com.wzy.demo.entity.Tweets;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author felix
 * @since 2022-07-15
 */
public interface ITweetsService extends IService<Tweets> {
    List<Tweets> getTweetsByOrder(String tweetName);
}
