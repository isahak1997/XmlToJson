package com.sahakian.service.upload;

import com.sahakian.service.storage.StorageManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadServiceImpl implements UploadService {
    private final StorageManager storageManager;

    public String save(byte[] data) throws IOException, ExecutionException, InterruptedException {
        var fileName = UploadService.super.generateUniqueName() + ".xml";

        // if xml size 1 gb+ write async
        if (Math.log(data.length) < 9) {
            return storageManager.write(fileName, data);
        } else {
            return storageManager.asyncWrite(fileName, data);
        }
    }
}
