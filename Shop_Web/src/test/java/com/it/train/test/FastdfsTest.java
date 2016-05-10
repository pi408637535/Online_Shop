package com.it.train.test;

import com.it.train.util.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * Created by 55 on 2016/5/10.
 */
public class FastdfsTest {

    /**
     *FastDFD使用方法：
     1、把FastDFS提供的jar包添加到工程中
     2、初始化全局配置。加载一个配置文件:配置文件中只需写这个：tracker_server=192.168.152.131:22122。
     3、创建一个TrackerClient对象。
     4、创建一个TrackerServer对象。
     5、声明一个StorageServer对象，null。
     6、获得StorageClient对象。
     7、直接调用StorageClient对象方法上传文件即可。
     * */
    @Test
    public void testUpload() throws Exception {
        // 1、把FastDFS提供的jar包添加到工程中
        // 2、初始化全局配置。加载一个配置文件。
        ClientGlobal.init("D:\\Git Repository\\Shop_DJ\\Shop_Manager\\Shop_Web\\src\\main\\resources\\properties\\fdfs_client.conf");
        // 3、创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        // 4、创建一个TrackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 5、声明一个StorageServer对象，null。
        StorageServer storageServer = null;
        // 6、获得StorageClient对象。
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 7、直接调用StorageClient对象方法上传文件即可。
        String[] strings = storageClient.upload_file("D:\\Picture\\1-151126111639141.jpg", "jpg", null);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void testFastDfsClient() throws Exception {
        FastDFSClient client = new FastDFSClient("D:\\Git Repository\\Shop_DJ\\Shop_Manager\\Shop_Web\\src\\main\\resources\\properties\\fdfs_client.conf");
        String uploadFile = client.uploadFile("D:\\Picture\\u=895822403,3503565749&fm=21&gp=0.jpg", "jpg");
        System.out.println(uploadFile);
    }
}
