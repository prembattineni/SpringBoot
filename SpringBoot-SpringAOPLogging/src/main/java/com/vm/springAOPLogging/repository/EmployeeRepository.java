package com.vm.springAOPLogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vm.springAOPLogging.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository < Employee, Long > {

}
