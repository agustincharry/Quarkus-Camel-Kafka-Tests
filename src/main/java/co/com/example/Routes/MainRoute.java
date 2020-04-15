package co.com.example.Routes;

import co.com.example.Services.IMessageService;
import org.apache.camel.builder.RouteBuilder;

import javax.inject.Inject;

public class MainRoute extends RouteBuilder {

    @Inject
    IMessageService messageService;

    @Override
    public void configure() throws Exception {

        from("kafka:my-test?brokers=localhost:9092")
                .log("Message received from Kafka : ${body}")
                .process(exchange -> {
                    System.out.println(exchange.getMessage().toString());
                })
                .end();

    }

}
