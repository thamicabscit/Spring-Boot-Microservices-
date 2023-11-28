package com.example.impl;

import com.example.dto.DepartmentDto;
import com.example.dto.EmployeeDto;


public class ApiResponseDto {
	private DepartmentDto dept;
	private EmployeeDto emp;
	public ApiResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiResponseDto(DepartmentDto dept, EmployeeDto emp) {
		super();
		this.dept = dept;
		this.emp = emp;
	}
	public DepartmentDto getDept() {
		return dept;
	}
	public void setDept(DepartmentDto dept) {
		this.dept = dept;
	}
	public EmployeeDto getEmp() {
		return emp;
	}
	public void setEmp(EmployeeDto emp) {
		this.emp = emp;
	}
	
	

}
