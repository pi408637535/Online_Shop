package com.it.taotao.server;

import com.it.train.po.PictureResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by 55 on 2016/5/10.
 */
public interface PictureService {
    public PictureResult uploadPicure(MultipartFile picureFile);
}
