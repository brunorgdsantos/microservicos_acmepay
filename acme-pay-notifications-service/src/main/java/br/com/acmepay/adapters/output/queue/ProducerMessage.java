package br.com.acmepay.adapters.output.queue;

import br.com.acmepay.adapters.input.api.request.NotificationsRequest;
import br.com.acmepay.adapters.request.DocumentRequest;

public interface ProducerMessage {
    void publishSuccess(DocumentRequest documentRequest);

    void publishFail(DocumentRequest documentRequest);
}
