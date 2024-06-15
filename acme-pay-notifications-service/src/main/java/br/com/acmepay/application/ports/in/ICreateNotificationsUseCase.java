package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.models.NotificationsDomain;

public interface ICreateNotificationsUseCase {
    void execute(NotificationsDomain notificationsDomain);
}
