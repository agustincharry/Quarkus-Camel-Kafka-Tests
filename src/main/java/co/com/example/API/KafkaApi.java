package co.com.example.API;

import co.com.example.Models.MessageModel;
import co.com.example.Services.IMessageService;
import org.apache.camel.ProducerTemplate;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/kafka/message")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KafkaApi {

    @Inject
    ProducerTemplate producerTemplate;

    @POST
    public Response addMessage(MessageModel message) {
        producerTemplate.requestBody("direct:sendToKafka", message.getMessage(), String.class);
        return Response.status(Response.Status.CREATED).entity(message).build();
    }

}