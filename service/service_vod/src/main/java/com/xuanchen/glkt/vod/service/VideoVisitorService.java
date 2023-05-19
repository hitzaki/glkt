package com.xuanchen.glkt.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuanchen.glkt.model.vod.VideoVisitor;

import java.util.Map;

public interface VideoVisitorService extends IService<VideoVisitor> {
    Map<String, Object> findCount(Long courseId, String startDate, String endDate);
}
