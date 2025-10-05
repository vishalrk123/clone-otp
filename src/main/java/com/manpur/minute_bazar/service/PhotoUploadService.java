package com.manpur.minute_bazar.service;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoUploadService {
    String uploadPhoto(MultipartFile file);

    String[] uploadMultiplePhotos(MultipartFile[] files);
}
