package lemon.core;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncListenerTwo {
    private static final Logger LOGGER = LoggerFactory.getLogger(SyncListenerTwo.class);

    @Subscribe
    public void subscribe(SomeEvent event) throws InterruptedException {
        //Wait 10 seconds
        LOGGER.info("wait 10 seconds");
        Thread.sleep(10000);
        LOGGER.info("I finished");
    }
}
