package com.electioncommision.ivc.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	@NotBlank(message = "Name must be filled")
	@NotNull(message = "please fill the proper name")
	private String name;
	@NotBlank(message = "address must be filled")
	@NotNull(message = "please fill the proper address")
	private String address;
	@Column(unique = true)
	private String username;
	private String password;
	@Column(unique = true)
	@Email(regexp = "[a-z0-9._$]+@[a-z]+\\.[a-z]{2,3}", message = "Enter proper Email")
	private String emailId;
	@Column(unique = true)
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private String phoneNo;
	private Set<Role> role;

}
