package com.xuanchen.glkt.vod.controller;

import com.xuanchen.glkt.common.util.Result;
import com.xuanchen.glkt.model.vod.Subject;
import com.xuanchen.glkt.vod.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("admin/vod/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("getChildSubject/{id}")
    public Result getChildSubject(@PathVariable Long id) {
        List<Subject> list = subjectService.selectList(id);
        return Result.ok(list);
    }

    @GetMapping(value = "/exportData")
    public void exportData(HttpServletResponse response) {
        subjectService.exportData(response);
    }

    @PostMapping("importData")
    public Result importData(MultipartFile file) {
        return subjectService.importData(file)? Result.ok(): Result.fail();
    }

}
