package br.com.acmepay.adapters.input.controller;

import br.com.acmepay.adapters.input.api.INotificationsResourceAPI;
import br.com.acmepay.adapters.input.api.request.NotificationsRequest;
import br.com.acmepay.adapters.input.api.response.NotificationsResponse;
import br.com.acmepay.application.domain.models.NotificationsDomain;
import br.com.acmepay.application.ports.in.ICreateNotificationsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class NotificationsController implements INotificationsResourceAPI {

    private final ICreateNotificationsUseCase createAccountUseCase;

    @Override
    public NotificationsResponse create(NotificationsRequest request) {
        var domain = NotificationsDomain.builder()
                .document(request.getDocument())
                .status(request.getStatus())
                .create_doc(request.getCreate_doc())
                .update_doc(request.getUpdate_doc())
                .build();
        createAccountUseCase.execute(domain);
        return NotificationsResponse.builder()
                .message("account created!")
                .build();
    }
}
