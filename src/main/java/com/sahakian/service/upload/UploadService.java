package com.sahakian.service.upload;


import lombok.NonNull;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public interface UploadService {

    String save(@NonNull byte[] data) throws IOException, ExecutionException, InterruptedException;

    /**
     * Generate unique name for file
     *
     * @return name
     */
    default String generateUniqueName() {
        return UUID.randomUUID().toString();
    }
}
