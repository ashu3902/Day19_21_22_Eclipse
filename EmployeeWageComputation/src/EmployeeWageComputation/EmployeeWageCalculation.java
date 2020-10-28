package EmployeeWageComputation;
import java.util.ArrayList;
import java.util.HashMap;
 class EmployeeWageCalculation implements EmployeeWageElements{
	 public static final int IS_FULL_TIME=1;
	 public static final int IS_PART_TIME=2;
	 int dailySalary;
	 ArrayList<Integer> dailyWage = new ArrayList<Integer>();
	 ArrayList<CompanyEmpWage> CompanyEmpWageArrayList;
	 HashMap<String, CompanyEmpWage> CompanyEmpWageMap;
	 
	 public EmployeeWageCalculation() {
		 CompanyEmpWageArrayList = new ArrayList<>();
		 CompanyEmpWageMap = new HashMap<>();
	 }
	 
	 public void dailyWage() {
		 dailyWage.add(dailySalary);
	 }
	 
	 public void addCompanyEmpWage(String company, int WagePerHr, int maxWorkingDays, int maxHrsPerMonth) {
		 CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, WagePerHr, maxWorkingDays, maxHrsPerMonth);
		 CompanyEmpWageArrayList.add(companyEmpWage);
		 CompanyEmpWageMap.put(company, companyEmpWage);
	 }
	 
	 public void computeEmpWage() {
		 for (int i=0;i < CompanyEmpWageArrayList.size();i++) {
			 CompanyEmpWage companyEmpWage = CompanyEmpWageArrayList.get(i);
			 companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
		 }
	 }
	 
	 public int computeEmpWage(CompanyEmpWage companyEmpWage) {
		 int empHrs=0;
		 int totalEmpHrs=0;
		 int totalWorkingDays=0;
		 while(totalEmpHrs <= companyEmpWage.maxHrsPerMonth && totalWorkingDays <= companyEmpWage.maxWorkingDays) {
			 totalWorkingDays++;
			 double empCheck = Math.floor(Math.random() * 10) % 3;
			 switch((int) empCheck) {
			 case IS_FULL_TIME:
				 System.out.println("Employee is Present full time");
				 empHrs=8;
				 break;
			 case IS_PART_TIME:
				 System.out.println("Employee is Present part time");
				 empHrs=4;
				 break;
			 default:
				 System.out.println("Employee is Absent");
				 empHrs=0;
			 }
			 int daySalary = empHrs * companyEmpWage.WagePerHr;
			 companyEmpWage.dailyWage.add(daySalary);
			 totalEmpHrs += empHrs;
			 System.out.println("Total Working days: "+totalWorkingDays+"/ Daily EmpHrs: "+empHrs+"/ Total Emp hours: "+totalEmpHrs);
		 }
		 System.out.println("\nTotalEmployeeWage: "+ (totalEmpHrs * companyEmpWage.WagePerHr)+"\n");
		 return totalEmpHrs * companyEmpWage.WagePerHr;
	 }
	 
	 public int getTotalEmpWage(String company) {
		 return CompanyEmpWageMap.get(company).totalEmpWage;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeWageCalculation empWageBuilder = new EmployeeWageCalculation();
		empWageBuilder.addCompanyEmpWage("SBI", 50, 20, 100);
		empWageBuilder.addCompanyEmpWage("AT&T", 40, 20, 100);
		empWageBuilder.addCompanyEmpWage("HDFC", 30, 20, 100);
		empWageBuilder.addCompanyEmpWage("Ola", 35, 30, 100);
		empWageBuilder.addCompanyEmpWage("JD", 45, 20, 100);
		empWageBuilder.computeEmpWage();
		System.out.println("Total wage of the company: "+empWageBuilder.getTotalEmpWage("HDFC"));
	}

	@Override
	public void addCompanyEmployeeWage(String company, int WagePerHr, int maxWorkingDays, int maxHrsPerMonth) {
		// TODO Auto-generated method stub
		
	}
}
