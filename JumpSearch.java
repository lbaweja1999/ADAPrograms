package co.example.jumpsearch;
import java.util.*;
public class JumpSearch {

	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter number of elements:");
		int n=obj.nextInt();
		int a[]=new int[n];
		int blockSize = (int) Math.floor(Math.sqrt(n));
		int currentLastIndex = blockSize-1;
		for(int i=0;i<n;i++) {
			System.out.println("Enter "+(i+1)+" element:");
			a[i]=obj.nextInt();
		}
		Arrays.sort(a);
		System.out.println("Sorted array is:"+Arrays.toString(a));

		System.out.println("Enter the element you want to search");
	    int	x=obj.nextInt();
	    long start=System.currentTimeMillis();
	    
	    while (currentLastIndex < n && x > a[currentLastIndex]) {
	        currentLastIndex += blockSize;
	    }

	    for (int currentSearchIndex = currentLastIndex - blockSize + 1;
	         currentSearchIndex <= currentLastIndex && currentSearchIndex < n; currentSearchIndex++) {
	        if (x == a[currentSearchIndex]) {
	            System.out.println(x+" is at "+currentSearchIndex+" index.");
	        }
	        }
	   
		long end=System.currentTimeMillis();
System.out.println("Time taken by compiler is:"+(end-start)+"ms.");
	    
}

}
