package back2basics.concurrencytest.common.exception;

public class EventClosedException extends RuntimeException {
    public EventClosedException() {
        super("이벤트가 마감되었습니다.");
    }
}
