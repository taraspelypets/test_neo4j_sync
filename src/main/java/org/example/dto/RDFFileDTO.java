package org.example.dto;

import lombok.Data;

import java.util.Map;
@Data
public class RDFFileDTO {
    private String format;
    private Map<String, Object> optionalParams;
}
