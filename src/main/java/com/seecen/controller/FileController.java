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
import java.io.*;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/image.action")
    public void getImage(String fileName, HttpServletResponse response){
        File file=new File("h:/upload/"+fileName);
        if(!file.exists()) return;
        byte[] data=new byte[1024 * 1024];
        try (InputStream is=new FileInputStream(file);
             ServletOutputStream os=response.getOutputStream();)
        {
            response.setHeader("Content-Disposition", "attachment;");
            response.setContentType("application/octet-stream");
            int len =0;
            while ( (len= is.read(data))!=-1 ){
                os.write(data,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/uploadImage.action")
    @ResponseBody
    public ObjectNode uploadImage(MultipartFile file, HttpServletRequest request) throws IOException {
        int index=file.getOriginalFilename().lastIndexOf(".");
        String suffix=file.getOriginalFilename().substring(index);
        String fileName= UUID.randomUUID().toString()+ suffix;
        File distFile=new File("h:/upload/" +fileName);
        if(!distFile.exists())
            distFile.createNewFile();
        file.transferTo(distFile);
        String url=request.getContextPath()+ "/file/image.action?fileName=" + fileName;
        ObjectMapper mapper=new ObjectMapper();
        ObjectNode objNode1 = mapper.createObjectNode();
        ObjectNode objNode2 = mapper.createObjectNode();
        objNode1.put("code", 0);
        objNode2.put("src", url);
        // 给父节点json加入子节点json
        objNode1.set("data", objNode2);
        return objNode1;
    }

}