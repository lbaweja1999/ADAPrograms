package com.example.quicksort;

import java.util.*;

public class Quicksort {

	 
		 public static void main(String[] args) {
		        int[] arr = {78,12,45,23,67,74,100,87,68};
		        System.out.println("Original array:");
		        System.out.println(Arrays.toString(arr));
		        long start=System.currentTimeMillis();
		        quickSort(arr, 0, arr.length-1);
		        long end=System.currentTimeMillis();
		        System.out.println("Sorted array:");
		        System.out.println(Arrays.toString(arr));
		        System.out.println("Time taken by compiler is:"+(end-start)+"ms.");
		    }
		 
		    public static void quickSort(int[] arr, int start, int end){
		 
		        int partition = partition(arr, start, end);
		 
		        if(partition-1>start) {
		            quickSort(arr, start, partition - 1);
		        }
		        if(partition+1<end) {
		            quickSort(arr, partition + 1, end);
		        }
		    }
		 
		    public static int partition(int[] arr, int start, int end){
		        int pivot = arr[end];
		 
		        for(int i=start; i<end; i++){
		            if(arr[i]<pivot){
		                int temp= arr[start];
		                arr[start]=arr[i];
		                arr[i]=temp;
		                start++;
		            }
		        }
		 
		        int temp = arr[start];
		        arr[start] = pivot;
		        arr[end] = temp;
		 
		        return start;
		    }
		}