package xproducer.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

/**
 * Created by SYJ on 2017/11/20.
 */
@Service
public class TestService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 发送消息
     * @param topic
     * @param data
     * @return
     */
    public String send(String topic, String data){
        String key = UUID.randomUUID().toString();
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, data);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("ex=" + ex.getMessage() + ", topic=" + topic + ", key=" + key + ", data=" + data);
            }
            @Override
            public void onSuccess(SendResult<String, String> result) {
                ProducerRecord<String, String> producerRecord = result.getProducerRecord();
                RecordMetadata recordMetadata = result.getRecordMetadata();

                System.out.println(producerRecord.toString() + ",偏移量=" + recordMetadata.offset() + ",分区=" + recordMetadata.partition());
            }
        });
        return "success";
    }
}
