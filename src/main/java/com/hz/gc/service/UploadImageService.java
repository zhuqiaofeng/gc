package com.hz.gc.service;


import java.io.FileInputStream;

/**
 * 上传文件和文件路径
 */
public interface UploadImageService {



      String uploadQNImg(FileInputStream file, String path);

}
