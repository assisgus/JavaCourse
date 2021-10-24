package Application;

import java.io.Console;
import java.util.Locale;

import Entities.Matrix;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Console con = System.console();
		Matrix matrix;
		
		int line = Integer.parseInt(con.readLine("How many lines the matrix will have? "));
		int collumn = Integer.parseInt(con.readLine("How many collumns the matrix will have? "));
		matrix = new Matrix(line, collumn, con);
		matrix.input();
		matrix.search();
		
		
	}

}
