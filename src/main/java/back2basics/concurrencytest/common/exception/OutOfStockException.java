package back2basics.concurrencytest.common.exception;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException() {
        super("재고가 모두 소진되었습니다.");
    }
}
