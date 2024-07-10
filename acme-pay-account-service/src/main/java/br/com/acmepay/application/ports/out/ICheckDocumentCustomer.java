package br.com.acmepay.application.ports.out;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.request.DocumentRequest;

public interface ICheckDocumentCustomer {
    void execute(AccountRequest request);

    void executeKafka(AccountRequest request);
}
