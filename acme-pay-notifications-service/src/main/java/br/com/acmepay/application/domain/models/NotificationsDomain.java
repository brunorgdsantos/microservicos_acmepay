package br.com.acmepay.application.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class NotificationsDomain {
    private Long id;
    private LocalDateTime data_transaction;
    private Integer source_account;
    private Integer destination_account;
    private BigDecimal amount;
}
