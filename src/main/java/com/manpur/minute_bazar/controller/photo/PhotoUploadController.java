package com.manpur.minute_bazar.controller.photo;

import com.manpur.minute_bazar.service.PhotoUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/photo")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PhotoUploadController {

    private final PhotoUploadService photoUploadService;

    /**
     * Upload a single photo
     *
     * @param file MultipartFile representing the photo
     * @return Success message
     */
    @PostMapping("/upload")
    public String uploadPhoto(@RequestParam("file") MultipartFile file) {
        photoUploadService.uploadPhoto(file); // delegate to service
        return "Photo uploaded successfully";
    }

    /**
     * Upload multiple photos at once
     *
     * @param files Array of MultipartFile
     * @return Success message
     */
    @PostMapping("/upload-multiple")
    public String uploadMultiplePhotos(@RequestParam("files") MultipartFile[] files) {
        photoUploadService.uploadMultiplePhotos(files);
        return "Photos uploaded successfully";
    }
}

