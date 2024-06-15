package br.com.acmepay.application.usecases;

import br.com.acmepay.application.domain.models.NotificationsDomain;
import br.com.acmepay.application.ports.in.ICreateNotificationsUseCase;
import br.com.acmepay.application.ports.out.ICreateNotifications;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateAccountUseCase implements ICreateNotificationsUseCase {

    private final ICreateNotifications createNotifications;
    //private final ICheckDocumentCustomer checkDocumentCustomer;

    @Override
    public void execute(NotificationsDomain domain) {
        domain.create(createNotifications);
    }
}
