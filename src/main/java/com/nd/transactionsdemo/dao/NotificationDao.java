package com.nd.transactionsdemo.dao;

import com.nd.transactionsdemo.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Repository
public interface NotificationDao extends JpaRepository<Notification, UUID> {
}
