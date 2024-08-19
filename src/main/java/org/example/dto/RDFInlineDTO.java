package org.example.dto;

import lombok.Data;

import java.util.Map;

@Data
public class RDFInlineDTO {
    private String inlineRDF;
    private String format;
    private Map<String, Object> optionalParams;
}
