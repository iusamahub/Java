package services;

import java.util.List;
import java.util.TreeMap;

import beans.Employee;

public interface EmployeeService {

	void addNewEmp(int ch);

	List<Employee> displayAll();

	Employee getById(int ch);

	boolean updateSalById(int ch, double sal);

	List<Employee> sortBySalary();
	
	TreeMap<Integer, Employee> sortById();

	boolean deleteById(int ch);

}
