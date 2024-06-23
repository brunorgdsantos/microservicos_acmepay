package br.com.acmepay.adapters.input.queue;

import br.com.acmepay.application.ports.in.IAccountListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountListener {

    @Autowired
    private IAccountListener accountListener;

    @RabbitListener(queues = "queue_success_document")
    public void receiveMessage(String requestListener) {
        accountListener.receiveMessageSuccess(requestListener);
    }
}
