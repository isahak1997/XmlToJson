package com.sahakian.controller.upload;

import com.sahakian.service.upload.UploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadControllerImpl implements UploadController {
    private final UploadService uploadService;

    @Override
    public String handleFileUpload(@NonNull MultipartFile xml) {
        try {
            String savedFileName = uploadService.save(xml.getBytes());
            return "redirect:/xml/" + savedFileName;
        } catch (Exception e) {
            return  "Вам не удалось загрузить " + e.getMessage();
        }
    }
}
