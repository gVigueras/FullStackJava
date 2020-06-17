
public class Calculator {
	private double results = Double.NaN;
	private char operation = '\0';
	private boolean lastIsNumber = false;


	public void getResult() {
		System.out.println(results);	}

	public void performOperation(char operation) {
		this.operation = operation;
		lastIsNumber = false;
	}

	public void performOperation(double number) {
		if(lastIsNumber)
			return;
		if(Double.isNaN(results))
			results = number;
		else{
			results = operate(results, number, operation);
		}
		lastIsNumber = true;
	}

	private double operate(double a, double b, char c) {
		switch (c) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			return a/b;
		default:
			return Double.NaN;
		}
	}

}
