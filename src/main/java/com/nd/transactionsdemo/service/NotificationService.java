package com.nd.transactionsdemo.service;

import com.nd.transactionsdemo.dao.mapper.NotificationMapper;
import com.nd.transactionsdemo.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationService {
    private final NotificationMapper notificationMapper;

    @Transactional
    public void notify(String message) {
        log.info("Try to create notification");

        var notification = Notification.builder()
                .id(UUID.randomUUID())
                .message(message)
                .createAt(LocalDateTime.now())
                .build();

        notificationMapper.save(notification);

        log.info("Notification message: {}", message);
    }
}
