package com.example.insort;

import java.util.Scanner;

public class inssort {


	public static void main(String[] args) {
		int i,temp,j,n;
		int arr[]=new int[100];
		Scanner scan = new Scanner(System.in);
		   
	       System.out.print("Enter Array Size : ");
	       n = scan.nextInt();
		   
	       System.out.print("Enter  Elements : ");
	       for(i=0; i<n; i++)
	       {
	           arr[i] = scan.nextInt();
	       }
	
	       for(i=1; i<n; i++)
	       {
	           temp = arr[i];
	           j = i - 1;
	           while((temp < arr[j]) && (j >= 0))
	           {
	        	   
	               arr[j+1] = arr[j];
	               j = j - 1;
	           }
	           arr[j+1] = temp;
	       }
	       System.out.print("Array after Sorting is : \n");
	       for(i=0; i<n; i++)
	       {
	           System.out.print(arr[i] + "  ");
	       }

}}
