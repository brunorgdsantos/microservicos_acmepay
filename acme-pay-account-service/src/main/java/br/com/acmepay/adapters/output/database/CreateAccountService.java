package br.com.acmepay.adapters.output.database;

import br.com.acmepay.adapters.output.database.entity.AccountEntity;
import br.com.acmepay.adapters.output.database.repository.AccountRepository;
import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.ports.out.ICreateAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CreateAccountService implements ICreateAccount {

        private final AccountRepository repository;

        public void execute(AccountDomain accountDomain) {
            var entity = AccountEntity.builder()
                    .agency(accountDomain.getAgency())
                    .number(accountDomain.getNumber())
                    .balance(accountDomain.getBalance())
                    .created_at(LocalDateTime.now())
                    .updated_at(LocalDateTime.now())
                    .document(accountDomain.getCustomerDocument())
                    .close(accountDomain.getClose())
            .build();
                repository.save(entity);
        }
}
