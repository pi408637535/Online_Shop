package com.it.taotao.server.impl;

import com.it.taotao.server.PictureService;
import com.it.train.po.PictureResult;
import com.it.train.util.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by 55 on 2016/5/10.
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Value("${IMAGE_SERVER_BASE_URL}")
    private String IMAGE_SERVER_BASER_URL;

    @Autowired
    private FastDFSClient fastDFSClient;

    /**
     *
     * 图片上传 要求返回json格式
     * 成功时
     {
     "error" : 0,
     "url" : "http://www.example.com/path/to/file.ext"
     }
     失败时
     {
     "error" : 1,
     "message" : "错误信息"
     }
     * */
    @Override
    public PictureResult  uploadPicure(MultipartFile picFile){
        PictureResult result = new PictureResult();
        if(picFile.isEmpty()){
            result.setError(1);
            result.setMessage("Picture is Empty");
        }else{
            String originalFilename = picFile.getOriginalFilename();
            String entendFileNanme = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            try{
                String uploadFilePath = fastDFSClient.uploadFile( picFile.getBytes(), entendFileNanme);
                result.setUrl(IMAGE_SERVER_BASER_URL + uploadFilePath);
                result.setError(0);
            }catch(Exception e){
                result.setMessage("Upload Picture error");
                result.setError(1);
            }
        }
        return result;
    }

}

