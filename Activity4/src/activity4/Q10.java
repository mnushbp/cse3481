package activity4;

public class Q10 {
	
	public static void main(String[] args) {
		
		double total = 1;
		double prob = 1;
		
		for(double i = 1; i < 30; i++) {
			prob *= 1 - i/365;
		}
		
		total = 1 - prob;
		
		System.out.println(total); //a
		
		total = 0;
		prob = 1;
		double j = 0;
		
		while (total < 0.99) {
			prob *= 1 - ++j/365;
			total = 1-prob;
		}
		System.out.println(j--); //b
		System.out.println(total); //b
		
	}

}
//a) p = 0.706
//b) 56 people
//c) 365