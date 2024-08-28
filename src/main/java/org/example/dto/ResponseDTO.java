package org.example.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ResponseDTO {
    private String terminationStatus;
    private Long triplesLoaded;
    private Long triplesParsed;
    private Long triplesDeleted;
    private Map<String, Object> namespaces;
    private String extraInfo;
    private Map<String, Object> callParams;
}
