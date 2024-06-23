package br.com.acmepay.adapters.output.queue;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PublishMessageImpl implements ProducerMessage{

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publishSuccess(String documentRequest) {
        log.info("Publishing : Payload {} / Queue {}", documentRequest, "queue_success_document");
        this.rabbitTemplate.convertSendAndReceive("queue_success_document", documentRequest);
        log.info("Published : Payload {} / Queue {}", documentRequest, "queue_success_document");
    }

    @Override
    public void publishFail(String documentRequest) {
        log.info("Publishing : Payload {} / Queue {}", documentRequest, "queue_fail_document");
        this.rabbitTemplate.convertSendAndReceive("queue_fail_document", documentRequest);
        log.info("Published : Payload {} / Queue {}", documentRequest, "queue_fail_document");
    }
}
