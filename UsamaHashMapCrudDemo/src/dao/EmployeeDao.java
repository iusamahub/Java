package dao;

import java.util.List;
import java.util.TreeMap;

import beans.Employee;

public interface EmployeeDao {

	void save(Employee e);

	List<Employee> displayAll();

	Employee getById(int ch);

	boolean updateSalById(int ch, double sal);

	List<Employee> sortBySalary();

	TreeMap<Integer, Employee> sortById();

	boolean deleteById(int id);

}
