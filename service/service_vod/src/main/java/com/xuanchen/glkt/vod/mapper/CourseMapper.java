package com.xuanchen.glkt.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuanchen.glkt.model.vod.Course;
import com.xuanchen.glkt.vo.vod.CoursePublishVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    CoursePublishVo selectCoursePublishVoById(Long id);
}
