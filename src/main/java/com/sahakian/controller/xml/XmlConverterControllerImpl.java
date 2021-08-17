package com.sahakian.controller.xml;

import com.sahakian.service.storage.StorageManager;
import com.sahakian.service.xml.XmlConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class XmlConverterControllerImpl implements XmlConverterController {
    private final XmlConverterService xmlConverterService;
    private final StorageManager storageManager;

    @Override
    public ResponseEntity<?> toJsonObject(String name) {
        try {
            var xml = storageManager.findByName(name);
            var json = xmlConverterService.toJsonFile(xml);
            return new ResponseEntity<>(json, HttpStatus.OK);
        } catch (IOException | SAXException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
