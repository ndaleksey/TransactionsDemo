package com.nd.transactionsdemo.controller;

import com.nd.transactionsdemo.dto.CreateDepartmentsDto;
import com.nd.transactionsdemo.facade.DepartmentFacade;
import com.nd.transactionsdemo.model.Department;
import com.nd.transactionsdemo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentFacade departmentFacade;
    private final DepartmentService departmentService;

    @GetMapping
    public Collection<Department> allDepartments() {
        return departmentService.getDepartments();
    }

    @PostMapping
    public void addDepartment(@RequestBody CreateDepartmentsDto dto) {
        log.info("Processing add department request");

        departmentFacade.createDepartments(dto.getNames());

        log.info("Add department request successfully processed");
    }
}
