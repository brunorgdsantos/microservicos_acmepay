package br.com.acmepay.adapters.output.queue;

public interface ProducerMessage {
    void publish(String documentRequest);
}
