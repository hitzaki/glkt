package com.xuanchen.glkt.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanchen.glkt.model.vod.CourseCollect;
import com.xuanchen.glkt.vod.mapper.CourseCollectMapper;
import com.xuanchen.glkt.vod.service.CourseCollectService;
import org.springframework.stereotype.Service;

@Service
public class CourseCollectServiceImpl extends ServiceImpl<CourseCollectMapper, CourseCollect> implements CourseCollectService {
}
