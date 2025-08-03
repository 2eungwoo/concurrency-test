package back2basics.concurrencytest.core.coffee.order.utils;

import org.springframework.stereotype.Component;

@Component
public class SleepTimer {

    private final int SLEEP_TIME = 100;

    public void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
