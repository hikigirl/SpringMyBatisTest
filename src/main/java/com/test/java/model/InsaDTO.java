package com.test.java.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class InsaDTO {
	private String num;
	private String name;
	private String buseo;
	private String jikwi;
	private Integer salary;
	
	private List<ProjectDTO> project;
}
