
public class Calculator {
	private double operandOne = 0;
	private double operandTwo = 0;
	private double result;
	private char operation = '\0';

	public double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public double getResult() {
		switch (this.operation) {
		case '+':
			setResult(this.operandOne+this.operandTwo);
			break;
		case '-':
			setResult(this.operandOne-this.operandTwo);
			break;
		default:
			System.out.println("Operación inválida!");
			return Double.NaN;
		}
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}


}
