package com.xuanchen.glkt.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuanchen.glkt.model.vod.VideoVisitor;
import com.xuanchen.glkt.vo.vod.VideoVisitorCountVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {
    List<VideoVisitorCountVo> findCount(@Param("courseId") Long courseId,
                                        @Param("startDate") String startDate,@Param("endDate") String endDate);
}
