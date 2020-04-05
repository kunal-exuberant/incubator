package likedriving.TechStacks.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class KafkaConfiguration {

    @JsonProperty("bootstrap.servers")
    private String bootstrapServers;

    @JsonProperty("zookeeper")
    private String zookeeper;

    @JsonProperty("enable.auto.commit")
    private String enableAutoCommit;

    @JsonProperty("auto.commit.interval.ms")
    private String autoCommitInterval;

    @JsonProperty("session.timeout.ms")
    private Integer sessionTimeout;

    @JsonProperty("key.serializer")
    private String keySerializer;

    @JsonProperty("value.serializer")
    private String valueSerializer;

    @JsonProperty("key.deserializer")
    private String keyDeserializer;

    @JsonProperty("value.deserializer")
    private String valueDeserializer;

    @JsonProperty("group.id")
    private String groupId;

    @JsonProperty("linger.ms")
    private String linger;

    @JsonProperty("retries")
    private String retries;

    @JsonProperty("heartbeat.interval.ms")
    private Integer heartbeatInterval;

    @JsonProperty("group.min.session.timeout.ms")
    private Integer groupMinSessionTimeout;

    @JsonProperty("group.max.session.timeout.ms")
    private Integer groupMaxSessionTimeout;

    private List<String> topics;

}
