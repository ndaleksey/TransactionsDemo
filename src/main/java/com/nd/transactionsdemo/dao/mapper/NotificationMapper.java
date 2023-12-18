package com.nd.transactionsdemo.dao.mapper;

import com.nd.transactionsdemo.model.Notification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
public interface NotificationMapper {
    void save(@Param("notification") Notification notification);

    List<Notification> findAll();
}
