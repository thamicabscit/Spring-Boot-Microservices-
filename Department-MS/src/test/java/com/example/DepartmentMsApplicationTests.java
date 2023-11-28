package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.controller.DepartmentController;
import com.example.dto.DepartmentDto;
import com.example.entity.Department;
import com.example.repo.DepartmentRepo;
import com.example.service.DepartmentService;

@SpringBootTest
class DepartmentMsApplicationTests {

//	@Autowired
//	private DepartmentController cont;
//
//	@MockBean
//	private DepartmentRepo repo;

//	@Test
//	public void employeetest() {
//		Department dept = new Department();
//
//		dept.setDepartmentName("CS");
//		dept.setDescription("Computer");
//		dept.setCode("CS001");
//
//		String name = dept.getDepartmentName();
//		String desc = dept.getDescription();
//		String code = dept.getCode();
//
//		assertEquals("CS", name);
//		assertEquals("Computer",desc);
//		assertEquals("CS001",code);
//	}
//
//	
//	@Test
//    public void testGet() {
//        List<Department> dept = new ArrayList<>();
//        when(repo.findAll()).thenReturn(dept);
//
//        List<Department> result = cont.get();
//
//        verify(repo, times(1)).findAll();
//    }
	@Mock
    private DepartmentService departmentService;
    @InjectMocks
    private DepartmentController departmentController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testSaveDepartment() {
        // Given
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setCode("IT");
        departmentDto.setDepartmentName("Information Technology");
        when(departmentService.create(any())).thenReturn(departmentDto);
        // When
        ResponseEntity<DepartmentDto> responseEntity = departmentController.create(departmentDto);
        // Then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(departmentDto, responseEntity.getBody());
    }
    @Test
    void testGetDepartment() {
        // Given
        String departmentCode = "IT";
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setCode(departmentCode);
        departmentDto.setDepartmentName("Information Technology");
        when(departmentService.getBycode(departmentCode)).thenReturn(departmentDto);
        // When
        ResponseEntity<DepartmentDto> responseEntity = departmentController.getbycode(departmentCode);
        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(departmentDto, responseEntity.getBody());
    }
}
