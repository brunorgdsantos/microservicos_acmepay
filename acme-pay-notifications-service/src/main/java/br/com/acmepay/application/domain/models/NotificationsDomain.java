package br.com.acmepay.application.domain.models;

import br.com.acmepay.application.ports.out.ICreateNotifications;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationsDomain {
    private String document;
    private String status;
    private String create_doc;
    private String update_doc;

    public void create(ICreateNotifications createAccount) {
        createAccount.execute(this);
    }

}
