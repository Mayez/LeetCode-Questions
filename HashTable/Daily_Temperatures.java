/*PROBLEM
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
*/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] list = new int[T.length];
        int counter = 0;
        for(int i = 0; i < T.length; i++)
        {
            if(i+1 < T.length)
            {
                int count = i+1;
                while(count < T.length)
                {
                    if(T[count] > T[i])
                        break;
                    count++;
                }
                int diff = 0;
                if(count < T.length)
                    diff = count - i;
                else if(count == T.length)
                    diff = 0;
                list[counter] = diff;
                counter++;
            }
        }
        for(int k = 0; k < list.length; k++)
            System.out.println(list[k]);
        return list;
    }
}
