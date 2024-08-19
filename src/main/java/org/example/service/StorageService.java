package org.example.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    String store(MultipartFile multipartFile);
    String getUrl(String filename);
    void delete(String filename);
    Resource loadAsResource(String filename);
}
