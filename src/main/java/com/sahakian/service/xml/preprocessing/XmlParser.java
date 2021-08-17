package com.sahakian.service.xml.preprocessing;

import lombok.NonNull;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlParser {

    /**
     *
     */
    private static final Pattern digitPattern = Pattern.compile("\\d+");


    /**
     * Recursive parse xml node
     * and convert to {@link XmlNode}
     *
     * @param element xml node
     * @return xml node
     */
    public XmlNode recursiveParseXml(@NonNull Element element) {
        final var key = element.getTagName();
        var children = new ArrayList<XmlNode>();
        long sum = 0;

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);

            if (item.getNodeType() == Node.TEXT_NODE) {
                sum = getSum(sum, (Text) item);
            } else if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) item;
                XmlNode childNode = recursiveParseXml(childElement);
                children.add(childNode);
            }
        }
        return new XmlNode(key, sum, children);
    }


    /**
     * Find digits and calculate sum from text content
     */
    private long getSum(long sum, Text item) {
        Matcher m = digitPattern.matcher(item.getWholeText());
        while (m.find()) {
            long number = Long.parseLong(m.group());
            sum += number;
        }
        return sum;
    }
}
