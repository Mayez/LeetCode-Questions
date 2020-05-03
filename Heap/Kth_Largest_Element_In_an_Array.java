/*PROBLEM
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

To solve this question I utilized geeks for geeks heapsort tutorial on how to implement heapify and heapsort
for learning purposes only. This solution is not one of my own abilities, it was meant as a means for me 
to understand how to implement it but, it is still added on as an entry.
*/
class Solution {
    public void heapSort(int[] arr)
    {
        int n = arr.length;
        //build heap(max)
        for(int i = n/2-1; i >= 0; i--)
            heapify(arr,n,i);
        
        for(int i = n-1; i>=0; i--)
        {
            //Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //call max heapify on reduced loop
            heapify(arr,i,0);
        }
    }
    
    public void heapify(int[] arr, int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        
        if(l < n && arr[largest] < arr[l])
            largest = l;
        if(r < n && arr[largest] < arr[r])
            largest = r;
        //if largest is not root
        if(largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            //recursively heapify sub-tree
            heapify(arr,n,largest);
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        Solution funcs = new Solution();
        funcs.heapSort(nums);
        
  /*      for(int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");*/
        
        return nums[nums.length-1-(k-1)];
    }
}
