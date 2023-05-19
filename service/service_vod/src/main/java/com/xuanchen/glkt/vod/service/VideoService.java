package com.xuanchen.glkt.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuanchen.glkt.model.vod.Video;

public interface VideoService extends IService<Video> {
    void removeVideoByCourseId(Long id);

    void removeVideoById(Long id);
}
