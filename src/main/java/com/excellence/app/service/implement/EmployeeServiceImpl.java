package com.excellence.app.service.implement;

import com.excellence.app.model.Employee;
import com.excellence.app.repository.EmployeeRepository;
import com.excellence.app.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Transactional
    @Override
    public List<Employee> getAllEmployeeList() {
        return employeeRepository.getAllEmployeeList();
    }

    @Transactional
    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.getEmployeeById(employeeId);
    }

    @Transactional
    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee(employee);
    }

    @Transactional
    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteEmployeeById(employeeId);
    }
}
