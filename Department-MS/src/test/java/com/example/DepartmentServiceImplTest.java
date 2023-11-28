package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.dto.DepartmentDto;
import com.example.entity.Department;
import com.example.impl.DepartmentImpl;
import com.example.repo.DepartmentRepo;

public class DepartmentServiceImplTest {
	@Mock
    private DepartmentRepo departmentRepository;
    @InjectMocks
    private DepartmentImpl departmentService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testSaveDepartment() {
        // Given
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(1L);
        departmentDto.setDepartmentName("IT");
        departmentDto.setDescription("Information Technology Department");
        departmentDto.setCode("IT001");
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDescription(),
                departmentDto.getCode()
        );
        when(departmentRepository.save(any())).thenReturn(department);
        // When
        DepartmentDto savedDepartmentDto = departmentService.create(departmentDto);
        // Then
        assertEquals(departmentDto.getId(), savedDepartmentDto.getId());
        assertEquals(departmentDto.getDepartmentName(), savedDepartmentDto.getDepartmentName());
        assertEquals(departmentDto.getDescription(), savedDepartmentDto.getDescription());
        assertEquals(departmentDto.getCode(), savedDepartmentDto.getCode());
        verify(departmentRepository, times(1)).save(any());
    }
    @Test
    void testGetDepartmentByCode() {
        // Given
        String departmentCode = "IT001";
        Department department = new Department();
        department.setId(1L);
        department.setDepartmentName("IT");
        department.setDescription("Information Technology Department");
        department.setCode(departmentCode);
        when(departmentRepository.findByCode(departmentCode)).thenReturn(department);
        // When
        DepartmentDto retrievedDepartmentDto = departmentService.getBycode(departmentCode);
        // Then
        assertEquals(department.getId(), retrievedDepartmentDto.getId());
        assertEquals(department.getDepartmentName(), retrievedDepartmentDto.getDepartmentName());
        assertEquals(department.getDescription(), retrievedDepartmentDto.getDescription());
        assertEquals(department.getCode(), retrievedDepartmentDto.getCode());
        verify(departmentRepository, times(1)).findByCode(departmentCode);
    }

}
