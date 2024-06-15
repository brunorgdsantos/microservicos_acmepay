package br.com.acmepay.adapters.input.service;

import br.com.acmepay.adapters.input.api.request.NotificationsRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class accountListener {
    @RabbitListener(queues = "queue_check_document")
    public void receiveMessage(String request) {
        System.out.println(request);
    }
}
