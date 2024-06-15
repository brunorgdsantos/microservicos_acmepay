package br.com.acmepay.adapters.output.database.repository;

import br.com.acmepay.adapters.output.database.entity.NotificationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepository extends JpaRepository<NotificationsEntity, Long> {
}
