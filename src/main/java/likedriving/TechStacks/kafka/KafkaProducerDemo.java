package likedriving.TechStacks.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static java.lang.Thread.sleep;

@Slf4j
public class KafkaProducerDemo {

    public static Properties getProducerProperties(KafkaConfiguration kafkaConfiguration){
        Properties properties = new Properties();
        properties.put(KafkaProperties.bootstrapServers, kafkaConfiguration.getBootstrapServers());
        properties.put(KafkaProperties.linger, kafkaConfiguration.getLinger());
        properties.put(KafkaProperties.retries, 0);
        properties.put(KafkaProperties.keySerializer, kafkaConfiguration.getKeySerializer());
        properties.put(KafkaProperties.valueSerializer, kafkaConfiguration.getValueSerializer());
        return properties;
    }

    public static KafkaProducer create(KafkaConfiguration kafkaConfiguration){
        KafkaProducer kafkaProducer = new KafkaProducer(getProducerProperties(kafkaConfiguration));
        return kafkaProducer;
    }

    public static void sendRecords(KafkaProducer kafkaProducer, KafkaConfiguration kafkaConfiguration ) throws InterruptedException {

        List<String> topics = kafkaConfiguration.getTopics();

        int messageCounter = 0;
        while(true) {
            String messageValue = "Hello kafka "+messageCounter;
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topics.get(0), "KafkaMessage"+messageCounter, messageValue);
            kafkaProducer.send(producerRecord);
            //kafkaProducer.close();
            log.info("Kafka producer called with message "+messageValue);
            sleep(3000);
            messageCounter++;
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        KafkaConfiguration kafkaConfiguration = KafkaProperties.loadConfiguration();
        KafkaProducer kafkaProducer = create(kafkaConfiguration);
        sendRecords(kafkaProducer, kafkaConfiguration);
    }
}
