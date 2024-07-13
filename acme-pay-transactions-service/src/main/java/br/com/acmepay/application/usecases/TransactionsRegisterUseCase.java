package br.com.acmepay.application.usecases;

import br.com.acmepay.adapters.application.ports.in.AccountRequest;
import br.com.acmepay.adapters.input.api.response.TransactionsResponse;
import br.com.acmepay.application.ports.in.ITransactionsListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionsRegisterUseCase implements ITransactionsListener {
    @Override
    public void receiveMessageSuccess(AccountRequest transactionsResponse) {
        System.out.println("Received message: " + transactionsResponse.getDocument());
    }
}
