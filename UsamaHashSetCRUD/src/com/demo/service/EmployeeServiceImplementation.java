package com.demo.service;

import java.util.*;
import com.demo.beans.*;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImplementation;

public class EmployeeServiceImplementation implements EmployeeService {
	private EmployeeDao edao;
	public EmployeeServiceImplementation() {
		edao = new EmployeeDaoImplementation();
	}

	@Override
	public void addNewEmployee(int ch) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter pid");
		int pid = sc.nextInt();
		System.out.println("Enter pname");
		String pname = sc.next();
		System.out.println("enter mobile");
		String mob=sc.next();
		System.out.println("enter email");
		String em=sc.next();
		System.out.println("enter dept");
		String dept=sc.next();
		System.out.println("enter desg");
		String desg=sc.next();
		
		Employee e = null;
		
		if(ch==1) {
			System.out.println("enter salary");
			double s=sc.nextDouble();
			System.out.println("enter bonus");
			double b=sc.nextDouble();
			e = new SalarisedEmployee(pid, pname, mob, em, dept, desg, s, b);
		}
		else if (ch==2) {
			System.out.println("enter Hrs");
			int hrs=sc.nextInt();
			System.out.println("enter charges per hour");
			double charges=sc.nextDouble();
			e = new ContractEmployee(pid, pname, mob, em, dept, desg, hrs, charges);
		
		}
		else {
			//vendor details
			System.out.println("Enter number of emp");
			int noemp = sc.nextInt();
			System.out.println("Enter amount");
			double amt = sc.nextDouble();
			e = new Vendor(pid, pname, mob, em, dept, desg, noemp, amt);
		}
		edao.save(e);
	}
	
	public Set<Employee> displayAll(){
		return edao.displayAll();
	}

	@Override
	public Employee getById(int ch) {
		return edao.getById(ch);	
	}

	@Override
	public boolean deleteById(int ch) {
		return edao.deleteById(ch);
	}

	@Override
	public Set<Employee> sortBySalary() {
		// TODO Auto-generated method stub
		return edao.sortBySalary();
	}

	@Override
	public Set<Employee> sortByName() {
		// TODO Auto-generated method stub
		return edao.sortByName();
	}

}
