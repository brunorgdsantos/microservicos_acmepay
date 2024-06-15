package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.models.NotificationsDomain;

public interface ICreateNotifications {
    void execute(NotificationsDomain notificationsDomain);
}
