package org.chintanpatel.app.repository.implement;

import org.chintanpatel.app.model.Employee;
import org.chintanpatel.app.repository.EmployeeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final SessionFactory sessionFactory;

    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEmployee(Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(employee);
    }

    @Override
    public List<Employee> getAllEmployeeList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Employee>query = currentSession.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.find(Employee.class, employeeId);
    }

    @Override
    public void editEmployee(Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.merge(employee);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Employee employee = currentSession.byId(Employee.class).load(employeeId);
        currentSession.remove(employee);
    }
}