package beans;

public class SalariedEmployee extends Employee {
	private double sal;
	private double bonus;
	public SalariedEmployee() {
		super();
	}
	public SalariedEmployee(int pid, String pname, String mobile, String email, String dept, String desg, double sal,
			double bonus) {
		super(pid, pname, mobile, email, dept, desg);
		this.sal = sal;
		this.bonus = bonus;
	}
	public SalariedEmployee(int pid) {
		super(pid);
		this.pid=pid;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return super.toString()+"SalarisedEmployee [sal=" + sal + ", bonus=" + bonus + "]";
	}
}
