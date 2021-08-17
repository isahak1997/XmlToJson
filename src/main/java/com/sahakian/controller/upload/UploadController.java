package com.sahakian.controller.upload;

import lombok.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface UploadController {

    /**
     * Upload file
     *
     * @param file form file
     * @return redirect url with saved path
     */
    @PostMapping(value = "/upload")
    String handleFileUpload(@NonNull @RequestParam("file") MultipartFile file);
}
