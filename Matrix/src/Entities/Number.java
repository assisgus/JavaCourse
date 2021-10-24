package Entities;

public class Number {
	private Integer value;
	private Integer positionLine;
	private Integer positionCollumn;
	private Matrix matrix;
	
	public Number(Integer value, Integer positionLine, Integer positionCollumn, Matrix matrix) {
		this.value = value;
		this.positionLine = positionLine;
		this.positionCollumn = positionCollumn;
		this.matrix = matrix;
	}

	public int getValue() {
		return value;
	}
	
	private String getTop() {
		if (positionLine -1 >= 0) {
			Number topNumber = matrix.getMatrix()[positionLine -1][positionCollumn];
			return String.format("The top value is: %d\n", topNumber.getValue());
		}
		return "The top position is out of the matrix\n";
	}
	private String getBottom() {
		if (positionLine +1 < matrix.getLine()) {
			Number bottomNumber = matrix.getMatrix()[positionLine +1][positionCollumn];
			return String.format("The bottom value is: %d\n", bottomNumber.getValue());
		}
		return "The bottom position is out of the matrix\n";
	}
	private String getRight() {
		if (positionCollumn + 1< matrix.getCollumn()) {
			Number rightNumber = matrix.getMatrix()[positionLine][positionCollumn + 1];
			return String.format("The right value is: %d\n", rightNumber.getValue());
		}
		return "The right position is out of the matrix\n";
	}
	private String getLeft() {
		if (positionCollumn - 1 >= 0) {
			Number leftNumber = matrix.getMatrix()[positionLine][positionCollumn -1];
			return String.format("The left value is: %d\n", leftNumber.getValue());
		}
		return "The left position is out of the matrix\n";
	}
	
	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append(String.format("The number %d in position %d, %d has the following neighboors: \n",
				value, positionLine, positionCollumn));
		text.append(getTop());
		text.append(getBottom());
		text.append(getRight());
		text.append(getLeft());
		return text.toString();
	}
}
