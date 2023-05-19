package com.xuanchen.glkt.vod.service.impl;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.xuanchen.glkt.vod.service.FileService;
import com.xuanchen.glkt.vod.utils.ConstantPropertiesUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String upload(MultipartFile file) {
        // 获取基本信息
        String endpoint = ConstantPropertiesUtil.END_POINT;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
        String secretId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String secretKey = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        // clientConfig 中包含了设置 region, https(默认 http),超时, 代理等 set 方法
        Region region = new Region(endpoint);
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议,  从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        try{
            // 指定要上传的文件
            InputStream inputStream = file.getInputStream();
            // 指定key
            String key = "ggkt/vod/" + UUID.randomUUID().toString().replaceAll("-","")+
                    file.getOriginalFilename();

            ObjectMetadata objectMetadata = new ObjectMetadata();
            PutObjectRequest putObjectRequest =
                    new PutObjectRequest(bucketName, key, inputStream,objectMetadata);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

            //拼接获取图片的url,基本格式为:https://ggkt-atguigu-1310644373.cos.ap-beijing.myqcloud.com/01.jpg
            String url = "https://"+bucketName+"."+"cos"+"."+endpoint+".myqcloud.com"+"/"+key;
            return url;
        } catch (Exception clientException) {
            clientException.printStackTrace();
            return null;
        }
    }
}
