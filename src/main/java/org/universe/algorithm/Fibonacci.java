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
        int F[][] = new int[][]{{1,1},{1,0}};
        if (n == 0)
            return 0;
        power(F, n-1);
        
        return F[0][0];
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
      
    public static void main (String args[]) {
        int n = 9;
        System.out.println(fib(n));
    }
}