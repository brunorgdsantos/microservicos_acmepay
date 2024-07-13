package br.com.acmepay.application.ports.in;

import br.com.acmepay.adapters.application.ports.in.AccountRequest;
import br.com.acmepay.adapters.input.api.response.TransactionsResponse;

public interface ITransactionsListener {
    public void receiveMessageSuccess(AccountRequest transactionsResponse);
}
