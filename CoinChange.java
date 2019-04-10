import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CoinChange {

    // Complete the ways function below.
    static long ways(long n, long[] coins) {
        long[] solutionsTable = new long[(int)n + 1]; // + 1 because there is one way to make value of 0
        solutionsTable[0] = (long)1;
        int step = 0;
        for(int i = 0; i < coins.length; ++i) { // looping through coins
            for(int j = (int)coins[i]; j <= n; ++j) { // looping through sum of coins
                solutionsTable[j] += solutionsTable[j - (int)coins[i]];
                
                System.out.println("----------" + step + "-----------");
                System.out.println("Ultimate goal: " + n);
                System.out.println("Coins available: " + Arrays.toString(coins));

                System.out.println("Current coin: " + coins[i]);

                System.out.println("Current goal: " + j + "\n");
                System.out.println(Arrays.toString(solutionsTable) + "\n");
                step++;

            }
        }
        
        return solutionsTable[(int)n];
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] coins = new long[m];

        String[] coinsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int coinsItem = Integer.parseInt(coinsItems[i]);
            coins[i] = coinsItem;
        }

        long res = ways((long)n, coins);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

