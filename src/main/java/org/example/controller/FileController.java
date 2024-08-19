package org.example.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface FileController {

    ResponseEntity<Resource> serve(String filename);
}
