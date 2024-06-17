package br.com.acmepay.adapters.output.database.repository;

import br.com.acmepay.adapters.output.database.entity.NotificationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationsRepository extends JpaRepository<NotificationsEntity, Long> {
    Optional<NotificationsEntity> findByDocument(String document);
}
