package com.example.knapsack;

import java.util.*;

class node{
    int level;
    int profit;
    int weight;
    int bound;
}
public class KnapsackBranchbound {

	public static void main(String[] args) {
	      int maxProfit;
          int N;
          int W;
          int wt;
          int vl;
          int maxVal;

          Scanner input = new Scanner(System.in);

          System.out.println("Please enter the number of items: ");
          N = input.nextInt();
          System.out.println("Please enter the capacity of the Knapsack: ");
          W = input.nextInt();

          int[] Vl = new int[N];
          int[] Wt = new int[N];

          for(int i = 0; i < N; i++){
                  System.out.println("Please enter the weight acc value of item " + (i+1) + ": ");
                  wt = input.nextInt();
                  vl = input.nextInt();

                  Wt[i] = wt;
                  Vl[i] = vl;
          }


                  maxVal = knapsack(N, Vl, Wt, W);
          

          System.out.println("\nMaximum Profit is :"+maxVal);

  }


  public static int bound(node u, int n, int W, int[] pVa, int[] wVa){
          int j = 0, k = 0;
          int totweight = 0;
          int result = 0;

          if (u.weight >= W){
                  return 0;
          }
          else{
                  result = u.profit;
                  j = u.level + 1;
                  totweight = u.weight;

                  while ((j < n) && (totweight + wVa[j] <= W)){
                          totweight = totweight + wVa[j];
                          result = result + pVa[j];
                          j++;
                  }

                  k = j;

                  if (k < n){
                          result = result + (W - totweight) * pVa[k]/wVa[k];
                  }
                  return result;
          }
  }

  public static int knapsack(int n, int[] p, int[] w, int W){
          Queue<node> Q = new LinkedList<node>();
          node u = new node();
          node v = new node();
          int[] pV = new int[p.length];
          int[] wV = new int[w.length];
          Q.poll();

          for (int i = 0; i < n; i++){
                  pV[i] = p[i];
                  wV[i] = w[i];
          }

          v.level = -1;
          v.profit = 0;
          v.weight = 0;

          int maxProfit = 0;

          Q.add(v);

          while (Q.size() > 0){
                  v = Q.remove();

                  if (v.level == -1){
                          u.level = 0;
                  }
                  else if (v.level != (n - 1)){
                          u.level = v.level + 1;
                  }

                  u.weight = v.weight + w[u.level];
                  u.profit = v.profit + p[u.level];

                  u.bound = bound(u, n, W, pV, wV);

                  if (u.weight <= W && u.profit > maxProfit){
                          maxProfit = u.profit;
                  }

                  if (u.bound > maxProfit){
                          Q.add(u);
                  }



          }
          return maxProfit;
  }
}