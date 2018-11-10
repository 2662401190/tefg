package com.tefg.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 贺威
 * @create 2018-11-09 9:45
 */
public interface IFilService {

    /**
     * 文件上传
     * @param file
     * @param path
     * @return
     */
    String upload(MultipartFile file, String path);
}
