package br.com.acmepay.adapters.application.ports.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequest implements Serializable {

    private Integer number;

    private Integer agency;

    private BigDecimal balance;

    private String document;
}
