package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.utils.Bytes;

import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Sender {

    private class DemoProducerCallback implements Callback {
        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if (e != null) {
                e.printStackTrace();
            }
        }
    }

    public void send() {


        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer",
                "org.apache.kafka.common.serialization.BytesSerializer");

        try (KafkaProducer<String, Bytes> producer = new KafkaProducer<>(kafkaProps)) {

            for (int i = 0; i < 5; i++) {
                Customer customer = CustomerGenerator.generateCustomer();
                Bytes bytes = new Bytes(new ObjectMapper().writeValueAsBytes(customer));
                ProducerRecord<String, Bytes> producerRecord = new ProducerRecord<>(
                        "Customers", customer.getName(), bytes);
                Future<RecordMetadata> send = producer.send(producerRecord);
                System.out.println(send.get());
                Thread.sleep(2000);
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
//
//
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("group.id", "CountryCounter");
//        props.put("key.deserializer",
//                "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer",
//                "org.apache.kafka.common.serialization.StringDeserializer");
//        try (KafkaConsumer<String, String> consumer =
//                     new KafkaConsumer<>(props)) {
//            consumer.subscribe(List.of("Test", "CustomerCountry"));
//
//            Duration timeout = Duration.ofMillis(100);
//            while (true) {
//                ConsumerRecords<String, String> records = consumer.poll(timeout);
//                for (ConsumerRecord<String, String> record : records) {
//                    System.out.printf("topic = %s, partition = %d, offset = %d, " +
//                            "customer = %s, country = %s\n",
//                    record.topic(), record.partition(), record.offset(),
//                            record.key(), record.value());
//
//                }
//            }
//        }
    }
}
