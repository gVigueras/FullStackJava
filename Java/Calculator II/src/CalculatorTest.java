
public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		calc.performOperation(5);
		calc.performOperation('+');
		calc.performOperation(3);
		calc.performOperation('-');
		calc.performOperation(2);
		calc.performOperation('*');
		calc.performOperation(3);
		calc.performOperation('/');
		calc.performOperation(2);
		calc.getResult();
	}

}
