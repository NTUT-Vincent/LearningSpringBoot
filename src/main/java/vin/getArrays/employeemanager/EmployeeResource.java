package vin.getArrays.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vin.getArrays.employeemanager.model.Employee;
import vin.getArrays.employeemanager.service.EmployeeService;

import java.util.List;

//利用annotation讓spring知道這是一個rest controller
@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private final EmployeeService employeeService;

//    我們想要method回傳http response，所以回傳的定為一個ResponseEntity
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
//    參數中的@PathVariable中的字串為"id"，所以會mapping到url中的{id}參數
    public ResponseEntity<Employee> GetEmployeeById (@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
//        回傳的status設為created，可以表示我們created了一個新東西在server
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
//    因為delete沒有要回傳東西，所以T給他問號
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
