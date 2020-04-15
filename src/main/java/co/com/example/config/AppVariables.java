package co.com.example.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AppVariables {

    @ConfigProperty(name = "kafka.topic", defaultValue = "test")
    private String kafkaTopic;

    @ConfigProperty(name = "kafka.broker", defaultValue = "localhost:9092")
    private String kafkaBroker;

    public String getKafkaTopic() {
        return kafkaTopic;
    }

    public String getKafkaBroker() {
        return kafkaBroker;
    }
}
