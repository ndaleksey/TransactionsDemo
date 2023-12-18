package com.nd.transactionsdemo.service;

import com.nd.transactionsdemo.dao.mapper.DepartmentMapper;
import com.nd.transactionsdemo.model.Department;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentMapper departmentMapper;
    private final DepartmentValidator departmentValidator;
    private final TransactionTemplate transactionTemplate;

    /**
     * Retrieve all departments from DB.
     *
     * @return collection of {@link Department}
     */
    public List<Department> getDepartments() {
        return departmentMapper.findAll();
    }

    public void create(String name) {
        log.info("Try to create department");
        var oldPropagationBehavior = transactionTemplate.getPropagationBehavior();
        try {
            departmentValidator.validateName(name);

            transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_NESTED);

            transactionTemplate.executeWithoutResult(status -> departmentMapper.save(createDepartment(name)));
        } catch (Exception e) {
            log.error("Couldn't create department [name = {}]", name);
        } finally {
            transactionTemplate.setPropagationBehavior(oldPropagationBehavior);
        }
    }

    private Department createDepartment(String name) {
        return Department.builder()
                .id(UUID.randomUUID())
                .name(name)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
