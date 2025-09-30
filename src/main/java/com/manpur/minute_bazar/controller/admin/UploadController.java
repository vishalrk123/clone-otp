package com.manpur.minute_bazar.controller.admin;

import com.manpur.minute_bazar.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UploadController {

    private final UploadService uploadService;

    @PostMapping("/excel")
    public String uploadExcel(@RequestParam("file") MultipartFile file) {
        uploadService.uploadExcel(file);

        return "Uploaded successFully";
    }
}
