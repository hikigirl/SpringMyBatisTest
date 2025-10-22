package com.test.java.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class AddressDTO {
	private String seq;
	private String name;
	private Integer age;
	private String address;
	private String gender;
}