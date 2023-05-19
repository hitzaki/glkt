package com.xuanchen.glkt.vod.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xuanchen.glkt.model.vod.Course;
import com.xuanchen.glkt.vo.vod.CourseFormVo;
import com.xuanchen.glkt.vo.vod.CoursePublishVo;
import com.xuanchen.glkt.vo.vod.CourseQueryVo;

import java.util.Map;

public interface CourseService extends IService<Course> {
    Map<String, Object> findPage(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    Long saveCourseInfo(CourseFormVo courseFormVo);

    CourseFormVo getCourseFormVoById(Long id);

    void updateCourseById(CourseFormVo courseFormVo);

    CoursePublishVo getCoursePublishVo(Long id);

    boolean publishCourseById(Long id);

    void removeCourseById(Long id);
}
