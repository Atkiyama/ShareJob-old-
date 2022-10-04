package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class LoginForm {
	@NotBlank()
	private String userId;
	@NotBlank()
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password;
}
