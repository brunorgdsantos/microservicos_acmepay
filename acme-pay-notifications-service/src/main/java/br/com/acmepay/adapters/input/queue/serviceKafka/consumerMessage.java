package br.com.acmepay.adapters.input.queue.serviceKafka;

import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.ports.in.INotificationsListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class consumerMessage {

    @Autowired
    private INotificationsListener notificationsListener;

    @KafkaListener(topics = "topic1", groupId = "grupoTopic1")
    public void receiveMessage(String requestListener) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            var doc = objectMapper.readValue(requestListener, DocumentRequest.class);
            notificationsListener.receiveMessageKafka(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
