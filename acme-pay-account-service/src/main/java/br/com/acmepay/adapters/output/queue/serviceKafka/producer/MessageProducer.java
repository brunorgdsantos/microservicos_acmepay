package br.com.acmepay.adapters.output.queue.serviceKafka.producer;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.output.queue.ProducerMessageKafka;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class MessageProducer implements ProducerMessageKafka {

    private final KafkaTemplate<String, String> template;

    @Override
    public void publish(AccountRequest request) { //FLUXO UTILIZANDO O KAFKA
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            log.info("Publishing : Payload {}", request);
            this.template.send("topic1", objectMapper.writeValueAsString(request));
            this.template.send("transactions", objectMapper.writeValueAsString(request));
            log.info("Published : Payload {} ", request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
