package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Department;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.NotFoundException;
import jp.co.axa.apidemo.exception.ValidationErrorException;
import jp.co.axa.apidemo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> retrieveDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    public Department getDepartment(Long departmentId) throws NotFoundException {
        Optional<Department> optDepartment = departmentRepository.findById(departmentId);
        if(optDepartment.isPresent()){
            return optDepartment.get();
        }

        throw new NotFoundException("Department Not Found");
        
    }

    public void saveDepartment(Department department) throws ValidationErrorException {
        Department departmentFetchedName = departmentRepository.findDepartmentByName(department.getName());
        if(departmentFetchedName != null) {
            throw new ValidationErrorException("Department Name is already used");
        }
        
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long departmentId) throws NotFoundException {
        Optional<Department> optDepartment = departmentRepository.findById(departmentId);
        if(optDepartment.isPresent()){
            departmentRepository.deleteById(departmentId);
        }

        throw new NotFoundException("Department Not Found"); 
    }

    public void updateDepartment(Department department, Long departmentId) throws NotFoundException {
        Optional<Department> optDepartment = departmentRepository.findById(departmentId);
        if(optDepartment.isPresent()){
            department.setId(departmentId);
            departmentRepository.save(department);
        }
        
        throw new NotFoundException("Department Not Found"); 
    }
}