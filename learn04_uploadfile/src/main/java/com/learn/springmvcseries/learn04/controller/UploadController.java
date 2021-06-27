package com.learn.springmvcseries.learn04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("/upload1.do")
    public ModelAndView upload1(@RequestParam("file1") MultipartFile f1) throws IOException {
        String originalFileName = f1.getOriginalFilename();
        String destFilePath = String.format("D:\\code\\learn\\springmvc-series\\learn04_uploadfile\\src\\main\\webapp\\upfile\\%s", originalFileName);
        File destFile = new File(destFilePath);
        //调用transferTo将上传的文件保存到指定的地址
        f1.transferTo(destFile);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/result.jsp");
        modelAndView.addObject("msg", destFile.getAbsolutePath());
        return modelAndView;
    }
}
