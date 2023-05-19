package com.xuanchen.glkt.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuanchen.glkt.model.vod.Subject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SubjectService extends IService<Subject> {
    List<Subject> selectList(Long id);

    void exportData(HttpServletResponse response);

    public boolean importData(MultipartFile file);
}
