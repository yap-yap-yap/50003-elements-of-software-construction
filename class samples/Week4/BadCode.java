//package Week4;

public class BadCode {    
	public static int div(int a, int b) {
		int division = 0;
		
		//sudiptac: you should throw an exception
		if (b == 0) {
    	throw new IllegalArgumentException("Denominator is 0");
	  }

		try { 
			division = a/b;
		} catch (Exception e) {
			//sudiptac: You should not do this
			//System.out.println("It is a VERY BAD Idea");
		}
		
		return division;
  }
}
