package com.inclub.apibackofficeadmin.infraestructure.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicSuscriptionConfig {

    //Para los Objetos Suscripcion
    @Bean
    public NewTopic generateTopicSuscription() {

        Map<String, String> config = new HashMap<>();
        config.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_COMPACT);
        config.put(TopicConfig.RETENTION_MS_CONFIG, "172800000");
        config.put(TopicConfig.SEGMENT_MS_CONFIG, "604800000");
        config.put(TopicConfig.MIN_COMPACTION_LAG_MS_CONFIG, "86400000");

        return TopicBuilder.name("topic-suscription")
                .partitions(1)
                .replicas(1)
                .build();
    }

    //Bus de Eventos
    @Bean
    public NewTopic generateTopicRequestSuscription() {

        Map<String, String> config = new HashMap<>();
        config.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_COMPACT);
        config.put(TopicConfig.RETENTION_MS_CONFIG, "172800000");
        config.put(TopicConfig.SEGMENT_MS_CONFIG, "604800000");
        config.put(TopicConfig.MIN_COMPACTION_LAG_MS_CONFIG, "86400000");

        return TopicBuilder.name("topic-resquest-suscription")
                .partitions(1)
                .replicas(1)
                .build();
    }



}
