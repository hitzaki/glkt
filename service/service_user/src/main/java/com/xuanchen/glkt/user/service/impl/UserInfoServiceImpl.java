package com.xuanchen.glkt.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanchen.glkt.model.user.UserInfo;
import com.xuanchen.glkt.user.mapper.UserInfoMapper;
import com.xuanchen.glkt.user.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
}
