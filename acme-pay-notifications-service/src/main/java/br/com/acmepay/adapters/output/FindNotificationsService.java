package br.com.acmepay.adapters.output;

import br.com.acmepay.adapters.output.database.entity.NotificationsEntity;
import br.com.acmepay.adapters.output.database.repository.NotificationsRepository;
import br.com.acmepay.application.ports.out.IFindNotifications;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class FindNotificationsService implements IFindNotifications {

    private final NotificationsRepository notificationsRepository;
    @Override
    public Optional<NotificationsEntity> find(String document) {
        return notificationsRepository.findByDocument(document); //E AO LONGO DAS CAMADAS ESTA CONTATENANDO EM: DocumentRequest(document=DocumentRequest(document=999))
    }
}
