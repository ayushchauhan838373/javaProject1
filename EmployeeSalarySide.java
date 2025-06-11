package managerOfOffice;

public class EmployeeSalarySide extends ManagingEmployeeReports {
     private double baseSalary;
     public EmployeeSalarySide(double baseSalary) {
    	 this.baseSalary=baseSalary;
     }
     public EmployeeSalarySide(double salary, int leaves, int checkIn) {
	}
	public double calculateFinalSalary(){
    	 double salary = baseSalary;
    	 if(getTotalleavesIn_Month()>5) {
    		 salary-= baseSalary*0.05;
    	 }
    	 if(getCheckIn_time()>9) {
    		 System.out.println("your checkin time is late more than 5 times in a month");
    		 salary-=baseSalary*0.1;
    	 }
    	 return salary;
    	 
     }
    	
     
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

}
