package com.sahakian.service.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class StorageManagerImpl implements StorageManager {

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public String write(String name, byte[] data) {
        writeData(name, data);
        return name;
    }

    @Override
    public String asyncWrite(String name, byte[] data) throws ExecutionException, InterruptedException {
        return CompletableFuture
                .supplyAsync(() -> writeData(name, data))
                .get();
    }

    @Override
    @Cacheable("xml")
    public File findByName(String name) {
        return new File(uploadPath + name);
    }

    private String writeData(String name, byte[] data) {
        var fullPath = uploadPath + name;

        try (var stream = new BufferedOutputStream(new FileOutputStream(fullPath))) {
            stream.write(data);
            return name;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
