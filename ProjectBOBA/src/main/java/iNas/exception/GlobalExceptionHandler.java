package iNas.exception;

import iNas.model.response.HttpErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.stream.Collectors;

import static iNas.constant.ErrorMessagesConstants.INTERNAL_SERVER_ERROR_MESSAGE;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpErrorResponse> handleGlobalException(Exception e) {
        log.error("Возникла 500 ошибка: {}", Arrays.stream(e.getStackTrace()).map(el->el.toString()).collect(Collectors.joining()));
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(HttpErrorResponse.builder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .type(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                        .message(INTERNAL_SERVER_ERROR_MESSAGE).build());
    }
}
