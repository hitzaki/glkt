package com.xuanchen.glkt.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuanchen.glkt.model.vod.Chapter;
import com.xuanchen.glkt.vo.vod.ChapterVo;

import java.util.List;

public interface ChapterService extends IService<Chapter> {
    List<ChapterVo> getNestedTreeList(Long courseId);

    void removeChapterByCourseId(Long id);
}
