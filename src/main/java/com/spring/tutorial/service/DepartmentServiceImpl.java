package com.spring.tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.spring.tutorial.error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tutorial.entity.Department;
import com.spring.tutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	  @Autowired
	    private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		 return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchAllDepartments() {
		 return departmentRepository.findAll();
	}

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
       		Optional<Department> dept = departmentRepository.findById(id);
        	if(!dept.isPresent()){
				throw new DepartmentNotFoundException("Department not available");
			}
			return dept.get();
    }

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

	@Override
	public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> dept = departmentRepository.findById(departmentId);
		if(departmentId.equals(0) || !(dept.isPresent())){
			throw new DepartmentNotFoundException("Department with the id is not available");
		}
		 departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartmentById(Long departmentId, Department department) {

		Department department1 = departmentRepository.findById(departmentId).get();
		if ((Objects.nonNull(department.getDepartmentName()) && (!"".equalsIgnoreCase(department.getDepartmentName().toString())))) {
			department1.setDepartmentName(department.getDepartmentName().toString());

		}
		if ((Objects.nonNull(department.getDepartmentAddress()) && (!"".equalsIgnoreCase(department.getDepartmentAddress())))) {
			department1.setDepartmentAddress(department.getDepartmentAddress());

		}
		if ((Objects.nonNull(department.getDepartmentCode()) && (!"".equalsIgnoreCase(department.getDepartmentCode())))) {
			department1.setDepartmentCode(department1.getDepartmentCode());

		}
		return departmentRepository.save(department1);

	}

}
