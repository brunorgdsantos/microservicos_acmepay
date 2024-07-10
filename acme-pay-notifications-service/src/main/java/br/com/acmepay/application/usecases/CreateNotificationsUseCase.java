package br.com.acmepay.application.usecases;

import br.com.acmepay.adapters.input.api.request.NotificationsRequest;
import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.domain.models.NotificationsDomain;
import br.com.acmepay.application.ports.in.ICreateNotificationsUseCase;
import br.com.acmepay.application.ports.in.INotificationsListener;
import br.com.acmepay.application.ports.out.ICheckDocumentSuccessOrFailNotifications;
import br.com.acmepay.application.ports.out.ICreateNotifications;
import br.com.acmepay.application.ports.out.IFindNotifications;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateNotificationsUseCase implements ICreateNotificationsUseCase, INotificationsListener {

    private final ICreateNotifications createNotifications;

    private final IFindNotifications findNotifications;

    private final ICheckDocumentSuccessOrFailNotifications checkDocumentNotifications;

    @Override
    public void execute(NotificationsDomain domain) {
        domain.create(createNotifications);
    }

    @Override
    public void receiveMessage(DocumentRequest documentRequestListener) {
        NotificationsDomain.builder().build()
                .validatedDocument(findNotifications, documentRequestListener, checkDocumentNotifications);
    }

    @Override
    public void receiveMessageKafka(DocumentRequest documentRequestListener) {
        NotificationsDomain.builder().build()
                .validatedDocument(findNotifications, documentRequestListener, checkDocumentNotifications);
    }
}
