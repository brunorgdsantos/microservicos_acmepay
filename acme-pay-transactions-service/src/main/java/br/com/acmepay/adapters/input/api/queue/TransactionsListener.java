package br.com.acmepay.adapters.input.api.queue;

import br.com.acmepay.adapters.application.ports.in.AccountRequest;
import br.com.acmepay.adapters.input.api.response.TransactionsResponse;
import br.com.acmepay.application.ports.in.ITransactionsListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class TransactionsListener {

    @Autowired
    private ITransactionsListener transactionsListener;

    @KafkaListener(topics = "transactions", groupId = "grupoTopic1")
    public void receiveMessage(@Payload String requestListener) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            var doc = objectMapper.readValue(requestListener, AccountRequest.class);
            transactionsListener.receiveMessageSuccess(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}