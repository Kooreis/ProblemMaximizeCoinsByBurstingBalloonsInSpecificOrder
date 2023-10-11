Here is a C# console application that solves the problem:

```csharp
using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        int[] nums = {3, 1, 5, 8};
        Console.WriteLine(MaxCoins(nums));
    }

    public static int MaxCoins(int[] nums)
    {
        int[] array = new int[nums.Length + 2];
        int n = 1;
        foreach (var x in nums) if (x > 0) array[n++] = x;
        array[0] = array[n++] = 1;

        int[,] dp = new int[n,n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left)
            {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left, right] = Math.Max(dp[left, right], array[left] * array[i] * array[right] + dp[left, i] + dp[i, right]);
            }

        return dp[0, n - 1];
    }
}
```

This program uses dynamic programming to solve the problem. The `MaxCoins` function calculates the maximum number of coins that can be obtained by bursting the balloons in a specific order. The `Main` function reads the input array and calls the `MaxCoins` function to get the result.