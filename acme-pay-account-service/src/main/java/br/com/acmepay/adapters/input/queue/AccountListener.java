package br.com.acmepay.adapters.input.queue;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.ports.in.IAccountListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.DataInput;

@Service
public class AccountListener {

    @Autowired
    private IAccountListener accountListener;

    @RabbitListener(queues = "queue_success_document")
    public void receiveMessage(String requestListener) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            var doc = objectMapper.readValue(requestListener, AccountRequest.class);
            accountListener.receiveMessageSuccess(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
