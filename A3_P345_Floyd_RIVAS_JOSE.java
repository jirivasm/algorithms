public class A3_P345_Floyd_RIVAS_JOSE{  

   public static String name = "RIVAS_JOSE";
   
   
   public static int Floyd(int n, double [][] W, double [][] D, int [][] P) {

      //copy w into d and set p to 0
      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= n; j++) {
            D[i][j] = W[i][j];
            P[i][j] = 0;
         }
      }
      int i,j,k = 1;
      int count = 0;
      for (k = 1; k <= n; k++)
         for(i = 1; i<= n; i++)
            for (j = 1; j <= n; j++) {
               double temp = D[i][k] + D[k][j];
               if(temp<D[i][j] && temp!=0)
               {
                  D[i][j] = temp;
                  P[i][j] = k;
                  count++;
               }

               
            }
      return count;
   }
   
   public static void printPathWithEndpoints(int s, int d, int [][] P)  {

      int m = P[s][d];
      if(s==d)
      {
         System.out.println("V" + s+" and V"+ d +", are the same, no path needed");
      }
      else if(m!=0)
      {
         System.out.println("from V" + s+" to V"+d+", the shortest path is trough V"+m);
         printPathWithEndpoints(m, d, P);
         printPathWithEndpoints(s, m, P);
      }
      else
         System.out.println("from V" + s+" to V"+ d +", the shortest path is a direct path");



   }
   
   
   public static int maxEdgesInOneOptPath(int n, int [][] P) {

      int maxEdges = 0;

      for (int s=1;s<=n;s++)
         for (int d = 1; d <= n; d++) {
            int edges = numEdgesInOptPath(s,d,P);
            if(edges>maxEdges)
               maxEdges = edges;
         }

      return maxEdges;

   }
  public static int numEdgesInOptPath(int s, int d, int[][]P)
   {
      if(s==d)
         return 0;

      int m=P[s][d];
      if(m!= 0)
         return 1 + numEdgesInOptPath(m,d,P)+ numEdgesInOptPath(s,m,P);
      return 1;


   }



//********************************************************************
// DO NOT CHANGE ANYTHING BELOW THIS LINE, EXCEPT (see ^^^ in code below)
//
// for the last 2-D array in "data", if you do the extra credit.
//
//*********************************************************************   


	public static void main(String[] args)   {
   
      
      
      System.out.println("\n" + name);
      System.out.println("A3_P345, Floyd's Algorithm.\n");
      
      for (int t = 0; t < data.length; t++) {
      
         double [][] W = data[t];
         int n = W.length - 1;
         double [][] D = new double[n+1][n+1];
         int [][] P = new int[n+1][n+1];
         int numUpdates;
         
         numUpdates = Floyd(n, W, D, P);
                  
         sopln("\nTest " + (t+1) + ":  W is ");        
         printArray(n, W);
         
         sopln("\nTest " + (t+1) + ":  D is ");        
         printArray(n, D);  
                
         sopln("\nTest " + (t+1) + ":  P is ");        
         printArray(n, P);   
         sopln();
         sopln("Number of updates in Floyd's algorithm:  " + numUpdates + ".");
         
               
         sop("\nThe maximum number of edges in a least-cost path is:  ");
         sopln(maxEdgesInOneOptPath(n, P) + "\n");
      

         System.out.println("\nTest " + (t+1) + ":  All shortest paths: \n");
        
         for (int i = 1; i <= n; i++)  {
            for (int j = 1; j <= n; j++)  {
           
               printPathWithEndpoints(i, j, P);
               System.out.println();
            }
           
            System.out.println();
         }
         
         sopln("==================================================================\n");      
  
      }        
   }

   
   public static final double INF = Double.POSITIVE_INFINITY;

   
   public static double [][][] data =  
   
   {
   
      {
         {},
         {-1, 0,     10,   INF,     10,     50},
         {-1, 90,      0,     30,     20,   INF},
         {-1, INF,   INF,      0,     40,   INF},
         {-1, INF,   INF,     20,      0,     30},
         {-1, 30,   INF,   INF,     90,      0}
      },
      
      
      {
         {},
         {-1, 0,    220,     70,     40,     50,  INF,     80,    160,  INF,},
         {-1, 100,      0,  INF,     80,     70,     90,  INF,     80,    100},
         {-1, 70,  INF,      0,    110,  INF,     80,  INF,     70,  INF,},
         {-1, 40,     80,    110,      0,  INF,    100,     60,  INF,    150},
         {-1, 30,     20,     60,     80,      0,     10,     50,    120,     70},
         {-1, INF,     90,     80,     30,    150,      0,    130,  INF,    190},
         {-1, 80,  INF,  INF,     60,  INF,    130,      0,     20,    150},
         {-1, 160,     80,     70,  INF,    120,  INF,     20,      0,     60},
         {-1, INF,  INF,  INF,    150,  INF,    190,    150,     60,      0}
      },
      
 
      {
         {},
         {-1, 0,   INF,   INF,    200,     40,   INF,   INF,    140,   INF,},
         {-1, INF,      0,    100,   INF,   INF,   INF,   INF,     40,   INF,},
         {-1, INF,   INF,      0,   INF,   INF,   INF,     90,   INF,   INF,},
         {-1, INF,    180,   INF,      0,   INF,   INF,     50,   INF,   INF,},
         {-1, INF,   INF,     50,   INF,      0,   INF,   INF,   INF,     20},
         {-1, 140,   INF,   INF,   INF,   INF,      0,   INF,    200,   INF,},
         {-1, 30,   INF,   INF,    450,   INF,   INF,      0,   INF,   INF,},
         {-1, INF,    300,   INF,    150,   INF,    670,   INF,      0,   INF,},
         {-1, 170,   5550,     90,   INF,     50,   INF,     90,   INF,      0,}     
      },
      
      
// ^^^ Change the 5's in this last array for the extra credit problem
      
      {
         {},
         {-1, 0, INF, INF, 1},
         {-1, 5, 0,INF, INF},
         {-1, INF, 3, 0, INF},
         {-1, INF, INF, 4, 0}
      } 

   }; 
   
   
   
   
      
   
   
   
   public static void printArray(int n, double [][] A) {
      int i, j;
      System.out.println();
      System.out.print("    ");
      
      for (i = 1; i <= n; i++)
         System.out.printf("%7d", i);
      System.out.println("\n");

      for (i = 1; i <= n; i++) {
         System.out.printf("%4d", i);
         for (j = 1; j <= n; j++)
            if (A[i][j] == INF)
               System.out.print("    INF");
            else
               System.out.printf("%7.0f", A[i][j]);

         System.out.println();
      }
      
      System.out.println();
   }
   
               
   public static void printArray(int n, int [][] A) {
      int i, j;
      System.out.println();
      System.out.print("    ");
      
      for (i = 1; i <= n; i++)
         System.out.printf("%7d", i);
      System.out.println("\n");

      for (i = 1; i <= n; i++) {
         System.out.printf("%4d", i);
         for (j = 1; j <= n; j++)
            System.out.printf("%7d", A[i][j]);
         System.out.println();
      }
      
      System.out.println();
   }

    

   
   
   public static void printArray(int n, int [] A)  {
   
      for (int j = 0; j < n; j++)
         System.out.print(A[j] + " ");
      System.out.println();
   }
   

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

