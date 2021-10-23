package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list =  new ArrayList<>();
		
		System.out.println("How many employees will register? ");
		int register = sc.nextInt();
		
		for (int c = 1; c <= register; c ++) {
			System.out.printf("\n=== Employee #%d ===", c);
			System.out.println("\nID: ");
			int id = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Name: ");
			String name = sc.nextLine();
			
			System.out.println("Salary: $");
			double salary = sc.nextDouble();
			
			Employee employee = new Employee(id, name, salary);
			list.add(employee);
		}
		System.out.println("What is the ID of employee who will get a salary increase? ");
		int id = sc.nextInt();
		if (getID(list, id) == null) {
			System.out.println("Invalid ID");
		}
		else {
			System.out.println("What is the increase percentage? ");
			double percentage = sc.nextDouble();
				for (Employee emp : list) {
					if (getID(list, id) == id);
					emp.increaseSalary(percentage);
			}
		}
		for (Employee emp : list) {
		System.out.print(emp);
		}
		sc.close();
	}
	
	public static Integer getID(List<Employee> list, int id) {
		for (int c = 0;  c < list.size(); c ++) {
			if (list.get(c).getId()== id) {
				return id;
			}	
		}
		return null;
		}
	}
	
	

