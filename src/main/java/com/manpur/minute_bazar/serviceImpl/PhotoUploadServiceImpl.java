package com.manpur.minute_bazar.serviceImpl;

import com.manpur.minute_bazar.service.PhotoUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class PhotoUploadServiceImpl implements PhotoUploadService {

    // Directory where uploaded photos will be stored
    private final String uploadDir = "uploads/photos"; // relative to project root

    @Override
    public String uploadPhoto(MultipartFile file) {
        try {
            // Ensure upload directory exists
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Generate a safe file name
            String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
            String fileName = System.currentTimeMillis() + "_" + originalFilename;

            // Save file to disk
            Path filePath = uploadPath.resolve(fileName);
            file.transferTo(filePath.toFile());

            // Return the saved file path or URL
            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload photo: " + e.getMessage(), e);
        }
    }

    @Override
    public String[] uploadMultiplePhotos(MultipartFile[] files) {
        String[] filePaths = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            filePaths[i] = uploadPhoto(files[i]);
        }
        return filePaths;
    }
}
