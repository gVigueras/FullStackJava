public class FizzBuzz {
	public String fizzBuzz(int number) {
		String retorno="";
		if(number%3==0)
			retorno+="Fizz";
		if(number%5==0)
			retorno+="Buzz";
		if(retorno.equals(""))
			return String.valueOf(number);
		else
			return retorno;
	}
}
