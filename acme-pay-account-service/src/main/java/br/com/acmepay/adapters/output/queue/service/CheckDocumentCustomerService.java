package br.com.acmepay.adapters.output.queue.service;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.output.queue.ProducerMessage;
import br.com.acmepay.adapters.output.queue.ProducerMessageKafka;
import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.ports.out.ICheckDocumentCustomer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CheckDocumentCustomerService implements ICheckDocumentCustomer {

    private final ProducerMessage producerMessage;

    private final ProducerMessageKafka producerMessageKafka;

    @Override
    public void execute(AccountRequest request) {
        producerMessage.publish(request);
        log.info("Publish successfully to payload {}" , request);
    }

    @Override //FLUXO UTILIZANDO O KAFKA
    public void executeKafka(AccountRequest request) {
        producerMessageKafka.publish(request);
        log.info("Publish successfully to payload {}" , request);
    }
}
