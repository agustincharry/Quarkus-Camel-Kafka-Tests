package co.com.example.API;

import co.com.example.Models.MessageModel;
import co.com.example.Services.IMessageService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/message")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageApi {

    @Inject
    IMessageService messageService;

    @GET
    @Path("/{id}")
    public MessageModel getOneMessage(@PathParam("id") String id) {
        return this.messageService.getOneMessage(id);
    }

    @GET
    public List<MessageModel> getAllMessage() {
        return this.messageService.getAllMessages();
    }

    @POST
    public Response addMessage(MessageModel message) {
        MessageModel messageResponse = this.messageService.addMessage(message);
        return Response.status(Response.Status.CREATED).entity(messageResponse).build();
    }

    @DELETE
    @Path("/{id}")
    public MessageModel removeMessage(@PathParam("id") String id) {
        return this.messageService.removeMessage(id);
    }

}
