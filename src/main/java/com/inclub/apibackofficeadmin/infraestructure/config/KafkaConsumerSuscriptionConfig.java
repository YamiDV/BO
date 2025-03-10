package com.inclub.apibackofficeadmin.infraestructure.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.inclub.apibackofficeadmin.domain.models.Membresias.Suscription;

import org.apache.kafka.common.serialization.StringDeserializer;

import org.springframework.kafka.support.serializer.JsonDeserializer;
import java.lang.Object;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerSuscriptionConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ConsumerFactory<String, Suscription> suscriptionConsumerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "suscription-group");
        configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(),
                new JsonDeserializer<>(Suscription.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Suscription> suscriptionKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Suscription> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(suscriptionConsumerFactory());
        return factory;
    }
}
