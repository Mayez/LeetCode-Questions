/*
PROBLEM:
Given an array of random numbers, Push all the zero’s of a given array to the end of the array. For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).

Example:

Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
Output : arr[] = {1, 2, 4, 3, 5, 0, 0};

Input : arr[]  = {1, 2, 0, 0, 0, 3, 6};
Output : arr[] = {1, 2, 3, 6, 0, 0, 0};
*/
class ZeroRight{
	public static void main(String[] args)
	{
		int arr[] = {1,9,8,4,0,0,2,7,0,6,0};
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == 0)
			{
				int nonzeroFlag = 0;
				for(int k = i; k < arr.length; k++)
				{
					if(arr[k] != 0)
						nonzeroFlag = 1;
				}
				if(nonzeroFlag == 1)
				{
					while(arr[i] == 0)
					{
						for(int j = i; j < arr.length-1; j++)
						{
							arr[j] = arr[j+1];
						}
						arr[arr.length-1] = 0;						
					}
				}

			}
		}
		for(int k = 0; k < arr.length; k++)
		{
			System.out.print(arr[k] + " ");
		}
		System.out.println();
	}
}
