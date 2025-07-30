package back2basics.concurrencytest.global;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import back2basics.concurrencytest.common.exception.EventClosedException;
import back2basics.concurrencytest.common.exception.OutOfStockException;
import jakarta.persistence.OptimisticLockException;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
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

    @ExceptionHandler({OptimisticLockException.class, ObjectOptimisticLockingFailureException.class})
    protected ResponseEntity<ApiResponse> handleOptimisticLock(Exception e) {
        return ResponseEntity.status(409).body(ApiResponse.fail("동시 수정 충돌 발생: " + e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiResponse> handleException(Exception e) {
        return ResponseEntity
            .status(INTERNAL_SERVER_ERROR)
            .body(ApiResponse.fail(e.getMessage()));
    }
}