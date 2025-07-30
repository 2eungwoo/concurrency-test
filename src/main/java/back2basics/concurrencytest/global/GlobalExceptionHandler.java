package back2basics.concurrencytest.global;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import back2basics.concurrencytest.common.exception.EventClosedException;
import back2basics.concurrencytest.common.exception.OutOfStockException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EventClosedException.class)
    protected ResponseEntity<ApiResponse> handleEventClosedException(Exception e) {
        return ResponseEntity
            .status(INTERNAL_SERVER_ERROR)
            .body(ApiResponse.fail(e.getMessage()));
    }

    @ExceptionHandler(OutOfStockException.class)
    protected ResponseEntity<ApiResponse> handleOutOfStockException(Exception e) {
        return ResponseEntity
            .status(INTERNAL_SERVER_ERROR)
            .body(ApiResponse.fail(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiResponse> handleException(Exception e) {
        return ResponseEntity
            .status(INTERNAL_SERVER_ERROR)
            .body(ApiResponse.fail(e.getMessage()));
    }
}