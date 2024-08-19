package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.dto.RDFFetchDTO;
import org.example.dto.RDFFileDTO;
import org.example.dto.RDFInlineDTO;
import org.example.dto.ResponseDTO;
import org.example.n10s.NeosemanticsProcedures;
import org.example.service.RDFService;
import org.example.service.StorageService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class RDFServiceImpl implements RDFService {

    private final NeosemanticsProcedures n10s;
    private final StorageService storageService;

    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public ResponseDTO importFetch(RDFFetchDTO request) {
        Map<String, Object> record = n10s.importFetch(request.getUrl(), request.getFormat(), request.getOptionalParams());
        return mapper.convertValue(record, ResponseDTO.class);
    }

    @Override
    public ResponseDTO importInline(RDFInlineDTO request) {
        Map<String, Object> record = n10s.importInline(request.getInlineRDF(), request.getFormat(), request.getOptionalParams());
        return mapper.convertValue(record, ResponseDTO.class);
    }

    @SneakyThrows
    @Override
    public ResponseDTO importFile(MultipartFile file, String requestJson) {
        String filename = storageService.store(file);
        RDFFileDTO request = mapper.readValue(requestJson, RDFFileDTO.class);

        Map<String, Object> record = n10s.importFetch(storageService.getUrl(filename), request.getFormat(), request.getOptionalParams());

        storageService.delete(filename);

        return mapper.convertValue(record, ResponseDTO.class);
    }

    @Override
    public ResponseDTO deleteFetch(RDFFetchDTO request) {
        Map<String, Object> record = n10s.deleteFetch(request.getUrl(), request.getFormat(), request.getOptionalParams());
        return mapper.convertValue(record, ResponseDTO.class);
    }

    @Override
    public ResponseDTO deleteInline(RDFInlineDTO request) {
        Map<String, Object> record = n10s.deleteInline(request.getInlineRDF(), request.getFormat(), request.getOptionalParams());
        return mapper.convertValue(record, ResponseDTO.class);
    }
}
