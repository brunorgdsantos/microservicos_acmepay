package br.com.acmepay.application.domain.models;

import br.com.acmepay.application.domain.exception.BalanceTowithdrawException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDomain {
    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance; //SaldoConta
    private Boolean close;
    private String customer;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public void create() {
    }

    public void deposit(BigDecimal amount){ //Valor a ser depositado
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceTowithdrawException { //Saque
        if(this.balance.compareTo(amount) >= 0){
            this.balance = this.balance.subtract(amount);
        }else{
            throw new BalanceTowithdrawException("error withdraw");
        }
    }
}
