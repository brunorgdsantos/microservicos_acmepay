package br.com.acmepay.adapters.output.queue;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.request.DocumentRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PublishMessageImpl implements ProducerMessage{

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(AccountRequest request) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            log.info("Publishing : Payload {} / Queue {}", request, "queue_check_document");
            this.rabbitTemplate.convertSendAndReceive("queue_check_document", objectMapper.writeValueAsString(request));
            log.info("Published : Payload {} / Queue {}", request, "queue_check_document");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
