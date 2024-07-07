package br.com.acmepay.adapters.request;

import lombok.Builder;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class DocumentRequest implements Serializable {
    private Integer number;

    private Integer agency;

    private BigDecimal balance;

    private String document;
}
