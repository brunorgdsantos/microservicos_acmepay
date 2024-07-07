package br.com.acmepay.application.domain.models;

import br.com.acmepay.adapters.input.api.request.NotificationsRequest;
import br.com.acmepay.adapters.output.database.entity.NotificationsEntity;
import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.ports.out.ICheckDocumentSuccessOrFailNotifications;
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

    public void validatedDocument(IFindNotifications findNotifications, DocumentRequest documentRequestListener,
                                                           ICheckDocumentSuccessOrFailNotifications checkDocumentSuccessOrFailNotifications) {

        Optional<NotificationsEntity> notificationsEntity = findNotifications.find(documentRequestListener.getDocument());

        if(notificationsEntity.isPresent() && notificationsEntity.get().getStatus().equals("ACTIVE")) {

            var doc = DocumentRequest.builder()
                    .number(documentRequestListener.getNumber())
                    .agency(documentRequestListener.getAgency())
                    .balance(documentRequestListener.getBalance())
                    .document(notificationsEntity.get().getDocument())
                    .build();
            checkDocumentSuccessOrFailNotifications.executeSuccess(doc);
            log.info("SUCCESS: DOCUMENT IS ACTIVE!");

        } else if (notificationsEntity.isPresent() && notificationsEntity.get().getStatus().equals("INACTIVE")) {
            //var doc = NotificationsRequest.builder().document(notificationsEntity.get().getDocument()).build();
            var doc = DocumentRequest.builder()
                    .number(documentRequestListener.getNumber())
                    .agency(documentRequestListener.getAgency())
                    .balance(documentRequestListener.getBalance())
                    .document(notificationsEntity.get().getDocument())
                    .build();
            checkDocumentSuccessOrFailNotifications.executeFail(doc);
            log.info("WARNING: DOCUMENT EXISTS BUT IS NOT ACTIVE!");

        } else{
            var doc = notificationsEntity.isPresent()? notificationsEntity.get().getDocument() : "ERROR: DOCUMENT IS NOT ACTIVE.";
            var document = DocumentRequest.builder()
                    .number(documentRequestListener.getNumber())
                    .agency(documentRequestListener.getAgency())
                    .balance(documentRequestListener.getBalance())
                    .document(doc)
                    .build();
            checkDocumentSuccessOrFailNotifications.executeFail(document);
        }
    }

}
