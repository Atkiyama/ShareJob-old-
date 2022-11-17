package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class SignUpForm {
    @NotBlank()
    private String userName;
    @NotBlank()
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String password;
	

}
