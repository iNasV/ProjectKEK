package iNas.bibaProj.exception;

import iNas.bibaProj.model.response.HttpErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static iNas.bibaProj.constant.ErrorMessagesConstants.INTERNAL_SERVER_ERROR_MESSAGE;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpErrorResponse> handleGlobalException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(HttpErrorResponse.builder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .type(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                        .message(INTERNAL_SERVER_ERROR_MESSAGE).build());
    }
}
