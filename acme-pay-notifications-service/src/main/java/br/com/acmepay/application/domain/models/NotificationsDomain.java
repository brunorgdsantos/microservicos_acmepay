package br.com.acmepay.application.domain.models;

import br.com.acmepay.adapters.input.api.request.NotificationsRequest;
import br.com.acmepay.adapters.output.database.entity.NotificationsEntity;
import br.com.acmepay.application.ports.out.ICheckDocumentNotifications;
import br.com.acmepay.application.ports.out.ICreateNotifications;
import br.com.acmepay.application.ports.out.IFindNotifications;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class NotificationsDomain {
    private String document;
    private String status;
    private String create_doc;
    private String update_doc;

    public void create(ICreateNotifications createNotifications) {
        createNotifications.execute(this);
    }

    public void validatedDocument(IFindNotifications findNotifications,
                                                           String requestListener,
                                                           ICheckDocumentNotifications checkDocumentNotifications) {

        Optional<NotificationsEntity> notificationsEntity = findNotifications.find(requestListener);

        if(notificationsEntity.isPresent() && notificationsEntity.get().getStatus().equals("ACTIVE")) {

            var doc = NotificationsRequest.builder().document(notificationsEntity.get().getDocument()).build();
            checkDocumentNotifications.execute(String.valueOf(doc));
            log.info("SUCCESS PROCESS.");

        }else{
            log.info("Error: Document is not active.");
        }
    }

}
