package com.xuanchen.glkt.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanchen.glkt.model.vod.CourseDescription;
import com.xuanchen.glkt.vod.mapper.CourseDescriptionMapper;
import com.xuanchen.glkt.vod.service.CourseDescriptionService;
import org.springframework.stereotype.Service;

@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements CourseDescriptionService {
}
