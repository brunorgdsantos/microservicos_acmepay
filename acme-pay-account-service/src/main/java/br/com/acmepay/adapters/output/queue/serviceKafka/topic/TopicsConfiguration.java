package br.com.acmepay.adapters.output.queue.serviceKafka.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class TopicsConfiguration {
    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("transactions")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("topic2")
                .partitions(10)
                .replicas(1)
                .build();
    }
}
