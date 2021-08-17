package com.sahakian.service.xml.preprocessing;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

import static com.sahakian.service.xml.preprocessing.XmlNodeConverter.convertToJson;

public record XmlProcessing(File xml) {
    private static final ObjectNode rootNode;
    private static final DocumentBuilder builder;
    private static final XmlParser parser;

    static {
        rootNode = loadObjectNode();
        builder = loadDocumentBuilder();
        parser = new XmlParser();
    }

    /**
     * Parse xml file and generate json node
     *
     * @return json node
     * @throws IOException io exceptions
     * @throws SAXException xml parse exceptions
     */
    public ObjectNode parseToJson() throws IOException, SAXException {
        var document = builder.parse(xml);
        var xmlNode = parser.recursiveParseXml(document.getDocumentElement());
        var jsonNode = convertToJson(xmlNode);
        rootNode.set(xmlNode.getKey(), jsonNode);
        return rootNode;
    }

    private static ObjectNode loadObjectNode() {
        return new ObjectNode(JsonNodeFactory.instance);
    }

    @SneakyThrows
    private static DocumentBuilder loadDocumentBuilder() {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }
}
