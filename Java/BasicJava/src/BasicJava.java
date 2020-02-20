
public class BasicJava {

	public static void main(String[] args) {
		BasicJava bj = new BasicJava();
		//bj.print1To255();
		//bj.printOdds();
		//bj.printSum();
		bj.printArray(bj.oddArray());
	}

	private void print1To255() {
		for (int i = 1; i <= 255; i++) {
			System.out.println(i);
		}
	}

	private void printOdds() {
		for (int i = 1; i <= 255; i+=2) {
			System.out.println(i);
		}
	}

	private void printSum() {
		int acum = 0;
		for (int i = 1; i <= 255; i++) {
			acum+=i;
			System.out.println("Nuevo número: "+i+" Suma: "+acum);
		}
	}

	private void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	private int findMax(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if(a[i]>max)
				max=a[i];
		}
		return max;
	}

	private int findAvg(int[] a) {
		int acum = 0;
		for (int i = 0; i <= a.length; i++) {
			acum+=i;
		}
		return acum/a.length;
	}

	private int[] oddArray() {
		int a[] = new int[128];
		for (int i = 0; i < 128; i++) {
			a[i]=2*i+1;
		}
		return a;
	}

	private int greaterThan(int[] a, int b) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]>b)
				count++;
		}
		return count;
	}

	private void square(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i]*a[i];
		}
	}

	private void negativeToZero(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if(a[i]<0)
				a[i] = 0;
		}
	}

	private int[] minMaxAvg(int[] a) {
		int min = a[0],max=a[0],avg=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]<min)
				min = a[i];
			if(a[i]>max)
				max = a[i];
			avg += a[i];
		}
		return new int[] {min,max,avg/a.length};
	}

	private void changeArray(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			a[i] = a[i+1];
		}
		a[a.length-2] = 0;
	}

}
