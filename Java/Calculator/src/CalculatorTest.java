
public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		calc.setOperandOne(12.5);
		calc.setOperandTwo(30.2);
		calc.setOperation('1');
		System.out.println(calc.getResult());
	}

}
