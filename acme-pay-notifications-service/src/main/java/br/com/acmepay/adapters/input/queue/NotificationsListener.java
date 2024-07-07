package br.com.acmepay.adapters.input.queue;

import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.ports.in.INotificationsListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationsListener {
    @Autowired
    private INotificationsListener notificationsListener;

    @RabbitListener(queues = "queue_check_document")
    public void receiveMessage(String requestListener) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            var doc = objectMapper.readValue(requestListener, DocumentRequest.class);
            notificationsListener.receiveMessage(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
