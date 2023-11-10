package com.demo.dao;

import java.util.*;

import com.demo.beans.Employee;
import com.demo.beans.ContractEmployee;
import com.demo.beans.SalarisedEmployee;
import com.demo.beans.Vendor;

public class EmployeeDaoImplementation implements EmployeeDao {
	
	static Set<Employee> hs; 
	
	static {
		hs = new HashSet<>();
		hs.add(new SalarisedEmployee(12,"Rajat","4444","a@gmail.com","hr","associate",4556,345));
		hs.add(new SalarisedEmployee(13,"Ajit","555","a22@gmail.com","admin","associate",4577,377));
		hs.add(new ContractEmployee(14,"Rajas","666","r345@gmail.com","admin","manager",30,4000));
		hs.add(new ContractEmployee(15,"Ashwini","777","ashu@gmail.com","hr","associate",40,5000));
		hs.add(new ContractEmployee(15,"Ashwini","777","ashu@gmail.com","hr","associate",40,5000));
	}

	@Override
	public void save(Employee e) {
		// TODO Auto-generated method stub
		hs.add(e);
	}

	@Override
	public Set<Employee> displayAll() {
		// TODO Auto-generated method stub
		return hs;
	}

	@Override
	public Employee getById(int ch) {
		// TODO Auto-generated method stub
		for(Employee e:hs) {
			if(e.getPid() == ch) {
				return  e;
			}
		}
		return null;
	}

	@Override
	public boolean deleteById(int ch) {
		// TODO Auto-generated method stub
		return hs.remove(new SalarisedEmployee(ch));
	}


	@Override
	public Set<Employee> sortBySalary() {
		// TODO Auto-generated method stub
		Comparator<Employee> mysal = (o1, o2) -> {
			double sal1 = 0, sal2 = 0;
			if(o1 instanceof SalarisedEmployee)
				sal1 = ((SalarisedEmployee) o1).getSal();
			else if(o1 instanceof ContractEmployee)
				sal1=((ContractEmployee) o1).getCharges();
			else
				sal1=((Vendor)o1).getAmount();
			
			if(o2 instanceof SalarisedEmployee)
				sal2 = ((SalarisedEmployee) o2).getSal();
			else if(o2 instanceof ContractEmployee)
				sal2=((ContractEmployee) o2).getCharges();
			else
				sal2=((Vendor) o2).getAmount();
			return (int)(sal1 - sal2);
		};
		TreeSet<Employee> ts=new TreeSet<>(mysal);
		for(Employee e:hs) {
			ts.add(e);
		}
		return ts;
	}

	@Override
	public Set<Employee> sortByName() {
		// TODO Auto-generated method stub
		TreeSet<Employee> ts = new TreeSet<>();
		for(Employee e: hs) {
			ts.add(e);
		}
		return ts;
	}

}
