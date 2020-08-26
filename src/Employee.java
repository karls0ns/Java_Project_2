class Employee extends Human implements Comparable{

	private double Salary;
	public Employee(String Name, String Surname, double Salary){
		super(Name, Surname);
		this.Salary = Salary;
	}
	
	public int compareTo (Object O){ 
		double P = ((Employee) O).Salary;
		
		return (Salary < P)?-1:((Salary > P)?1:0);
	} 
	
	public Employee(Employee E){
		super(E);
		this.Salary = E.Salary;
		
	}
	public double getSalary(){
		return Salary;		
	}
	public void setSalary(double Salary){
		this.Salary = Salary;
		
		
	}
	@Override
	public String toString() {
		return super.toString() + " Alga: " +Salary;
	}
}
