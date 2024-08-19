package org.example.service;

import org.example.dto.RDFFetchDTO;
import org.example.dto.RDFInlineDTO;
import org.example.dto.ResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface RDFService {
    ResponseDTO importFetch(RDFFetchDTO request);
    ResponseDTO importInline(RDFInlineDTO request);
    ResponseDTO importFile(MultipartFile file, String request);
    ResponseDTO deleteFetch(RDFFetchDTO request);
    ResponseDTO deleteInline(RDFInlineDTO request);
}
