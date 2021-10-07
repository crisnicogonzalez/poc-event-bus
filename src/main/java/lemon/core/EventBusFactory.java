package lemon.core;

import com.google.common.eventbus.EventBus;

public class EventBusFactory {
    //hold the instance of the event bus here
    private static EventBus eventBus = new EventBus();

    public static EventBus getEventBus() {
        return eventBus;
    }
}
