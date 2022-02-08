import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the Department name: ");
        String department = sc.nextLine();
        System.out.println("Enter the worker data: ");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Level: ");
        String level = sc.next();
        System.out.print("Base Salary: ");
        Double baseSalary = sc.nextDouble();
        Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));

        System.out.println();
        System.out.println("How many contracts have this worker? ");
        int c  = sc.nextInt();
        for (int i = 1; i <= c ; i++) {
            System.out.println("Enter the contract #" + i +  " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date date = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.print("Hours: ");
            Integer hours = sc.nextInt();
            HourContract contract = new HourContract(date, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter the year and month to calculate the income (MM/YYYY): ");
        String incomeDate = sc.next();
        Integer month = Integer.parseInt(incomeDate.substring(0, 2));
        Integer year = Integer.parseInt(incomeDate.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + incomeDate + " :" + String.format("%.2f", worker.income(year, month)));
        sc.close();
    }
}
