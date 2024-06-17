package br.com.acmepay.adapters.output.queue.service;

import br.com.acmepay.adapters.output.queue.ProducerMessage;
import br.com.acmepay.application.ports.out.ICheckDocumentNotifications;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CheckSuccessOrFailService implements ICheckDocumentNotifications {

    private final ProducerMessage producerMessage;

    @Override
    public void execute(String request) {
        producerMessage.publish(request);
        log.info("Publish successfully to payload {}" , request);
    }
}
