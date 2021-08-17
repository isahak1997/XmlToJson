package com.sahakian.service.xml.preprocessing;

import lombok.Getter;

import java.util.List;


public class XmlNode {

    @Getter
    private final String key;

    @Getter
    private final long value;

    @Getter
    private final List<XmlNode> children;
    private long childrenValuesSum = -1;

    public XmlNode(String key, long value, List<XmlNode> children) {
        this.key = key;
        this.value = value;
        this.children = children;
    }

    /**
     * Calculate children value sum
     *
     * @return sum
     */
    public long getChildrenIncludedValue() {
        if (childrenValuesSum == -1) {
            childrenValuesSum = children
                    .stream()
                    .mapToLong(XmlNode::getChildrenIncludedValue)
                    .sum() + value;
        }
        return childrenValuesSum;
    }
}
