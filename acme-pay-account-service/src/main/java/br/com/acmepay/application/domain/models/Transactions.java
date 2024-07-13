package br.com.acmepay.application.domain.models;

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
public class Transactions {
    private Long id;
    private Integer accountOrigin;
    private Integer accountDestiny;
    private Integer valueTransaction;
    private LocalDateTime created_at;
}
