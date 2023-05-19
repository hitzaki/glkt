package com.xuanchen.glkt.vod.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanchen.glkt.model.vod.Subject;
import com.xuanchen.glkt.vo.vod.SubjectEeVo;
import com.xuanchen.glkt.vod.listener.SubjectListener;
import com.xuanchen.glkt.vod.mapper.SubjectMapper;
import com.xuanchen.glkt.vod.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {
    @Autowired
    private SubjectListener subjectListener;

    @Override
    public List<Subject> selectList(Long id) {
        // 查找对应值
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", id);
        List<Subject> list = list(wrapper);
        for(Subject subject: list){
            subject.setHasChildren(isChildren(subject.getId()));
        }
        return list;
    }

    //判断这个id下面是否有子节点
    private boolean isChildren(Long id) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        Integer count = baseMapper.selectCount(wrapper);
        return count>0;
    }


    @Override
    public void exportData(HttpServletResponse response) {
        try {  // 这个下载过程不需要返回Result了，只是一个下载的过程，没必要。
            response.setContentType("application/vnd.ms-excel");  // 设置下载文件类型，ms-excel：微软的excel
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("课程分类", "UTF-8");  // 防止中文乱码，和excel无关
            response.setHeader("Content-disposition", "attachment;filename="+ fileName + ".xlsx");
            // 设置响应头信息，Content-disposition表无论什么格式都以下载的形式打开。

            List<Subject> dictList = list();  // 这里返回的是Subject，和我们Model对应的表实体类不同，还需要作处理
            List<SubjectEeVo> dictVoList = new ArrayList<>(dictList.size());
            for(Subject dict : dictList) {
                SubjectEeVo dictVo = new SubjectEeVo();
                BeanUtils.copyProperties(dict,dictVo);
                dictVoList.add(dictVo);
            }
            EasyExcel.write(response.getOutputStream(), SubjectEeVo.class).sheet("课程分类").doWrite(dictVoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean importData(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(),
                    SubjectEeVo.class,subjectListener).sheet().doRead();
        return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
