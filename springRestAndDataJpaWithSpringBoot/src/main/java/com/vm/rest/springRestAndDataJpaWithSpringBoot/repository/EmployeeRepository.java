package com.vm.rest.springRestAndDataJpaWithSpringBoot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vm.rest.springRestAndDataJpaWithSpringBoot.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}