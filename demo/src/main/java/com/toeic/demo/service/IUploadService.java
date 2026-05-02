package com.toeic.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IUploadService {
    String uploadImage(MultipartFile file) throws IOException;

    String uploadAudio(MultipartFile file) throws IOException;
}
