package com.sahakian.controller.xml;

import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

public interface XmlConverterController {

    /**
     * Get converted file
     *
     * @param name
     * @return json file
     * @throws IOException upload file io exception
     */
    @ResponseBody
    @GetMapping(value = "/xml/{name}", produces = "application/json")
    ResponseEntity<?> toJsonObject(@NonNull @PathVariable("name") String name) throws IOException;
}
