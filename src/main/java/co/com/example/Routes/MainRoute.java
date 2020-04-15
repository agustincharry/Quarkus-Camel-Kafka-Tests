package co.com.example.Routes;

import co.com.example.Services.IMessageService;
import co.com.example.config.AppVariables;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MainRoute extends RouteBuilder {

    @Inject
    IMessageService messageService;

    @Inject
    AppVariables appVariables;


    @Override
    public void configure() throws Exception {

        from("kafka:" + appVariables.getKafkaTopic() + "?brokers=" + appVariables.getKafkaBroker())
                .log("Nuevo mensaje desde Kafka: \"${body}\"")
                .process(exchange -> {
                    String message = exchange.getIn().getBody().toString();
                    this.messageService.addMessage(message);
                })
                .end();


        from("direct:sendToKafka")
                .log("Enviando mensaje a Kakfa: \"${body}\"")
                .to("kafka:" + appVariables.getKafkaTopic() + "?brokers=" + appVariables.getKafkaBroker())
                .end();
    }

}
