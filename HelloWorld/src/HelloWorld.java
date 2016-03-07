import java.util.Properties;


public class HelloWorld {
	public static void main(String[] args) {
		//int arr[] = {3, 1, 4, 2, 2, 1};
		int arr[] = {3, 1, 2};
		int length = arr.length;
		System.out.println(findMin(arr, length));
		
		int [] arr2 =  {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(largestSumContigousArray(arr2));
	}
	
	public  static int largestSumContigousArray(int arr[]) {
		int maxSumSoFar = 0; 
		int maxSumEndingHere = 0;
		for(int i =0;i<arr.length;i++) {
			maxSumEndingHere = maxSumEndingHere + arr[i];
			
			if(maxSumEndingHere < 0) {
				maxSumEndingHere = 0;
			}
			
			if(maxSumSoFar < maxSumEndingHere) {
				maxSumSoFar = maxSumEndingHere;
			}
		}
		
		return maxSumSoFar;
	}

	public static int  findMinRec(int arr[],int i, int sumCalculated ,int sumTotal) {
		// If we have reached last element.  Sum of one
	    // subset is sumCalculated, sum of other subset is
	    // sumTotal-sumCalculated.  Return absolute difference
	    // of two sums.
	    if (i==0)
	        return Math.abs((sumTotal-sumCalculated) - sumCalculated);
	 
	 
	    // For every item arr[i], we have two choices
	    // (1) We do not include it first set
	    // (2) We include it in first set
	    // We return minimum of two choices
	    return min(findMinRec(arr, i-1, sumCalculated+arr[i-1], sumTotal),
	               findMinRec(arr, i-1, sumCalculated, sumTotal));
	}
	
	public static int min(int x, int y) {
		return x > y ? y : x;
	}
	
	public static int findMin(int arr[], int n)
	{
	    // Compute total sum of elements
	    int sumTotal = 0;
	    for (int i=0; i<n; i++)
	        sumTotal += arr[i];
	 
	    // Compute result using recursive function
	    return findMinRec(arr, n, 0, sumTotal);
	}
}
