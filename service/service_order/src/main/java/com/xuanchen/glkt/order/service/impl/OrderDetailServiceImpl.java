package com.xuanchen.glkt.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanchen.glkt.model.order.OrderDetail;
import com.xuanchen.glkt.order.mapper.OrderDetailMapper;
import com.xuanchen.glkt.order.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
