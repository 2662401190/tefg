package com.tefg.service.Imp;

import com.google.common.collect.Lists;
import com.tefg.Utril.FTPUtil;
import com.tefg.service.IFilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 贺威
 * @create 2018-11-09 9:45
 */
@Service("iFilService")
public class FileServiceIpm implements IFilService {

    private Logger logger = LoggerFactory.getLogger(FileServiceIpm.class);

    /**
     * 文件上传
     * @param file
     * @param path
     * @return
     */
    @Override
    public  String upload(MultipartFile file,String path){
        String fileName=file.getOriginalFilename();
        //扩展名  abc.jpg
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        // 上传文件的名       uuid 防止文件重名
        String uploadFileName= UUID.randomUUID().toString()+"."+fileExtensionName;
        //打印日志
        logger.info("开始传文件，上传文件的文件名：{}，上传的路劲：{}，新文件名：{}",fileName,path,uploadFileName);

        File fileDir = new File(path);
        // 如果文件不存在
        if(!fileDir.exists()){
            //给一个写的权限
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile=new File(path,uploadFileName);

        try {
            file.transferTo(targetFile);

            // 这行结束代表已经上传到服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));

            //删除upload下的文件,,也因为已经上传到服务器上
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }
        return  targetFile.getName();
    }


}
