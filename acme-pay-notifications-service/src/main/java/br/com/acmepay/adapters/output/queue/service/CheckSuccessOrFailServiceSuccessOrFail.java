package br.com.acmepay.adapters.output.queue.service;

import br.com.acmepay.adapters.output.queue.ProducerMessage;
import br.com.acmepay.application.ports.out.ICheckDocumentSuccessOrFailNotifications;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CheckSuccessOrFailServiceSuccessOrFail implements ICheckDocumentSuccessOrFailNotifications {

    private final ProducerMessage producerMessage;

    @Override
    public void executeSuccess(String request) {
        producerMessage.publishSuccess(request);
        log.info("Publish successfully to payload {}" , request);
    }

    @Override
    public void executeFail(String request) {
        producerMessage.publishFail(request);
        log.info("Publish fail to payload {}" , request);
    }
}
