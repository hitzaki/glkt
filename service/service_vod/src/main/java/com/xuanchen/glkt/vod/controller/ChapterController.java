package com.xuanchen.glkt.vod.controller;

import com.xuanchen.glkt.common.util.Result;
import com.xuanchen.glkt.model.vod.Chapter;
import com.xuanchen.glkt.vo.vod.ChapterVo;
import com.xuanchen.glkt.vod.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/admin/vod/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    //获取章节小结列表
    @GetMapping("getNestedTreeList/{courseId}")
    public Result getNestedTreeList(@PathVariable Long courseId){

        List<ChapterVo> chapterVoList = chapterService.getNestedTreeList(courseId);
        return Result.ok(chapterVoList);
    }

    // 2 添加章节
    @PostMapping("save")
    public Result save(@RequestBody Chapter chapter) {
        chapterService.save(chapter);
        return Result.ok(null);
    }

    //3 修改-根据id查询
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Chapter chapter = chapterService.getById(id);
        return Result.ok(chapter);
    }

    //4 修改-最终实现
    @PostMapping("update")
    public Result update(@RequestBody Chapter chapter) {
        chapterService.updateById(chapter);
        return Result.ok(null);
    }

    //5 删除章节
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        chapterService.removeById(id);
        return Result.ok(null);
    }
}
