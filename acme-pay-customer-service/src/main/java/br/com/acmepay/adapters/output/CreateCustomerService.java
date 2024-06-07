package br.com.acmepay.adapters.output;

import br.com.acmepay.adapters.output.entity.CustomerEntity;
import br.com.acmepay.adapters.output.repository.CustomerRepository;
import br.com.acmepay.application.domain.models.CustomerDomain;
import br.com.acmepay.application.ports.out.ICreateCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateCustomerService implements ICreateCustomer {

    private final CustomerRepository customerRepository;
    @Override
    public void execute(CustomerDomain domain) {
        var entity = CustomerEntity.builder()
                .name(domain.getName())
                .document(domain.getDocument())
                .email(domain.getEmail())
                .phone(domain.getPhone())
                .created_at(domain.getCreated_at())
                .updated_at(domain.getUpdated_at())
                .build();
        customerRepository.save(entity);
    }
}
