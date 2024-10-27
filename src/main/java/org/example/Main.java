package org.example;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {


    public static void main(String[] args) {
        new Sender().send();

        //  System.out.println(send.get());
//        } catch (ExecutionException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//
//            Properties props = new Properties();
//            props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//            props.put(ConsumerConfig.GROUP_ID_CONFIG, "1");
//            props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//            props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//
//            // Create the consumer
//            Consumer<String, String> consumer = new KafkaConsumer<>(props);
//
//            // Subscribe to the topic
//            consumer.subscribe(Collections.singletonList("Messages"));
//
//            // Continuously poll for new messages
//            try {
//                while (true) {
//                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
//                    for (ConsumerRecord<String, String> consumerRecord : records) {
//                        System.out.printf("offset = %d, key = %s, value = %s%n", consumerRecord.offset(), consumerRecord.key(), consumerRecord.value());
//                    }
//                }
//            } finally {
//                // Close the consumer
//                consumer.close();
//            }

    }
}