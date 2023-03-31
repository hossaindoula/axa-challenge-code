package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Department;
import jp.co.axa.apidemo.exception.NotFoundException;
import jp.co.axa.apidemo.exception.ValidationErrorException;

import java.util.List;

public interface DepartmentService {

    public List<Department> retrieveDepartments();

    public Department getDepartment(Long departmentId) throws NotFoundException;

    public void saveDepartment(Department department) throws ValidationErrorException;

    public void deleteDepartment(Long departmentId) throws NotFoundException;

    public void updateDepartment(Department department, Long departmentId) throws NotFoundException;
}