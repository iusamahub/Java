package com.demo.service;

import java.util.Set;

import com.demo.beans.Employee;

public interface EmployeeService {

	void addNewEmployee(int ch);

	Set<Employee> displayAll();

	Employee getById(int ch);

	boolean deleteById(int ch);

	Set<Employee> sortBySalary();

	Set<Employee> sortByName();

}
