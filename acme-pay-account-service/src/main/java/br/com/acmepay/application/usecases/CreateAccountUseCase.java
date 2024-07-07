package br.com.acmepay.application.usecases;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.input.queue.AccountListener;
import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.ports.in.IAccountListener;
import br.com.acmepay.application.ports.in.ICreateAccountUseCase;
import br.com.acmepay.application.ports.out.ICheckDocumentCustomer;
import br.com.acmepay.application.ports.out.ICreateAccount;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateAccountUseCase implements ICreateAccountUseCase, IAccountListener{

    private final ICreateAccount createAccount;
    private final ICheckDocumentCustomer checkDocumentCustomer;


    @Override
    public void execute(AccountDomain domain) {
        domain.create(checkDocumentCustomer);
    }

    @Override
    public void receiveMessageSuccess(AccountRequest requestListener) {
        AccountDomain.builder()
                .number(requestListener.getNumber())
                .agency(requestListener.getAgency())
                .balance(requestListener.getBalance())
                .customerDocument(requestListener.getDocument())
                .build()
                .createAccountReturn(createAccount);
    }

}
