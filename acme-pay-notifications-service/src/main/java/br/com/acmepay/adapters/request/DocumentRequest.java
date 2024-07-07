package br.com.acmepay.adapters.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentRequest implements Serializable {
    private Integer number;

    private Integer agency;

    private BigDecimal balance;

    private String document;
}
