package com.example.dto;




public class EmployeeDto {
	
	private Long id;
	
	
	private String name;
	

	
	private String email;
	private String code;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public EmployeeDto(Long id, String name, String email, String code) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.code = code;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}




	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}


	

	
}
