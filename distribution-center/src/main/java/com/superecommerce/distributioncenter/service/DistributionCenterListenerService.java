package com.superecommerce.distributioncenter.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Service
public class DistributionCenterListenerService {
    private static AtomicInteger COUNTER = new AtomicInteger(0);

    @Value("${topic.name.consumer}")
    private String topicName;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;


    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: {}", topicName);
        log.info("GroupId: {}", groupId);
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partion: {}", payload.partition());
        log.info("Order: {}", payload.value());
        log.info("Aplicação consumiu " + increment() + " mensagens!");
    }

    public int increment() {
        return COUNTER.incrementAndGet();
    }
}