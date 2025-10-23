package com.test.java.model;

//조인한 결과 테이블에 대한 DTO
public class AddressPointDTO {
	//tblAddress
	private String seq; //PK
	private String name;
	private Integer age;
	private String address;
	private String gender;
	
	//tblPoint
	private String pseq; //PK
	private Integer point;
	private String aseq;
}
