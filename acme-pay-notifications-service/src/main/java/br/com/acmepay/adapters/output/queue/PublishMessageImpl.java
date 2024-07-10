package br.com.acmepay.adapters.output.queue;

import br.com.acmepay.adapters.input.api.request.NotificationsRequest;
import br.com.acmepay.adapters.request.DocumentRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PublishMessageImpl implements ProducerMessage{

    private final RabbitTemplate rabbitTemplate;

    private final KafkaTemplate<String, String> template;

    @Override
    public void publishSuccess(DocumentRequest documentRequest) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            log.info("Publishing : Payload {} / Queue {}", documentRequest, "queue_success_document");
            //this.rabbitTemplate.convertSendAndReceive("queue_success_document", objectMapper.writeValueAsString(documentRequest)); //FLUXO RABBITMQ
            this.template.send("topic1", objectMapper.writeValueAsString(documentRequest));
            log.info("Published : Payload {} / Queue {}", documentRequest, "queue_success_document");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void publishSuccessKafka(DocumentRequest documentRequest) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            log.info("Publishing : Payload {} / Queue {}", documentRequest, "queue_success_document");
            this.rabbitTemplate.convertSendAndReceive("queue_success_document", objectMapper.writeValueAsString(documentRequest));
            log.info("Published : Payload {} / Queue {}", documentRequest, "queue_success_document");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void publishFail(DocumentRequest documentRequest) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            log.info("Publishing : Payload {} / Queue {}", documentRequest, "queue_fail_document");
            this.rabbitTemplate.convertSendAndReceive("queue_fail_document", objectMapper.writeValueAsString(documentRequest));
            log.info("Published : Payload {} / Queue {}", documentRequest, "queue_fail_document");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
