Here is a Java console application that solves the problem:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of balloons:");
        int n = scanner.nextInt();
        int[] nums = new int[n + 2];
        nums[0] = nums[n + 1] = 1;
        System.out.println("Enter the coins in each balloon:");
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left - 1] * nums[i] * nums[right + 1] + dp[left][i - 1] + dp[i + 1][right]);
                }
            }
        }
        System.out.println("The maximum number of coins is: " + dp[1][n]);
    }
}
```

This program first reads the number of balloons and the coins in each balloon from the user. It then calculates the maximum number of coins that can be obtained by bursting the balloons in a specific order. The order is determined by a dynamic programming approach, where for each possible length of a subarray of balloons, it tries to burst each balloon in the subarray last and keeps track of the maximum number of coins that can be obtained in this way. The result is the maximum number of coins that can be obtained by bursting all balloons.