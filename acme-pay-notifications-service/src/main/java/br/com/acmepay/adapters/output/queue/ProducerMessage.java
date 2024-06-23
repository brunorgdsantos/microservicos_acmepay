package br.com.acmepay.adapters.output.queue;

public interface ProducerMessage {
    void publishSuccess(String documentRequest);

    void publishFail(String documentRequest);
}
