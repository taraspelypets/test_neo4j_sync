package org.example.controller.impl;

import lombok.RequiredArgsConstructor;
import org.example.controller.RDFController;
import org.example.dto.RDFFetchDTO;
import org.example.dto.RDFInlineDTO;
import org.example.dto.ResponseDTO;
import org.example.service.RDFService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("rdf")
@RequiredArgsConstructor
public class RDFControllerImpl implements RDFController {

    private final RDFService rdfService;
    @Override
    @PutMapping("import/fetch")
    public ResponseDTO importFetch(@RequestBody RDFFetchDTO request) {
        return rdfService.importFetch(request);
    }

    @Override
    @PutMapping("import/inline")
    public ResponseDTO importInline(@RequestBody RDFInlineDTO request) {
        return rdfService.importInline(request);
    }

    @Override
    @PutMapping("import/file")
    public ResponseDTO importFile(@RequestPart("file") MultipartFile file, @RequestPart("request") String requestJson) {
        return rdfService.importFile(file, requestJson);
    }
    @Override
    @DeleteMapping("delete/fetch")
    public ResponseDTO deleteFetch(@RequestBody RDFFetchDTO request) {
        return rdfService.deleteFetch(request);
    }

    @Override
    @DeleteMapping("delete/inline")
    public ResponseDTO deleteInline(@RequestBody RDFInlineDTO request) {
        return rdfService.deleteInline(request);
    }
}
