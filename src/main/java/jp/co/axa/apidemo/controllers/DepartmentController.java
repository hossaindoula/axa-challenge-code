package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Department;
import jp.co.axa.apidemo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jp.co.axa.apidemo.exception.NotFoundException;
import jp.co.axa.apidemo.exception.ValidationErrorException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getDepartments() {
        List<Department> departments = departmentService.retrieveDepartments();
        return departments;
    }

    @GetMapping("/{departmentId}")
    public Department getDepartment(@PathVariable(name="departmentId")Long departmentId) throws NotFoundException {
        return departmentService.getDepartment(departmentId);
    }

    @PostMapping
    public void saveDepartment(Department department) throws ValidationErrorException {
        departmentService.saveDepartment(department);
    }

    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable(name="departmentId")Long departmentId) throws NotFoundException{
        departmentService.deleteDepartment(departmentId);
    }

    @PutMapping("/{departmentId}")
    public void updateEmployee(@RequestBody Department department,
                               @PathVariable(name="departmentId")Long departmentId) throws NotFoundException {
        if(department != null){
            departmentService.updateDepartment(department, departmentId);
        }

    }

}
