package dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Comparator;

import beans.Employee;
import beans.ContractEmployee;
import beans.SalariedEmployee;


public class EmployeeDaoImpl implements EmployeeDao {
	
	static HashMap<Integer, Employee> mp;
	static {
		mp=new HashMap<>();
    	mp.put(12,new SalariedEmployee(12,"Rajat","4444","a@gmail.com","hr","associate",4556,345));
 		mp.put(13,new SalariedEmployee(13,"Ajit","555","a22@gmail.com","admin","associate",4577,377));
 		mp.put(14,new ContractEmployee(14,"Rajas","666","r345@gmail.com","admin","manager",30,4000));
 		mp.put(15,new ContractEmployee(15,"Ashwini","777","ashu@gmail.com","hr","associate",40,5000));
 		mp.put(16,new ContractEmployee(16,"Ashwini","777","ashu@gmail.com","hr","associate",40,5000));
	}
	
	@Override
	public void save(Employee e) {
		// TODO Auto-generated method stub
		if(!mp.containsKey(e.getPid())) {
			mp.put(e.getPid(), e);
		}
		
	}

	@Override
	public List<Employee> displayAll() {
		// TODO Auto-generated method stub
		List<Employee> lst = new ArrayList<>();
		for(Employee e:mp.values()) {
			lst.add(e);
		}
		return lst;
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return mp.get(id);
	}

	@Override
	public boolean updateSalById(int id, double sal) {
		// TODO Auto-generated method stub
		Employee ob = mp.get(id);
		if(ob!=null) {
			if(ob instanceof SalariedEmployee) {
				((SalariedEmployee)ob).setSal(sal);
			}else if(ob instanceof ContractEmployee) {
				((ContractEmployee)ob).setCharges(sal);
			}else {
				
			}
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> sortBySalary() {
		// TODO Auto-generated method stub
		Comparator<Employee> c = (o1, o2) -> {
			double sal1=0, sal2=0;
			if(o1 instanceof SalariedEmployee) {
				sal1 = ((SalariedEmployee) o1).getSal();
			}else if(o1 instanceof ContractEmployee) {
				sal1 = ((ContractEmployee) o1).getCharges();
			}else {
				//vendor
			}
			
			if(o2 instanceof SalariedEmployee) {
				sal2 = ((SalariedEmployee) o2).getSal();
			}else if(o2 instanceof ContractEmployee) {
				((ContractEmployee) o2).getCharges();
			}else {
				//vendor
			}
			return (int) (sal1 - sal2);
		};
		List<Employee> lst = new ArrayList<>();
		for(Employee e:mp.values()) {
			lst.add(e);
		}
		lst.sort(c);
		return lst;
	}

	@Override
	public TreeMap<Integer, Employee> sortById() {
		// TODO Auto-generated method stub
		TreeMap<Integer,Employee> tmp=new TreeMap<>();
		Set<Integer> s=mp.keySet();
		for(Integer i:s) {
			tmp.put(i, mp.get(i));
		}
		return tmp;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method 
		if(mp.containsKey(id))
			mp.remove(id);
		return true;
	}
	
	

}
