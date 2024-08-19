package org.example.advice;

import org.example.dto.ResponseDTO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ResponseCodeAdvice implements ResponseBodyAdvice<ResponseDTO> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return ResponseDTO.class.equals(returnType.getGenericParameterType());
    }

    @Override
    public ResponseDTO beforeBodyWrite(ResponseDTO body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body == null
                || body.getTerminationStatus() == null
                || body.getTerminationStatus().equals("KO")){

            response.setStatusCode(BAD_REQUEST);
        }
        return body;
    }
}
