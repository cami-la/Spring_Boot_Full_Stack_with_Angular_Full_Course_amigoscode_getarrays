package tech.getarrays.employeemanager.service;

import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exeception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
  private EmployeeRepo employeeRepo;

  public Employee addEmployee(Employee employee) {
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepo.save(employee);
  }

  public List<Employee> findAllEmployees() {
    return employeeRepo.findAll();
  }

  public Employee updateEmployee(Employee employee) {
    return employeeRepo.save(employee);
  }

  public Employee findEmployeeById(Long id) {
    return employeeRepo.findEmployeeById(id).orElseThrow(
        () -> new UserNotFoundException(String.format("Employee User by id %s was not found.", id)));
  }

  public void deleteEmployee(Long id) {
    employeeRepo.deleteEmployeeById(id);
  }
}
