package org.example.service.impl;

import org.example.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Component
public class StorageServiceImpl implements StorageService {
    private final Path rootPath;
    private final String baseUrl;

    public StorageServiceImpl(@Value("${app.baseUrl}") String baseUrl) {
        this.rootPath = Paths.get(System.getProperty("java.io.tmpdir"));
        this.baseUrl = baseUrl;
    }

    @Override
    public String store(MultipartFile file) {
        checkFileEmpty(file);

        try (InputStream inputStream = file.getInputStream()) {
            File tempFile = File.createTempFile("tempFile", null);

            Files.copy(inputStream, tempFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            return tempFile.getName();
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file.", e);
        }
    }

    private void checkFileEmpty(MultipartFile multipartFile) {
        if (multipartFile == null || multipartFile.isEmpty()) {
                throw new RuntimeException("Failed to store empty file.");
        }
    }

    @Override
    public String getUrl(String filename) {
        return baseUrl + "/files/" + filename;
    }

    @Override
    public void delete(String filename) {
        try {
            Path file = rootPath.resolve(filename);
            Files.delete(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = rootPath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new RuntimeException("Could not read file: " + filename);
            }
        }
        catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: " + filename, e);
        }
    }

}
