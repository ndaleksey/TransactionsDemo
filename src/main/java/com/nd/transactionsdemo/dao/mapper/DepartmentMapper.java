package com.nd.transactionsdemo.dao.mapper;

import com.nd.transactionsdemo.model.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Repository
public interface DepartmentMapper {
    void save(@Param("dep") Department department);

    List<Department> findAll();
}
