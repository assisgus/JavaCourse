package Application;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Console con = System.console();
		List<Employee> list = new ArrayList<>();

		String teste = con.readLine("How many employee want to register? ");
		int slot = Integer.parseInt(teste);

		for (int c = 1; c <= slot; c++) {
			con.printf("Employee #%s\n", c);
			int id = Integer.parseInt(con.readLine("ID: "));
			String name = con.readLine("Name: ");
			double salary = Double.parseDouble(con.readLine("Salary: $"));

			Employee emp = new Employee(id, name, salary);
			list.add(emp);
		}
		boolean foundId = false;
		while (!foundId) {
			int raiseId = Integer.parseInt(con.readLine("Which ID will have a raise? "));
			for (Employee emp : list) {
				if (raiseId == emp.getId()) {
					double percentage = Double.parseDouble(con.readLine("What is the raise percentage? "));
					emp.raiseSalary(percentage);
					foundId = true;
					break;
				}
			}
			if (!foundId) {
				con.printf("Invalid ID, try again\n");
			}
		}
		for (Employee emp : list) {
			con.printf(emp.toString());
		}
	}
}
