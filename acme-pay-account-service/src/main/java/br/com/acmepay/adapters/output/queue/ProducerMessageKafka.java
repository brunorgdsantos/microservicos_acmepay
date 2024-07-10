package br.com.acmepay.adapters.output.queue;

import br.com.acmepay.adapters.input.api.request.AccountRequest;

public interface ProducerMessageKafka {

    void publish(AccountRequest request);
}
