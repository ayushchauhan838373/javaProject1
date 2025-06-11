package managerOfOffice;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fileName = "Manager_reports.txt";

		try (FileWriter writer = new FileWriter(fileName, true)) {
			boolean addMore = true;

			while (addMore) {
				System.out.print("Enter Employee Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Position: ");
				String position = sc.nextLine();

				System.out.print("Enter Department: ");
				String department = sc.nextLine();

				System.out.print("Enter Employee Number: ");
				int empNum = Integer.parseInt(sc.nextLine());

				System.out.print("Enter Check-in Time (hour 0–23): ");
				int checkIn = Integer.parseInt(sc.nextLine());

				System.out.print("Enter Check-out Time (hour 0–23): ");
				int checkOut = Integer.parseInt(sc.nextLine());

				System.out.print("Enter Project Name: ");
				String project = sc.nextLine();

				System.out.print("Enter Phone Number: ");
				String phone = sc.nextLine();

				System.out.print("Enter Total Leaves in Month: ");
				int leaves = Integer.parseInt(sc.nextLine());

				System.out.print("Enter Total Experience (in years): ");
				int experience = Integer.parseInt(sc.nextLine());

				System.out.print("Enter Performance Grade (0.0 - 5.0): ");
				double grade = Double.parseDouble(sc.nextLine());

				System.out.print("Enter Base Salary (₹): ");
				double salary = Double.parseDouble(sc.nextLine());

				EmployeeSalarySide emp = new EmployeeSalarySide(salary, leaves, checkIn);

				// Set values
				emp.setEmployeeName(name);
				emp.setPositionInCompany(position);
				emp.setDepartment(department);
				emp.setEmployeeNumber(empNum);
				emp.setCheckIn_time(checkIn);
				emp.setCheeckOut_time(checkOut);
				emp.setProjectOn_Working(project);
				emp.setPhoneNumber(phone);
				emp.setTotalExperience(experience);
				emp.setPerformanceGrade(grade);
				emp.setBaseSalary(salary);

				double finalSalary = emp.calculateFinalSalary();
				int workingHours = emp.getCheeckOut_time() - emp.getCheckIn_time();

				// Write to file
				writer.write("====================================\n");
				writer.write("Employee Name: " + emp.getEmployeeName() + "\n");
				writer.write("Position: " + emp.getPositionInCompany() + "\n"); 
				writer.write("Department: " + emp.getDepartment() + "\n");
				writer.write("Employee Number: " + emp.getEmployeeNumber() + "\n");
				writer.write("Project: " + emp.getProjectOn_Working() + "\n");
				writer.write("Phone: " + emp.getPhoneNumber() + "\n");
				writer.write("Check-in Time: " + emp.getCheckIn_time() + ":00\n");
				writer.write("Check-out Time: " + emp.getCheeckOut_time() + ":00\n");
				writer.write("Working Hours: " + workingHours + " hrs\n");
				writer.write("Leaves This Month: " + emp.getTotalleavesIn_Month() + "\n");
				writer.write("Experience: " + emp.getTotalExperience() + " years\n");
				writer.write("Performance Grade: " + emp.getPerformanceGrade() + "\n");
				writer.write("Base Salary: ₹" + emp.getBaseSalary() + "\n");
				writer.write("Final Salary: ₹" + finalSalary + "\n");

				if (workingHours > 10) {
					writer.write("⚠ Note: Something fishy! Working hours exceed 10 hours.\n");
				}

				writer.write("====================================\n\n");

				System.out.println("✅ Report written successfully to: " + fileName);

				System.out.print("Do you want to add another employee? (yes/no): ");
				String choice = sc.nextLine().trim().toLowerCase();
				if (!choice.equals("yes")) {
					addMore = false;
				}
			}
		} catch (IOException e) {
			System.out.println("❌ Error writing report: " + e.getMessage());
		}

		sc.close();
	}
}