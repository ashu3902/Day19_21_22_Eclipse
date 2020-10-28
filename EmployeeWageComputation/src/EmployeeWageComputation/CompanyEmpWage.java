package EmployeeWageComputation;
import java.util.ArrayList;

 class CompanyEmpWage {
	 public final String company;
	 public final int WagePerHr;
	 public final int maxWorkingDays;
	 public final int maxHrsPerMonth;
	 public int totalEmpWage;
	 ArrayList<Integer> dailyWage = new ArrayList<Integer>();
	 
	 public CompanyEmpWage(String company, int WagePerHr, int maxWorkingDays,int maxHrsPerMonth) {
		 this.company = company;
		 this.WagePerHr = WagePerHr;
		 this.maxWorkingDays = maxWorkingDays;
		 this.maxHrsPerMonth = maxHrsPerMonth;
	 }
	 public void setTotalEmpWage(int totalEmpWage) {
		 this.totalEmpWage = totalEmpWage;
	 }
	 public String toString() {
		 return  "Total wages for: "+ company + " is " + totalEmpWage;
	 }

}
