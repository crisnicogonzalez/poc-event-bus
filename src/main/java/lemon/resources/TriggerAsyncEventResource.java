package lemon.resources;


import lemon.core.AsyncEventBusFactory;
import lemon.core.EventBusFactory;
import lemon.core.SomeEvent;
import lemon.core.SyncListenerOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/trigger-async-event")
@Produces(MediaType.APPLICATION_JSON)
public class TriggerAsyncEventResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(TriggerAsyncEventResource.class);


    public TriggerAsyncEventResource() {
    }

    @POST
    public Response triggerEvent() {
        LOGGER.info("received request");
        AsyncEventBusFactory.getEventBus().post(new SomeEvent("some event"));
        LOGGER.info("return response");
        return Response.ok().build();
    }
}
