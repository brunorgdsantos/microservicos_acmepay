package br.com.acmepay.adapters.input.service;

import br.com.acmepay.application.ports.in.INotificationsListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationsListener {
    @Autowired
    private INotificationsListener notificationsListener;

    @RabbitListener(queues = "queue_check_document")
    public void receiveMessage(String requestListener) {
        notificationsListener.receiveMessage(requestListener); //TA VINDO UMA STRINDO DO TIPO: DocumentRequest(document=999)
        //NÃO ESTA VINDO UMA STRING DO TIPO: 999 COMO DEVERIA
    }
}
