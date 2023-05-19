package com.xuanchen.glkt.vod.controller;

import com.xuanchen.glkt.common.util.Result;
import com.xuanchen.glkt.vod.service.VideoVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="/admin/vod/videoVisitor")
public class VideoVisitorController {

    @Autowired
    private VideoVisitorService videoVisitorService;

    // 显示统计数据
    @GetMapping("findCount/{courseId}/{startDate}/{endDate}")
    public Result showChart(@PathVariable Long courseId, @PathVariable String startDate, @PathVariable String endDate){

        Map<String, Object> map = videoVisitorService.findCount(courseId, startDate, endDate);
        return Result.ok(map);
    }
}