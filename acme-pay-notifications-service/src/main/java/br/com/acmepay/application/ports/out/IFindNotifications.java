package br.com.acmepay.application.ports.out;

import br.com.acmepay.adapters.output.database.entity.NotificationsEntity;
import java.util.Optional;

public interface IFindNotifications {
    Optional<NotificationsEntity> find(String document);
}
