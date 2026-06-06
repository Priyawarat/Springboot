package com.infy.practice.dto;

import jakarta.validation.constraints.*;
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
    @NotNull(message = "Required field in Employee : name")
    @NotEmpty(message = "Name can not be Empty")
    @NotBlank(message = "Name can not be Blank")
    @Size(min=2 , max = 10,message = "Required word 2 to 10 length")
    private String name;

    @Email(message = "Provide valid email")
    private String email;
    @Size(min=18, message = "Minimum age required 18")
    private Integer age;
    private LocalDate doj;
    private Boolean isActive;
}
