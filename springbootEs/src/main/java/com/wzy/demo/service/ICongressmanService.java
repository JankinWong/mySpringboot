package com.wzy.demo.service;

import com.wzy.demo.entity.Congressman;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author felix
 * @since 2022-07-15
 */
public interface ICongressmanService extends IService<Congressman> {
    List<Congressman> getCongressmanList();
}
