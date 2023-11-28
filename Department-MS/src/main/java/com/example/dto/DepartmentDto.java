package com.example.dto;


public class DepartmentDto {
	

	
	private Long id;
	
	private String departmentName;

	private String description;

	private String code;
	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentDto(Long id, String departmentName, String description, String code) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.description = description;
		this.code = code;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}

