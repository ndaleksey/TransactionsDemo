package com.nd.transactionsdemo.dto;

import lombok.Data;

import java.util.Collection;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Data
public class CreateDepartmentsDto {
    Collection<String> names;
}
