package com.example.TSP;
import java.util.*;
public class TSP {
	private int numberOfNodes;
    private Stack<Integer> stack;
 
    public TSP()
    {
        stack = new Stack<Integer>();
    }
 
    public void tsp(int adjacencyMatrix[][])
    {
        numberOfNodes = adjacencyMatrix[1].length - 1;
        int[] visited = new int[numberOfNodes + 1];
        visited[1] = 1;
        stack.push(1);
        int element, dst = 0, i;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        System.out.print(1 + "\t");
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = 1;
            min = Integer.MAX_VALUE;
            while (i <= numberOfNodes)
            {
                if (adjacencyMatrix[element][i] > 1 && visited[i] == 0)
                {
                    if (min > adjacencyMatrix[element][i])
                    {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag)
            {
                visited[dst] = 1;
                stack.push(dst);
                System.out.print(dst + "\t");
                minFlag = false;
                continue;
            }
            stack.pop();
        }
    }
 
    public static void main(String... arg)
    {
        int number_of_nodes;
        Scanner scanner = null;
        
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();
            int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 0; i < number_of_nodes; i++)
            {
                for (int j = 0; j < number_of_nodes; j++)
                {
                    adjacency_matrix[i][j] = scanner.nextInt();
                }
            }
            System.out.println("Adjacency matrix :");
            
            for(int i=0;i<number_of_nodes;i++) {
            	System.out.println();
            	
            	for(int j=0;j<number_of_nodes;j++) {
            	System.out.print(adjacency_matrix[i][j]+"\t");	
            	}
            }
            
            
            for (int i = 0; i < number_of_nodes; i++)
            {
                for (int j = 0; j < number_of_nodes; j++)
                {
                    if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0)
                    {
                        adjacency_matrix[j][i] = 1;
                    }
                }
            }
            
            TSP tsp=new TSP();
            long start=System.currentTimeMillis();
            System.out.println();
            System.out.println(" The cities are visited as follows:");
            tsp.tsp(adjacency_matrix);
           long end=System.currentTimeMillis();
           System.out.println();
           System.out.println(" Time taken by compiler:"+(end-start)+"ms.");
     
}}