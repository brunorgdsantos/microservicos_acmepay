package br.com.acmepay.application.usecases;

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
        domain.create(createAccount, checkDocumentCustomer);
    }

    @Override
    public void receiveMessageSuccess(String requestListener) {
        AccountDomain.builder().build().createAccount(requestListener, createAccount);
    }

}
