package com.wzy.demo.service.impl;

import com.wzy.demo.entity.Tweets;
import com.wzy.demo.mapper.TweetsMapper;
import com.wzy.demo.service.ITweetsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author felix
 * @since 2022-07-15
 */
@Service
public class TweetsServiceImpl extends ServiceImpl<TweetsMapper, Tweets> implements ITweetsService {
    @Autowired
    private TweetsMapper tweetsMapper;

    @Override
    public List<Tweets> getTweetsByOrder(String screenName) {
        return tweetsMapper.getTweetsByOrder(screenName);
    }
}
