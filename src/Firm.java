import java.util.Arrays;
import java.util.Comparator;

class Firm {

	private String Firmname;
	private Employee[] E;
	private int EmplAmount;
	
	public Firm (String Firmname, int MaxEmplAmount){
		this.Firmname = Firmname;
		this.EmplAmount = 0;
		this.E = new Employee[MaxEmplAmount];
	}
	

	public void add(Employee E){
		
		try {
			this.E[EmplAmount]= E;
			this.EmplAmount++;
		}
		
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Ir pârsniegts maksimâlais darbinieku daudzums!");
		}
	}
	
	
	public double getMaxSalary(){
		double MaxSalary = 0;
		double temp;
		int i = 0;
			
		while (i != EmplAmount) {
			temp = E[i].getSalary();
			if (temp > MaxSalary){
				MaxSalary = temp;
			}
			i++;
		}
		return MaxSalary;
	}
	
	
	public void sortSalariesAsc(){
		Arrays.sort(E,0,EmplAmount);
	}
	
	public void sortSalariesDesc(){
		Arrays.sort(E,0,EmplAmount,new SalDesc());
	}
	
	
	@Override
	public String toString() {
		String temp = ("Firma: " +Firmname+ " Darbinieku skaits: " +EmplAmount);
		StringBuilder SB = new StringBuilder(temp);
		
		SB.append(System.lineSeparator());		
		
		int i = 0;
		
		while (i != EmplAmount) {
			i++;
			SB.append("	" +i+". " +E[i-1]+ System.lineSeparator());			
			
		}
		temp = SB.toString();
		return temp;
	}

	class SalDesc implements Comparator {
		public int compare(Object O1, Object O2){
			double P1 = ((Employee) O1).getSalary();
			double P2 = ((Employee) O2).getSalary();
			return (P1>P2)?-1:((P1>P2)?1:0);
		}
		
		
	}

}
