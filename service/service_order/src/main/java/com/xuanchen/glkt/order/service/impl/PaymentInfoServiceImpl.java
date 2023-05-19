package com.xuanchen.glkt.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanchen.glkt.model.order.PaymentInfo;
import com.xuanchen.glkt.order.mapper.PaymentInfoMapper;
import com.xuanchen.glkt.order.service.PaymentInfoService;
import org.springframework.stereotype.Service;

@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements PaymentInfoService {
}
