package com.prod_ready_feature.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDto {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate doj;
    private Boolean isActive;
}
