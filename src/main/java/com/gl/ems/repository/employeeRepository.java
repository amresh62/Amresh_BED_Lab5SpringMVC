package com.gl.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.ems.entity.employeeMaster;

@Repository
public interface employeeRepository extends JpaRepository<employeeMaster,Long> {

}
