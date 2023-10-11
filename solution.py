Here is a Python solution for the problem using dynamic programming:

```python
def maxCoins(nums):
    nums = [1] + nums + [1]
    n = len(nums)
    dp = [[0] * n for _ in range(n)]

    for left in range(n-2, -1, -1):
        for right in range(left+2, n):
            for i in range(left+1, right):
                dp[left][right] = max(dp[left][right], nums[left]*nums[i]*nums[right] + dp[left][i] + dp[i][right])
    return dp[0][n-1]

def main():
    nums = list(map(int, input("Enter the balloon numbers separated by space: ").split()))
    print("Maximum number of coins: ", maxCoins(nums))

if __name__ == "__main__":
    main()
```

This console application takes a list of balloon numbers as input and outputs the maximum number of coins that can be obtained by bursting the balloons in a specific order. The `maxCoins` function uses dynamic programming to solve the problem. It first adds 1 to the beginning and end of the list of balloon numbers, then initializes a 2D list `dp` with zeros. It then iterates over the list in reverse order, and for each pair of balloons, it calculates the maximum number of coins that can be obtained by bursting all balloons between them, including the left balloon but excluding the right balloon. The maximum number of coins is then stored in `dp[left][right]`. The function finally returns `dp[0][n-1]`, which is the maximum number of coins that can be obtained by bursting all balloons.