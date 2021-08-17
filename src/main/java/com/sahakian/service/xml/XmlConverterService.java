package com.sahakian.service.xml;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.NonNull;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public interface XmlConverterService {
    ObjectNode toJsonFile(@NonNull File xml) throws IOException, SAXException;
}
