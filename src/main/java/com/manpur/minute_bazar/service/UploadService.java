package com.manpur.minute_bazar.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    void uploadExcel(MultipartFile file);
}
