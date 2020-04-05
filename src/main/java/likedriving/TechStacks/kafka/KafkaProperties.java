package likedriving.TechStacks.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public interface KafkaProperties {
    String bootstrapServers = "bootstrap.servers";
    String enableAutoCommit = "enable.auto.commit";
    String autoCommitInterval = "auto.commit.interval.ms";
    String sessionTimeout = "session.timeout.ms";
    String keySerializer = "key.serializer";
    String valueSerializer = "value.serializer";
    String keyDeserializer = "key.deserializer";
    String valueDeserializer = "value.deserializer";
    String groupId = "group.id";
    String linger = "linger.ms";
    String retries = "retries";
    String heartbeatInterval = "heartbeat.interval.ms";
    String groupMinSessionTimeout = "group.min.session.timeout.ms";
    String groupMaxSessionTimeout = "group.max.session.timeout.ms";
    String topics = "topics";

    static KafkaConfiguration loadConfiguration() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.findAndRegisterModules();
        return objectMapper.readValue(new File("/Users/kunal.singh1/projects/incubator/src/main/java/likedriving/TechStacks/kafka/KafkaConfiguration.yml"), KafkaConfiguration.class);
    }
}
