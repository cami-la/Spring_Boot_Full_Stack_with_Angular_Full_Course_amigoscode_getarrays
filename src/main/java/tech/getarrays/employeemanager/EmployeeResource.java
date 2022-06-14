package tech.getarrays.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;

@RequestMapping(value = "/employee")
@RestController
public record EmployeeResource(
    EmployeeService employeeService
) {

  @GetMapping(value = "/all")
  public ResponseEntity<List<Employee>> getAllEmployee() {
    List<Employee> employees = employeeService.findAllEmployees();
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }

  @GetMapping(value = "/find/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
    Employee employee = employeeService.findEmployeeById(id);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @PostMapping(value = "/add")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    Employee newEmployee = employeeService.addEmployee(employee);
    return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
  }

  @PutMapping(value = "/update")
  public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
    Employee updateEmployee = employeeService.updateEmployee(employee);
    return new ResponseEntity<>(updateEmployee, HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long id) {
    employeeService.deleteEmployee(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
