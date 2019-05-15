package com.qhit.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by wuhen on 2019/5/14.
 */
@CrossOrigin
@Controller
public class FileUploadController1 {
    //多文件上传
    @RequestMapping(value = "/uploadimg",method = RequestMethod.POST)
    public  @ResponseBody String uploadImg(@RequestParam("file") MultipartFile[] file, HttpServletRequest request) {
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        for (int i = 0; i <file.length ; i++) {
            String contentType = file[i].getContentType();
            String fileName = file[i].getOriginalFilename();

            try {
                FileUtil.uploadFile(file[i].getBytes(), filePath, fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return filePath;



    }

}
