public class A3_P2_NumWaysDP_RIVAS_JOSE { 

   public static String name = "RIVAS_JOSE";
   
   
   public static long numWaysDP(int n, int k, int [] D)   {
   
      long [][] ways = new long[n+1][k+1];

      ways[0][0] = 1;
      for (int i = 1; i <= n; i++) {
         ways[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= k; j++) {
             long waysWithoutMax = ways[i][j - 1];
             long waysWithMax = 0;
             if (i - D[j] >= 0) {
                 waysWithMax = ways[i - D[j]][j];
             }
             ways[i][j] = waysWithoutMax + waysWithMax;
         }
     }
      return ways[n][k];
   

   }
   
      
   public static long numWaysREC(int n, int k, int [] D)   {
   
   
       //n = cents
      //k = number of denminations
      if (n==1)
         return 1;
      if (n<0 || k<=0)
         return 0;
         
      long wayswithouthmax = numWaysDP(n,k-1, D);
      long wayswithmax = numWaysDP(n-D[k], k, D);
      return wayswithouthmax + wayswithmax;
   }
               
 
 
//********************************************************************
// DO NOT CHANGE ANYTHING BELOW THIS LINE!!!
//*********************************************************************   


	public static void main(String[] args)   {
      
      sopln("\n" + name);
      sopln("A3_P2, numWays to make change. Recursive vs. Dynamic Programming.");
      int [] D;
      int k, n;
      long ans, start, end;

      for (int j = 0; j < data.length; j++) {
  
         D = data[j];
         k = D.length - 1;
         n = D[0];

         sop("\nTest " + (j+1) + ". ");
         sop("n = " + n + ", k = " + k + ", D is ");
         printArray(k, D);
         sopln("\n");
         
         if (j < data.length - 2) {
            start = System.currentTimeMillis();
            ans = numWaysREC(n, k, D);         
            end = System.currentTimeMillis();
            sop("Number of ways using Divide and Conquer:  " + ans + ".  ");
            sopln("(This took " + (end - start) + " milliseconds.)");
         }
         
         start = System.currentTimeMillis();
         ans = numWaysDP(n, k, D);         
         end = System.currentTimeMillis();
         sop("Number of ways using Dynamic Programming: " + ans + ".  ");
         sopln("(This took " + (end - start) + " milliseconds.)");
         sopln("====================================================================");
      }
      


      sopln();  
   }



   public static void printArray(int n, int [] D)  {
     
      sop("{");
      for (int j = 1; j <= n-1; j++)
         sop(D[j] + ", ");
      sop(D[n] + "}");
   }

   
   
   public static int [][] data =  
     
     {
       {17, 1, 5, 10},
       
       {17, 3, 6, 10},
       
       {8, 1, 2, 3},
       
       {15, 2, 3, 4},       
       
       {21, 1, 7, 9},
       
       {18, 1, 7, 9},
       
       {93, 10, 15, 35, 57},
       
       {100, 3, 17, 29, 51, 53, 79},
       
       {100, 1, 5, 10, 25, 50},
      
       {100, 1, 2, 3, 4, 5},
       
       {1000, 1, 5, 10, 25, 50, 100},

       {500, 1, 2, 3, 4, 5},
       
       {1000, 1, 2, 4, 8, 16, 32, 64}, 
       
       {1200, 1, 2, 4, 8, 16, 32, 64}, 

       {1200, 1, 2, 4, 8, 16, 32, 64, 128}, 

       {2000, 1, 2, 4, 8, 16, 32, 64, 128, 256}, 
       
       {5000, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
 
     };    



   

   public static void sop(int a)
   {
      System.out.print(a);
   }
   
   public static void sopln(int a)
   {
      System.out.println(a);
   }
   
   public static void sop(double a)
   {
      System.out.print(a);
   }
   
   public static void sopln(double a)
   {
      System.out.println(a);
   }
   
   
   public static void sop(String s)
   {
      System.out.print(s);
   }
   public static void sopln(String s)
   {
      System.out.println(s);
   }
   public static void sopln()
   {
      System.out.println();
   }


} // end class

