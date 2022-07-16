package com.wzy.demo.service.impl;

import com.wzy.demo.entity.Congressman;
import com.wzy.demo.mapper.CongressmanMapper;
import com.wzy.demo.service.ICongressmanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Select;
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
public class CongressmanServiceImpl extends ServiceImpl<CongressmanMapper, Congressman> implements ICongressmanService {

    @Autowired
    private CongressmanMapper congressmanMapper;

    @Override
    public List<Congressman> getCongressmanList() {
        return congressmanMapper.getCongressmanList();
    }
}
