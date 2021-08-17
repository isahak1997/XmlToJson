package com.sahakian.service.storage;

import lombok.NonNull;
import org.springframework.cache.annotation.Cacheable;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface StorageManager {

    /**
     * Write file
     *
     * @param name filename
     * @param data file content
     * @return saved path
     * @throws IOException
     */
    String write(@NonNull String name, @NonNull byte[] data) throws IOException;

    /**
     * Async write
     *
     * @see {@link #write}
     */
    String asyncWrite(@NonNull String name, @NonNull byte[] data) throws ExecutionException, InterruptedException;

    File findByName(@NonNull String name);
}
