package Entities;

import java.io.Console;

public class Matrix {
	private Integer line;
	private Integer collumn;
	private Number[][] matrix;
	private Console con;
	
	public Matrix(Integer line, Integer collumn, Console con) {
		this.line = line;
		this.collumn = collumn;
		this.con = con;
		matrix = new Number[line][collumn];
	}
	
	public Integer getLine() {
		return line;
	}
	public Integer getCollumn() {
		return collumn;
	}
	public Number[][] getMatrix() {
		return matrix;
	}

	public void search() {
		int toFind = Integer.parseInt(con.readLine("Which number want to find? "));
		for (int l = 0; l < line; l++) {
			for (int c = 0; c < collumn; c++) {
				Number number = matrix[l][c];
				if (toFind == number.getValue()) {
					con.printf(number.toString());
				}
			}
			
		}
	}
	
	public void input() {
		for (int l = 0; l < line; l++) {
			for (int c = 0; c < collumn; c++) {
				int value = Integer.parseInt(con.readLine("Insert a number in " + l + ", " + c + " position:"));
				Number number = new Number(value, l, c, this);
				matrix[l][c] = number;
			}
		}
	}
	
}
