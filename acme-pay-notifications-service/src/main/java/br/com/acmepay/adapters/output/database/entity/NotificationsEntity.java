package br.com.acmepay.adapters.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "notifications")
public class NotificationsEntity {

        @Id
        @SequenceGenerator(name = "notifications_seq",
        sequenceName = "notifications_seq",
        allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "notifications_seq")
        private Long id;

        private String document;
        private String status;
        private String create_doc;
        private String update_doc;
}
