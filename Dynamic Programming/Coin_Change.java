/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*/
class Solution {
    public int[] bubbleSort(int arr[])
    {
        int flag = 0;
        for(int i = 0; i < arr.length-1; i++)
        {
            boolean swapped = false;
            for(int j = 0; j < arr.length-1-i; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false)
                break;
        }
        return arr;
    }
    
    public int coinChange(int[] coins, int amount) {
        Solution funcs = new Solution();
        coins = funcs.bubbleSort(coins);
        
        if(amount == 0)
            return 0;
        if(coins.length == 0 || coins.length > 0 && amount < coins[0])
            return -1;
        
        
        int[] arr = new int[amount+1];
        arr[0] = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(i == 0)
            {
                arr[i] = 0;
                continue;
            }
            if(i < coins[0])
                arr[i] = -1;
            int minCount = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++)
            {
                if(i == coins[j])
                {
                    arr[i] = 1;
                    break;
                }
                else
                {
                    if(coins[j] < i)
                    {    
                        if(minCount > arr[coins[j]] + (arr[i-coins[j]]) && arr[coins[j]] != -1 && arr[i-coins[j]] != -1)
                            minCount = arr[coins[j]] + (arr[i-coins[j]]);
//                        System.out.println("COINS: " + coins[j] + ", mincount: " + minCount);
                    }
                }
            }
            if(arr[i] == 0)
            {                 
                arr[i] = minCount;
                if(minCount < 0 || minCount == Integer.MAX_VALUE)
                    arr[i] = -1;
            }
            
//            System.out.println("I: " + i + ", val: " + arr[i]);
        }
//        System.out.println("VAL: " + arr[amount]);
        return arr[amount];
    }
}
