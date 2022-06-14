package tech.getarrays.employeemanager.service;

import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

import java.util.UUID;

@Service
public record EmployeeService(
    EmployeeRepo employeeRepo
) {

  public Employee addEmployee(Employee employee) {
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepo.save(employee);
  }
}
