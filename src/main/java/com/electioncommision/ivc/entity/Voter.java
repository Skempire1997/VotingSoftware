package com.electioncommision.ivc.entity;

import java.util.UUID;

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
public class Voter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String uniqueVoterId;
	@NotBlank(message = "Name cannot be blank")
	@NotNull(message = "please enter a proper name")
	private String firstName;
	private String middleName;
	private String lastName;
	private States state;
	private String district;
	private String town;
	@Column(unique = true)
	@Email(regexp = "[a-z0-9._$]+@[a-z]+\\.[a-z]{2,3}", message = "Enter proper Email")
	private String emailID;
	private String password;
	@Column(unique = true)
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private String phoneNo;

	public Voter() {
		this.uniqueVoterId = generateUniqueNumber();
	}

	public String generateUniqueNumber() {
		return UUID.randomUUID().toString(); // Or use a custom method for unique number generation
	}
}
