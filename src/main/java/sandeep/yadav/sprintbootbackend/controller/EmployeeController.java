package sandeep.yadav.sprintbootbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sandeep.yadav.sprintbootbackend.model.Employee;
import sandeep.yadav.sprintbootbackend.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

// Save employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

// Get all Employee REST API
    @GetMapping
    public List<Employee> getAllEmployees() {
        return  employeeService.getAllEmployees();
    }

//  Get Employee by ID REST API
    @GetMapping("{id}")
    public  ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

//  Update Employee by ID REST API
    @PutMapping("{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
                                                    @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,employeeId), HttpStatus.OK);
    }

//  Delete Employee by ID REST API
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
    }
}
