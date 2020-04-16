package com.example.selectionsort;

import java.util.Scanner;

public class Selectionsort {
    
	public static void main(String[] args) {
		int i,j,n,temp,min;
		int arr[]=new int[100];
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter size of array ");
		n=obj.nextInt();

		for(i=0;i<n;i++) {
			System.out.println("Enter element "+(i+1));
			arr[i]=obj.nextInt();
			
		}
		long start=System.currentTimeMillis();
		for(i=0;i<n-1;i++) {
			min=i;
			for(j=i+1;j<n;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
		long end=System.currentTimeMillis();
		System.out.println("Array after sorting :");
		for(i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
			
			}
		System.out.println("\n Time taken by compiler:"+(end-start)+"ms.");
		
	}

}
