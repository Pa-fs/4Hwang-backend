package com.green.sahwang.config.filepath;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class ImageFilePathConfig {

    @Bean
    public Path getImageFilePath(String relativePath) {
        Path absolutePath = Paths.get(relativePath).toAbsolutePath();
        try {
            Files.createDirectories(absolutePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return absolutePath;
    }
}
