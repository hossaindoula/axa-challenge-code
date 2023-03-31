package jp.co.axa.apidemo.repositories;

import jp.co.axa.apidemo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query(value = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_NAME = :name", nativeQuery = true)
    Department findDepartmentByName(@Param("name") String name);
}


