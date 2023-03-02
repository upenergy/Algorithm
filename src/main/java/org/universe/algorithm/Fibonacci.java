public class Fibonacci {
   public int fib(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n+2]; // 1 extra to handle case, n = 0
        int i;
        
        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;
        
        for (i = 2; i <= n; i++)
        {
        /* Add the previous 2 numbers in the series
            and store it */
            f[i] = f[i-1] + f[i-2];
        }
        
        return f[n];
    }


    public int fib(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n+2]; // 1 extra to handle case, n = 0
        int i;
        
        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;
        
        for (i = 2; i <= n; i++)
        {
        /* Add the previous 2 numbers in the series
            and store it */
            f[i] = f[i-1] + f[i-2];
        }
        
        return f[n];
    }

    public void multiply(int F[][], int M[][]) {
        int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
        int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
        int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
        int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];
        
        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }


    public void power(int F[][], int n) {
        int i;
        int M[][] = new int[][]{{1,1},{1,0}};
        
        // n - 1 times multiply the matrix to {{1,0},{0,1}}
        for (i = 2; i <= n; i++){
            multiply(F, M);
        }
    }

    public static void main (String args[]) {
        int n = 9;
        System.out.println(fib(n));
    }
}