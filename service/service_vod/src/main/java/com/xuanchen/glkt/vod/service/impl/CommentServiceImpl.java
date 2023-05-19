package com.xuanchen.glkt.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanchen.glkt.model.vod.Comment;
import com.xuanchen.glkt.vod.mapper.CommentMapper;
import com.xuanchen.glkt.vod.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
