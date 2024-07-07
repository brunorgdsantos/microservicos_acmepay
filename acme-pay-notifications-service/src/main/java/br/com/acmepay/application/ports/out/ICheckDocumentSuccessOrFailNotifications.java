package br.com.acmepay.application.ports.out;

import br.com.acmepay.adapters.input.api.request.NotificationsRequest;
import br.com.acmepay.adapters.request.DocumentRequest;

public interface ICheckDocumentSuccessOrFailNotifications {
    void executeSuccess(DocumentRequest request);

    void executeFail(DocumentRequest request);
}
