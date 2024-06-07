package br.com.acmepay.application.domain.models;

import br.com.acmepay.application.domain.exception.CheckEmailDocumentException;
import br.com.acmepay.application.ports.out.ICreateCustomer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDomain {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public void create(ICreateCustomer createCustomer){

    }
}
