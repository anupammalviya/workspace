
public class FindNextInteger {
	public static void findNext(char[] number, int n) {
		int i;
		for( i=n-1;i>0;i--) {
			if(number[i] > number[i-1]) {
				break;
			}
		}
		
		if(i==0) {
			System.out.println("Not possible to write smaller number");
		}
		
		int x = number[i-1];
		int smallest = i;
		
		for(int j = i+1;j<n;j++) {
			if(number[j] > x && number[j] < number[smallest]) {
				smallest = j;
			}
		}
		
		char temp = number[smallest];
		number[smallest] = number[i-1];
		number[i-1] = temp;
		
		java.util.Arrays.sort(number, i, n);
		
		for(int j =0;j<number.length;j++) {
			System.out.print(number[j]);
		}
	}
	
	public static void main(String[] args) {
		char digits[] = "534976".toCharArray();
	    int n = digits.length;
	    //findNext(digits, n);
	    String x ="abc";
	    
	    String y ="def";
	    //x = x ^ y ^ (y=x);
	    //int x = 5, y = 10;
	    //  x = x ^ y ^ (y = x);
	      System.out.println("After Swapping values of x and y are "
	                          + x + " " + y);
	}
}
