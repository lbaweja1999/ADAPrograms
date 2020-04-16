package com.example.knapsack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		int n,m,i;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the number of objects ");
		n=obj.nextInt();
		System.out.println("_____________________________");
		double p[]=new double[n];
		double w[]=new double[n];
		double pw[]=new double[n];
		System.out.println("Enter maximum weight ");
		m=obj.nextInt();
		System.out.println("_____________________________");
		for(i=0;i<n;i++) {
			System.out.println("Enter the number of  weight "+(i+1));
			p[i]=obj.nextInt();
		}
		System.out.println("_____________________________");
		for(i=0;i<n;i++) {
			System.out.println("Enter the profit of  weight "+(i+1));
			w[i]=obj.nextInt();
			
		}
		System.out.println("Sorted P/W is ");
	for( i =0;i<n;i++) {
		pw[i]=p[i]/w[i];
	}
		Arrays.sort(pw);
		for(i=n-1;i>=0;i--) {
			System.out.print(pw[i]+"\t");
		}
		
	    
		
		
		

	}

}
