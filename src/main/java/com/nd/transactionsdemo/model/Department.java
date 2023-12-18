package com.nd.transactionsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Department {
    @Id
    @GeneratedValue(generator = "gen_random_uuid()")
    private UUID id;

    @NotEmpty
    private String name;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
