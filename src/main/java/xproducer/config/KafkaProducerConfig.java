package xproducer.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 生产者配置
 * Created by SYJ on 2017/11/20.
 */
@Configuration
@EnableKafka
public class KafkaProducerConfig {

    /**
     * kafka服务器ip地址
     */
    @Value("${kafka.producer.servers}")
    private String BOOTSTRAP_SERVERS_CONFIG;
    /**
     * 消息的确认机制:0, 1, all(或-1),默认值为1
     */
    @Value("${spring.kafka.producer.acks}")
    private String ACKS_CONFIG;
    /**
     * 消息发送失败后的重试次数,默认值为0
     */
    @Value("${kafka.producer.retries}")
    private String RETRIES_CONFIG;
    /**
     * 批量发送的字节数,默认16KB
     */
    @Value("${kafka.producer.batch.size}")
    private String BATCH_SIZE_CONFIG;
    /**
     * 每次批量发送后的延迟毫秒数,默认值为0
     */
    @Value("${kafka.producer.linger}")
    private String LINGER_MS_CONFIG;
    /**
     * 缓冲区大小(字节),默认32M
     */
    @Value("${kafka.producer.buffer.memory}")
    private String BUFFER_MEMORY_CONFIG;

    public Map<String, Object> producerConfig(){
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
        props.put(ProducerConfig.ACKS_CONFIG, ACKS_CONFIG);
        props.put(ProducerConfig.RETRIES_CONFIG, RETRIES_CONFIG);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, BATCH_SIZE_CONFIG);
        props.put(ProducerConfig.LINGER_MS_CONFIG, LINGER_MS_CONFIG);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, BUFFER_MEMORY_CONFIG);
        /**
         * key的序列化类
         */
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        /**
         * value的序列化类
         */
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return props;
    }

    public ProducerFactory<String, String> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}