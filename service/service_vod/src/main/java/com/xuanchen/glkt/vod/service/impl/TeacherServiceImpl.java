package com.xuanchen.glkt.vod.service.impl;

import com.xuanchen.glkt.model.vod.Teacher;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanchen.glkt.vod.mapper.TeacherMapper;
import com.xuanchen.glkt.vod.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
}
