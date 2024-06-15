package br.com.acmepay.adapters.output.database;

import br.com.acmepay.adapters.output.database.entity.NotificationsEntity;
import br.com.acmepay.adapters.output.database.repository.NotificationsRepository;
import br.com.acmepay.application.domain.models.NotificationsDomain;
import br.com.acmepay.application.ports.out.ICreateNotifications;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateNotificationsService implements ICreateNotifications {

        private final NotificationsRepository repository;

        public void execute(NotificationsDomain notificationsDomain) {
            var entity = NotificationsEntity.builder()
                    .document(notificationsDomain.getDocument())
                    .status(notificationsDomain.getStatus())
                    .create_doc(notificationsDomain.getCreate_doc())
                    .update_doc(notificationsDomain.getUpdate_doc())
            .build();
                repository.save(entity);
        }
}
