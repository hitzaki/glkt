package com.xuanchen.glkt.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xuanchen.glkt.model.order.OrderInfo;
import com.xuanchen.glkt.vo.order.OrderInfoQueryVo;

import java.util.Map;

public interface OrderInfoService extends IService<OrderInfo> {
    Map<String, Object> findPageOrderInfo(Page<OrderInfo> pageParam, OrderInfoQueryVo orderInfoQueryVo);
}
