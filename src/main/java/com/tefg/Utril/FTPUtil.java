package com.tefg.Utril;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author 贺威
 * @create 2018-11-09 10:41
 */
public class FTPUtil {

    private static final Logger logger = LoggerFactory.getLogger(FTPUtil.class);

    private static String ftpIp = PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser = PropertiesUtil.getProperty("ftp.user");
    private static String ftpPass = PropertiesUtil.getProperty("ftp.pass");

    private String  ip;
    private int port;
    private String user;
    private String pwd;
    private FTPClient ftpClient;


    public FTPUtil(String ip, int port, String user, String pwd) {
        this.ip=ip;
        this.port=port;
        this.user=user;
        this.pwd=pwd;
    }


    /**
     * 判断成功或者失败
     * @param fileList
     * @return
     */
    public static boolean uploadFile(List<File> fileList) throws IOException {
        FTPUtil ftpUtil=new FTPUtil(ftpIp, 21, ftpUser, ftpPass);
        logger.info("开始连接ftp服务器");
        boolean result = ftpUtil.uploadFile("img", fileList);
        logger.info("开始连接ftp服务器,结束上传，上传结果：{}");
        return result;
    }

    public boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
        // 是否上传了
        boolean uploaded = true;
        FileInputStream  fis=null;
        // 连接 FTP服务器
        if (connectServer(this.ip, this.port, this.user, this.pwd)) {
            try {
                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                //设置成二进制的类型，防止乱码
                ftpClient.setFileType(FTPClient.EBCDIC_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();

                for (File file : fileList) {
                    fis = new FileInputStream(file);
                    ftpClient.storeFile(file.getName(), fis);
                }
            } catch (IOException e) {
                logger.error("上传文件异常", e);
                e.printStackTrace();
            }finally {
                fis.close();
                uploaded=false;
                ftpClient.disconnect();
            }
        }
        return  uploaded;
    }

    public  boolean connectServer(String ip,int port,String user ,String pass){
        boolean isSuccess=false;
        ftpClient=new FTPClient();
        try {
            ftpClient.connect(ip);
          isSuccess= ftpClient.login(user, pass);
        } catch (IOException e) {
            logger.error("连接ftp服务器错误",e);
            e.printStackTrace();
        }
        return isSuccess;
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }
}