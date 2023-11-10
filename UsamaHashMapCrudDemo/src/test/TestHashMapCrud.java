package test;

import java.util.*;

import beans.Employee;
import services.*;

public class TestHashMapCrud {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		EmployeeService es = new EmployeeServiceImpl();
		
		do {
			System.out.println("1.Add new Employee\n2.Display All Employee\n3.Get Employee By Id");
			System.out.println("4.Modify Salary\n5.Sort By Salary\n6.Sort By Id\n7.Delete Emp By Id");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter 1 for Salaried Employee");
				System.out.println("Enter 2 for Contract Employee");
				System.out.println("Enter 3 for Vendor");
				int ch = sc.nextInt();
				es.addNewEmp(ch);
				
				break;
			case 2:
				List<Employee> elist = es.displayAll();
				if(elist!=null) {
					elist.stream().forEach(System.out::println);
				}
				break;
			case 3:
				System.out.println("Enter Id to display");
				ch = sc.nextInt();
				Employee e = es.getById(ch);
				if(e!=null) {
					System.out.println(e);
				}else {
					System.out.println("Id not found");
				}
				break;
			case 4:
				System.out.println("Enter Id whose salary u want to modify");
				ch = sc.nextInt();
				System.out.println("Enter new Salary");
				double sal = sc.nextDouble();
				boolean status = es.updateSalById(ch, sal);
				if(status) {
					System.out.println("Salary modified");
				}else {
					System.out.println("Id not found");
				}
				break;
			case 5:
				List<Employee> elst= es.sortBySalary();
				if(elst!=null) {					
					elst.stream().forEach(System.out::println);
				}
				break;
			case 6:
				TreeMap<Integer, Employee> ts = es.sortById();
				Set<Integer> s1 = ts.keySet();
				s1.stream().forEach(System.out::println);
				break;
			case 7:
				System.out.println("Enter Id to delete");
				ch = sc.nextInt();
				status = es.deleteById(ch);
				if(status) {
					System.out.println("Deleted successfully");
				}else {
					System.out.println("Id not found");
				}
				break;
			}
			
		}while(choice!=8);
		
	}

}
