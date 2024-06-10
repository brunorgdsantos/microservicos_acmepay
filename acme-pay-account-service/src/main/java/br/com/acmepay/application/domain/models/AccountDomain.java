package br.com.acmepay.application.domain.models;

import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.domain.exception.BalanceTowithdrawException;
import br.com.acmepay.application.ports.out.ICheckDocumentCustomer;
import br.com.acmepay.application.ports.out.ICreateAccount;
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
public class AccountDomain {
    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance; //SaldoConta
    private Boolean close;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String customerDocument;

    public void create(ICreateAccount createAccount, ICheckDocumentCustomer checkDocumentCustomer) {
        var doc = DocumentRequest.builder().document(this.customerDocument).build();
        checkDocumentCustomer.execute(doc);

        createAccount.execute(this);
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
