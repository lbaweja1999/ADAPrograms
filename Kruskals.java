package com.example.kruskal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kruskals {

	static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge); 
        }
        
        public void kruskalMST(){
            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));

            for (int i = 0; i <allEdges.size() ; i++) {
                pq.add(allEdges.get(i));
            }

            int [] parent = new int[vertices];

            makeSet(parent);

            ArrayList<Edge> mst = new ArrayList<>();

            int index = 0;
            while(index<vertices-1){
                Edge edge = pq.remove();
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);

                if(x_set==y_set){
                	
                }else {
                    mst.add(edge);
                    index++;
                    union(parent,x_set,y_set);
                }
            }
            
            System.out.println("Minimum Spanning Tree: ");
            printGraph(mst);
        }

        public void makeSet(int [] parent){
          
            for (int i = 0; i <vertices ; i++) {
                parent[i] = i;
            }
        }

        public int find(int [] parent, int vertex){
            
            if(parent[vertex]!=vertex)
                return find(parent, parent[vertex]);;
            return vertex;
        }

        public void union(int [] parent, int x, int y){
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
           
            parent[y_set_parent] = x_set_parent;
        }

        public void printGraph(ArrayList<Edge> edgeList){
            for (int i = 0; i <edgeList.size() ; i++) {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " source: " + edge.source +
                        " destination: " + edge.destination +
                        " weight: " + edge.weight);
            }
        }
    }
    public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEgde(4, 5, 67);
            graph.addEgde(3, 4, 7);
            graph.addEgde(2, 5, 5);
            graph.addEgde(1, 3, 2);
            graph.addEgde(3, 5, 45);
            graph.addEgde(0, 2, 32);
            graph.addEgde(0, 4, 63);
            long start=System.currentTimeMillis();
            graph.kruskalMST();
            long end = System.currentTimeMillis(); 
	        System.out.println(" Time taken by compiler " + 
	                                    (end - start) + "ms");

    }
}