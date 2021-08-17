package com.sahakian.service.xml.preprocessing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class XmlNodeConverter {

    /**
     * Generate json node from xml node
     *
     * @param xmlNode {@link XmlNode}
     * @return json node
     */
    public static JsonNode convertToJson(XmlNode xmlNode) {
        var objectNode = new ObjectNode( JsonNodeFactory.instance);

        objectNode.set("value", new TextNode(String.valueOf(xmlNode.getChildrenIncludedValue())));

        for (XmlNode child : xmlNode.getChildren()) {
            objectNode.set(child.getKey(), convertToJson(child));
        }
        return objectNode;
    }
}
