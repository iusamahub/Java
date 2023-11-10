package com.demo.dao;

import java.util.Set;

import com.demo.beans.Employee;

public interface EmployeeDao {

	void save(Employee e);

	Set<Employee> displayAll();

	Employee getById(int ch);

	boolean deleteById(int ch);

	Set<Employee> sortBySalary();

	Set<Employee> sortByName();

}
