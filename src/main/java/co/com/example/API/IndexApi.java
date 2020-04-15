package co.com.example.API;

import co.com.example.config.AppVariables;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class IndexApi {

    @Inject
    AppVariables appVariables;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus! Kafka Config.... Topic: " + appVariables.getKafkaTopic() + ", Broker: " + appVariables.getKafkaBroker();
    }

}