package com.xuanchen.glkt.vod.service;

import java.io.InputStream;

public interface VodService {
    String uploadVideo(InputStream inputStream, String originalFilename);

    void removeVideo(String videoSourceId);
}
