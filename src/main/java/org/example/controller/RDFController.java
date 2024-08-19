package org.example.controller;

import org.example.dto.RDFFetchDTO;
import org.example.dto.RDFInlineDTO;
import org.example.dto.ResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface RDFController {
    ResponseDTO importFetch(RDFFetchDTO request);
    ResponseDTO importInline(RDFInlineDTO request);
    ResponseDTO importFile(MultipartFile file, String request);
    ResponseDTO deleteFetch(RDFFetchDTO request);
    ResponseDTO deleteInline(RDFInlineDTO request);
}