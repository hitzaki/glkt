package com.xuanchen.glkt.vod.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuanchen.glkt.common.util.Result;
import com.xuanchen.glkt.model.vod.Course;
import com.xuanchen.glkt.vo.vod.CourseFormVo;
import com.xuanchen.glkt.vo.vod.CoursePublishVo;
import com.xuanchen.glkt.vo.vod.CourseQueryVo;
import com.xuanchen.glkt.vod.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="/admin/vod/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("{page}/{limit}")
    public Result handlerPage(@PathVariable Long page, @PathVariable Long limit, CourseQueryVo courseQueryVo){
        Page<Course> pageParam = new Page<>(page, limit);
        Map<String,Object> map = courseService.findPage(pageParam, courseQueryVo);
        return Result.ok(map);
    }

    @PostMapping("save")
    public Result save(@RequestBody CourseFormVo courseFormVo) {
        Long courseId = courseService.saveCourseInfo(courseFormVo);
        return Result.ok(courseId);
    }

    @GetMapping("get/{id}")
    public Result handlerGet(@PathVariable Long id){
        CourseFormVo course = courseService.getCourseFormVoById(id);
        return Result.ok(course);
    }

    @PostMapping("update")
    public Result update(@RequestBody CourseFormVo courseFormVo){
        courseService.updateCourseById(courseFormVo);
        return Result.ok();
    }

    @GetMapping("getCoursePublishVo/{id}") // 根据id获取发布信息
    public Result getCoursePublishVoById(@PathVariable Long id){

        CoursePublishVo coursePublishVo = courseService.getCoursePublishVo(id);
        return Result.ok(coursePublishVo);
    }

    @PutMapping("publishCourseById/{id}") // 根据id发布
    public Result publishCourseById(@PathVariable Long id){
        boolean result = courseService.publishCourseById(id);
        return Result.ok();
    }

    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        courseService.removeCourseById(id);
        return Result.ok();
    }
}
