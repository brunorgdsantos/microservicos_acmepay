package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.models.CustomerDomain;

public interface ICreateCustomerUseCase {
    void execute(CustomerDomain domain);
}
