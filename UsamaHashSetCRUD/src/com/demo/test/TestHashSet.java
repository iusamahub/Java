package com.demo.test;

import java.util.*;
import com.demo.beans.*;
import com.demo.service.*;

public class TestHashSet {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		EmployeeService eservice = new EmployeeServiceImplementation();
		int choice = 0;
		
		do {
			System.out.println("1.Add new employee\n2.Display all employee\n3.Delete Employee by Id");
			System.out.println("4.Enter Id to Display\n5.Sort By Salary\n6.Sort By Name");
			System.out.println("Enter your choice");
		choice = sc.nextInt();
			switch(choice) {
		case 1:
			System.out.println("Which type of employee you want to add?");
			System.out.println("1.Salaried Employee\n2.Contract Employee\n3.Vendor");
			int ch = sc.nextInt();
			eservice.addNewEmployee(ch);
			break;
		case 2:
			Set<Employee> eset = eservice.displayAll();
			if(eset != null) {
				eset.stream().forEach(System.out::println);
			}
			break;
		case 3:
			System.out.println("Enter Id to delete");
			ch = sc.nextInt();
			boolean status = eservice.deleteById(ch);
			if(status) {
				System.out.println("Successfully deleted");
			}else {
				System.out.println("Not found");
			}
			break;
		case 4:
			System.out.println("Enter id to display");
			ch = sc.nextInt();
			Employee e =  eservice.getById(ch);
			if(e!=null) {
				System.out.println(e);
			}else {
				System.out.println("Not Found");
			}
			break;
		case 5:
			Set<Employee> esort = eservice.sortBySalary();
			esort.stream().forEach(System.out::println);
			break;
		case 6:
			Set<Employee> esrtname = eservice.sortByName();
			esrtname.forEach(System.out::println);
			break;
		}
		}while(choice != 6);
	}
}
