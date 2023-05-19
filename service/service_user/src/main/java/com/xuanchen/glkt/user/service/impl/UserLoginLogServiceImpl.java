package com.xuanchen.glkt.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanchen.glkt.model.user.UserLoginLog;
import com.xuanchen.glkt.user.mapper.UserLoginLogMapper;
import com.xuanchen.glkt.user.service.UserLoginLogService;
import org.springframework.stereotype.Service;

@Service
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog> implements UserLoginLogService {
}
