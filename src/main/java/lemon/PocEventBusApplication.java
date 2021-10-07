package lemon;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lemon.core.AsyncEventBusFactory;
import lemon.core.EventBusFactory;
import lemon.core.SyncListenerOne;
import lemon.core.SyncListenerTwo;
import lemon.resources.TriggerAsyncEventResource;
import lemon.resources.TriggerEventResource;

public class PocEventBusApplication extends Application<PocEventBusConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PocEventBusApplication().run(args);
    }

    @Override
    public String getName() {
        return "poc-event-bus";
    }

    @Override
    public void initialize(final Bootstrap<PocEventBusConfiguration> bootstrap) {
        // TODO: application initialization
        EventBusFactory.getEventBus().register(new SyncListenerOne());
        //EventBusFactory.getEventBus().register(new SyncListenerTwo());
        AsyncEventBusFactory.getEventBus().register(new SyncListenerOne());
        AsyncEventBusFactory.getEventBus().register(new SyncListenerTwo());

    }

    @Override
    public void run(final PocEventBusConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new TriggerEventResource());
        environment.jersey().register(new TriggerAsyncEventResource());
    }

}
