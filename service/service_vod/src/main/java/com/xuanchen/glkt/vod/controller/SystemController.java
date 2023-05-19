package com.xuanchen.glkt.vod.controller;

import com.xuanchen.glkt.common.util.Result;
import com.xuanchen.glkt.vod.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/vod/user")
public class SystemController {

    @PostMapping("/login")
    public Result handlerLogin(){
        Map<String, Object> map = new HashMap<>();
        map.put("token", "admin-token");
        return Result.ok(map);
    }


    @GetMapping("/info")
    public Result handlerInfo(){
        Map<String, Object> map = new HashMap<>();
        map.put("roles", "admin");
        map.put("introduction", "本少第一帅");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "本少第一帅");
        return Result.ok(map);
    }

    @Autowired
    public FileService fileService;

    @PostMapping("upload")
    public Result handlerUpload(@RequestParam("file") MultipartFile file){
        String url = fileService.upload(file);
        return url==null? Result.fail(): Result.ok(url);
    }




    public String handlerImg(@RequestPart MultipartFile photo, HttpSession session){
        String fileName = session.getServletContext().getRealPath("/upload");
        File file1 = new File(fileName);
        file1.mkdirs();

        String fileName2 = photo.getOriginalFilename();
        fileName2 = "lxc" + fileName2.substring(fileName2.lastIndexOf('.'));
        File file2 = new File(fileName+fileName2);
        try {
            photo.transferTo(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "yes";
    }


    public void handlerGetImg(HttpServletResponse response, HttpSession session) throws Exception{
        response.setContentType("image/jpeg");
        String fileName = session.getServletContext().getRealPath("/upload/lxc.jpeg");
        System.out.println(fileName);
        FileInputStream in = new FileInputStream(fileName);
        BufferedImage image = ImageIO.read(in);
        OutputStream stream = response.getOutputStream();
        ImageIO.write(image, "jpeg", stream);
        stream.flush();
        stream.close();
    }


}
