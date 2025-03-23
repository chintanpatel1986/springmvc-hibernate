package com.excellence.app.service.implement;

import com.excellence.app.model.Department;
import com.excellence.app.repository.DepartmentRepository;
import com.excellence.app.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    @Override
    public void addDepartment(Department department) {
        departmentRepository.addDepartment(department);
    }

    @Transactional
    @Override
    public List<Department> getAllDepartmentList() {
        return departmentRepository.getAllDepartmentList();
    }

    @Transactional
    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.getDepartmentById(departmentId);
    }

    @Transactional
    @Override
    public void editDepartment(Department department) {
        departmentRepository.editDepartment(department);
    }

    @Transactional
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteDepartmentById(departmentId);
    }
}
