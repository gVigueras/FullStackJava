import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import sun.security.util.Length;

public class Rompecabezas {

	public static void main(String[] args) {
		Rompecabezas rc = new Rompecabezas();
		int a[] = new int[] {3,5,1,2,7,9,8,13,25,32};
		ArrayList<String> b = new ArrayList<String> (Arrays.asList("Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"));
		ArrayList<Integer> numeros = rc.greaterThan10(a);
		for (Integer integer : numeros) {
			System.out.println(integer);
		}
		ArrayList<String> c = rc.shuffleAndFindLargenThan5(b);
		for (String string : c) {
			System.out.println("| "+string+" |");
		}
		rc.shuffledAlphabet();
		rc.randomArray();
		rc.sortedArray();
		System.out.println(rc.generateRandomWord());
		ArrayList<String> words = rc.generateRandomWords();
		for (String string : words) {
			System.out.println(string);
		}
	}


	ArrayList<Integer> greaterThan10(int[] a) {
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
			if(a[i]>10)
				numeros.add(a[i]);
		}
		System.out.println("La suma es: "+sum);
		return numeros;
	}

	ArrayList<String> shuffleAndFindLargenThan5(ArrayList<String> a){
		ArrayList<String> nombresLargos = new ArrayList<String>();
		Collections.shuffle(a);
		for (String string : a) {
			System.out.println(string);
			if(string.length()>5)
				nombresLargos.add(string);
		}
		return nombresLargos;
	}

	void shuffledAlphabet(){
		ArrayList<Character> abc = new ArrayList<Character>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'));
		Collections.shuffle(abc);
		System.out.println("Primera letra: "+abc.get(0)+" | Última letra: "+abc.get(abc.size()-1));
		if(abc.get(0)=='a' || abc.get(0)=='e' || abc.get(0)=='i' || abc.get(0)=='o' || abc.get(0)=='u')
			System.out.println("¡La primera letra era vocal!");
	}

	ArrayList<Integer> randomArray(){
		Random r = new Random();
		ArrayList<Integer> rand = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			rand.add(r.nextInt(46)+55);
		}
		return rand;
	}

	ArrayList<Integer> sortedArray(){
		Random r = new Random();
		ArrayList<Integer> rand = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			rand.add(r.nextInt(46)+55);
		}
		Collections.sort(rand);
		for (Integer integer : rand) {
			System.out.println(integer);
		}
		System.out.println("El máximo es: "+rand.get(rand.size()-1)+" | El mínimo es: "+rand.get(0));
		return rand;
	}

	String generateRandomWord() {
		String word = "";
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			word+=(char)(r.nextInt(26) + 'a');
		}
		return word;
	}

	ArrayList<String> generateRandomWords() {
		Random r = new Random();
		String word;
		ArrayList<String> words = new ArrayList<String>();
		for (int j = 0; j < 10; j++) {
			word = "";
			for (int i = 0; i < 5; i++) {
				word+=(char)(r.nextInt(26) + 'a');
			}
			words.add(word);
		}
		return words;
	}
}
