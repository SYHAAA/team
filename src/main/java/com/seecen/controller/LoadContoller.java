package com.seecen.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class LoadContoller {

    @PostMapping("/upload")
    public String doUpload(MultipartFile myfile) throws IOException {
        File file = new File("h:/project/" + myfile.getOriginalFilename());
        if(!file.exists()){ file.createNewFile();};
        myfile.transferTo(file);
        return  "File uploaded successfully";
    }

    @RequestMapping("/download")
    public String download(String fileName, HttpServletResponse response)  {
        File file = new File("e:/project/" + fileName);
        if(!file.exists()) return "文件不存在,下载失败!";
        byte[] data = new byte[1024 * 1024];
        try(InputStream is = new FileInputStream(file);
            ServletOutputStream os = response.getOutputStream();) {
            // 告诉浏览器准备下载,并赋予下载文件的名字
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,"utf-8"));
            // 告诉浏览器, 我不是响应页面, 而是响应一个二进制数据(流)
            response.setContentType("application/octet-stream");
            int len = 0;
            while((len = is.read(data)) != -1) {
                os.write(data, 0, len);
            }
        } catch (Exception e) {e.printStackTrace();}
        return "File downloaded successfully ";
    }

}
