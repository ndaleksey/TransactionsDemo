package com.nd.transactionsdemo.facade;

import com.nd.transactionsdemo.service.DepartmentService;
import com.nd.transactionsdemo.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class DepartmentFacade {
    private final DepartmentService departmentService;
    private final NotificationService notificationService;

    @Transactional
    public void createDepartments(Collection<String> depNames) {
        depNames.forEach(dn -> {
            departmentService.create(dn);
            notificationService.notify("Department [name = %s] was successfully created".formatted(dn));
        });
    }
}
