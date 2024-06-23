package br.com.acmepay.adapters.input.queue;

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
        notificationsListener.receiveMessage(requestListener);
    }
}
