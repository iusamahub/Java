package services;

import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import beans.Employee;
import beans.SalariedEmployee;
import beans.ContractEmployee;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao edao;
	public EmployeeServiceImpl() {
		edao = new EmployeeDaoImpl();
	}

	@Override
	public void addNewEmp(int ch) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter pid");
		int pid = sc.nextInt();
		System.out.println("Enter name");
		String nm = sc.next();
		System.out.println("Enter mobile");
		String mob = sc.next();
		System.out.println("Enter email");
		String em = sc.next();
		System.out.println("Enter dept");
		String dept = sc.next();
		System.out.println("Enter desg");
		String desg = sc.next();
		Employee e = null;
		if(ch==1) {
			System.out.println("enter salary");
			double s=sc.nextDouble();
			System.out.println("enter bonus");
			double b=sc.nextDouble();
			e=new SalariedEmployee(pid, nm, mob, em, dept, desg, s, b);
		}
		else if (ch==2) {
			System.out.println("enter Hrs");
			int hrs=sc.nextInt();
			System.out.println("enter charges per hour");
			double charges=sc.nextDouble();
			e=new ContractEmployee(pid, nm, mob, em, dept, desg,hrs, charges);
		}
		else {
			//vendor details
		}
		edao.save(e);
	}

	@Override
	public List<Employee> displayAll() {
		// TODO Auto-generated method stub
		return edao.displayAll();
	}

	@Override
	public Employee getById(int ch) {
		// TODO Auto-generated method stub
		return edao.getById(ch);
	}

	@Override
	public boolean updateSalById(int ch, double sal) {
		// TODO Auto-generated method stub
		return edao.updateSalById(ch, sal);
	}

	@Override
	public List<Employee> sortBySalary() {
		// TODO Auto-generated method stub
		return edao.sortBySalary();
	}

	@Override
	public TreeMap<Integer, Employee> sortById() {
		// TODO Auto-generated method stub
		return edao.sortById();
	}

	@Override
	public boolean deleteById(int ch) {
		// TODO Auto-generated method stub
		return edao.deleteById(ch);
	}
	
	 

}
