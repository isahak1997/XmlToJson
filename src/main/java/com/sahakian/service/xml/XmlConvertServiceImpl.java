package com.sahakian.service.xml;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sahakian.service.xml.preprocessing.XmlProcessing;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

@Service
public class XmlConvertServiceImpl implements XmlConverterService {

    @Override
    public ObjectNode toJsonFile(@NonNull File xml) throws IOException, SAXException {
        return new XmlProcessing(xml).parseToJson();
    }
}
