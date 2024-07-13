package br.com.acmepay.application.ports.in;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.input.queue.AccountListener;
import br.com.acmepay.adapters.request.DocumentRequest;

public interface IAccountListener {
    public void receiveMessageSuccess(AccountRequest requestListener);
}
