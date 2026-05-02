package com.toeic.demo.controller;

import com.toeic.demo.service.IUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class UploadController {

    private final IUploadService uploadService;

    @PostMapping(
            value = "/image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<Map<String, String>> uploadImage(
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        String url = uploadService.uploadImage(file);

        return ResponseEntity.ok(
                Map.of("url", url)
        );
    }

    @PostMapping(
            value = "/audio",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<Map<String, String>> uploadAudio(
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        String url = uploadService.uploadAudio(file);

        return ResponseEntity.ok(
                Map.of("url", url)
        );
    }
}
