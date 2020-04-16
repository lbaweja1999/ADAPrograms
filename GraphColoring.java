package com.example.graphcoloring;
import java.util.*;

public class GraphColoring {

	 private int V, numOfColors;
	    private int[] color; 
	    private int[][] graph;
	 
	    public void graphColor(int[][] g, int noc)
	    {
	        V = g.length;
	        numOfColors = noc;
	        color = new int[V];
	        graph = g;
	 
	        try
	        {
	            solve(0);
	            System.out.println("No solution");
	        }
	        catch (Exception e)
	        {
	            System.out.println("\nSolution exists ");
	            display();
	        }
	    }
	    //assign colors recursively
	    public void solve(int v) throws Exception
	    {
	        // base case - solution found 
	        if (v == V)
	            throw new Exception("Solution found");
	        for (int c = 1; c <= numOfColors; c++)
	        {
	            if (isPossible(v, c))
	            {
	               
	                color[v] = c;
	                solve(v + 1);
	                
	                color[v] = 0;
	            }
	        }    
	    }
	   
	    public boolean isPossible(int v, int c)
	    {
	        for (int i = 0; i < V; i++)
	            if (graph[v][i] == 1 && c == color[i])
	                return false;
	        return true;
	    }
	   
	    public void display()
	    {
	        System.out.print("\nColors : ");
	        for (int i = 0; i < V; i++)
	            System.out.print(color[i] +" ");
	        System.out.println();
	    }    
	    
	    public static void main (String[] args) 
	    {
	        Scanner scan = new Scanner(System.in);
	        
	        GraphColoring gc=new GraphColoring();
	 
	        System.out.println("Enter number of vertices");
	        int V = scan.nextInt();
	
	        System.out.println("Enter matrix");
	        int[][] graph = new int[V][V];
	        for (int i = 0; i < V; i++)
	        {
	            for (int j = 0; j < V; j++)
	            {
	                graph[i][j] = scan.nextInt();
	            }
	        }
	        for (int i = 0; i < V; i++) {
	        	System.out.println();
	        
	            for (int j = 0; j < V; j++) {
	            	System.out.print(graph[i][j]+" ");
	            }
	        }
	 
	        System.out.println("\nEnter number of colors");
	        int c = scan.nextInt();
	        long start=System.currentTimeMillis();
	        gc.graphColor(graph, c);
	        long end=System.currentTimeMillis();
	        System.out.println("\nTime taken by compiler is "+(end-start)+"ms.");

	 
	    }
	}