package vin.getArrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vin.getArrays.employeemanager.model.Employee;

import java.util.Optional;

//第二個參數為id的型態，extend之後就可以使用裡面提供的method來操作database
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    //    spring會判斷delete+物件名稱+ById，之後會直接幫你做好delete Employee的功能，幫我們建好適當的query來做delete
    void deleteEmployeeById(Long id);

    //    spring會判斷find+物件名稱+ById，之後會直接幫你做好delete Employee的功能，幫我們建好適當的query來做delete

    //    因為有可能沒找到employee，所以用Optional
    Optional<Employee> findEmployeeById(Long id);
}
