package com.seecen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
@RequestMapping("/files")
public class QQFileController {

    @RequestMapping("/image.action")
    public void getimgs(String fileName, HttpServletResponse response){

        File file = new File("h:/upload/"+fileName);
        if(!file.exists()) return;
        byte [] bytes = new byte[1024*1024];
        try {
            InputStream is = new FileInputStream(file);
            ServletOutputStream os = response.getOutputStream();
            // 告诉浏览器准备下载,并赋予下载文件的名字
            response.setHeader("Content-Disposition", "attachment;");
            // 告诉浏览器, 我不是响应页面, 而是响应一个二进制数据(流)
            response.setContentType("application/octet-stream");
            int len = 0;
            while ((len=is.read(bytes))!=-1){
                os.write(bytes,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //上传图片
    @RequestMapping("upload.action")
    @ResponseBody
    public ObjectNode upload(MultipartFile file, HttpServletRequest  request) throws IOException {
        int index = file.getOriginalFilename().lastIndexOf("."); //找到文件名.后面的后缀
        String sufix = file.getOriginalFilename().substring(index);  //获取后缀名
        String fileName = UUID.randomUUID().toString()+sufix;
        File diskfile = new File("h:/upload/"+fileName);
        if(!diskfile.exists()) diskfile.createNewFile();
        file.transferTo(diskfile);
        String url = request.getContextPath()+"/files/image.action?fileName="+ fileName;
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode node1 = mapper.createObjectNode();
        ObjectNode node2 =mapper.createObjectNode();
        node1.put("code",0);
        node2.put("src",url);
        //给父节点json加入子节点
        node1.set("data",node2);
        return node1;
    }

    @RequestMapping("uploadFile.action")
    @ResponseBody
    public ObjectNode uploadFile(MultipartFile file, HttpServletRequest  request) throws IOException {
        int index = file.getOriginalFilename().lastIndexOf("."); //找到文件名.后面的后缀
        String sufix = file.getOriginalFilename().substring(index);  //获取后缀名
        String fileName = UUID.randomUUID().toString()+sufix;
        File diskfile = new File("h:/upload/"+fileName);
        if(!diskfile.exists()) diskfile.createNewFile();
        file.transferTo(diskfile);
        String url = request.getContextPath()+"/files/image.action?fileName="+ fileName;
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode node1 = mapper.createObjectNode();
        ObjectNode node2 =mapper.createObjectNode();
        node1.put("code",0);
        node2.put("src",url);
        node2.put("name",fileName);
        //给父节点json加入子节点
        node1.set("data",node2);
        return node1;
    }

}
