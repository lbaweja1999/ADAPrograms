package com.example.binaryknapsack;

import java.util.Scanner;

public class BinaryKnapsack {
    
	 int maximum(int x,int y) {
		if(x>y) {
			return x;
		}
		else {
			return y;
		}
	}
	 
	 int Knapsack(int x,int n,int wt[],int p[]) {
		 int j,i;
		 int K[][]=new int[n+1][x+1];
		 System.out.println("Knapsack table:-");
		 for (i = 0; i <=n; i++)
			 
		   {
			 System.out.println();
		       for (j = 0; j <= x; j++)
		       {
		           if (i==0 || j==0)
		               K[i][j] = 0;
		           else if (wt[i-1] <= j)
		                 K[i][j] = maximum(p[i-1] + K[i-1][j-wt[i-1]],  K[i-1][j]);
		           else
		                 K[i][j] = K[i-1][j];
		           System.out.print(K[i][j]+"\t");
		       }
		   }
		 System.out.println();
		   return K[n][x];
		 
	 }
	
	
	public static void main(String[] args) {
		BinaryKnapsack bk=new BinaryKnapsack();
		Scanner obj=new Scanner(System.in);
		int i, n,x;
		
		System.out.println("Enter the number of objects:");
		n=obj.nextInt();
		System.out.println("Enter the maximum weight ");
		x=obj.nextInt();

		int wt[]=new int[n];
		int p[]=new int[n];
		for(i=0;i<n;i++) {
			System.out.println("Enter the weight of object "+(i+1));
			wt[i]=obj.nextInt();
		}
		for(i=0;i<n;i++) {
			System.out.println("Enter the profit of object "+(i+1));
			p[i]=obj.nextInt();
		}
		
		long start=System.currentTimeMillis();
		System.out.println("Maximum profit is "+bk.Knapsack(x, n, wt, p));
		long end=System.currentTimeMillis();
		System.out.println("Time taken by compiler "+(end-start)+"ms");

	}

}
