package com.xuanchen.glkt.vod.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuanchen.glkt.common.util.Result;
import com.xuanchen.glkt.model.vod.Teacher;
import com.xuanchen.glkt.vo.vod.TeacherQueryVo;
import com.xuanchen.glkt.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {
    @Autowired
    public TeacherService teacherService;

    @ApiOperation("查询全部")
    @GetMapping("/findAll")
    public Result<Object> searchAll(){
        return Result.ok(teacherService.list());
    }

    @ApiOperation("根据id删除单个信息")
    @DeleteMapping("/delete/{id}")
    public Result<Object> deleteForId(@PathVariable String id){
        return teacherService.removeById(id)? Result.ok(): Result.fail();
    }

    @ApiOperation("根据id序列批量删除")
    @DeleteMapping("batchRemove")
    public Result deleteBatch(@RequestBody List<Long> idList){
        return teacherService.removeByIds(idList)? Result.ok(): Result.fail();
    }

    @ApiOperation(value = "新增一个教师")
    @PostMapping("save")
    public Result save(@RequestBody Teacher teacher) {
        return teacherService.save(teacher)? Result.ok(): Result.fail();
    }

    @ApiOperation("根据id查询")
    @GetMapping("get/{id}")
    public Result getById(@PathVariable Long id){
        Teacher teacher = teacherService.getById(id);
        return teacher==null? Result.fail(): Result.ok(teacher);
    }

    @ApiOperation("修改信息")
    @PutMapping("update")
    public Result updateInfo(@RequestBody Teacher teacher){
        return teacherService.updateById(teacher)? Result.ok(): Result.fail();
    }

    @ApiOperation("分页查询")
    @PostMapping("/findPage/{page}/{limit}")
    public Result<Object> searchPage(@PathVariable long page, @PathVariable long limit, @RequestBody(required = false) TeacherQueryVo queryVo){
        Page<Teacher> teacherPage = new Page<>(page, limit);
        if(queryVo == null) return Result.ok(teacherService.page(teacherPage));

        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        //获取条件值
        String name = queryVo.getName();//讲师名称
        Integer level = queryVo.getLevel();//讲师级别
        String joinDateBegin = queryVo.getJoinDateBegin();//开始时间
        String joinDateEnd = queryVo.getJoinDateEnd();//结束时间

        if(!StringUtils.isEmpty(name))   wrapper.like("name",name);
        if(!StringUtils.isEmpty(level))  wrapper.eq("level",level);
        if(!StringUtils.isEmpty(joinDateBegin))  wrapper.ge("join_date",joinDateBegin);
        if(!StringUtils.isEmpty(joinDateEnd))    wrapper.le("join_date",joinDateEnd);
        return Result.ok(teacherService.page(teacherPage, wrapper));
    }
}
